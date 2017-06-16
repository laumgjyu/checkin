package com.out.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.out.model.Notice;
import com.out.model.User;
import com.out.model.UserDetail;
import com.out.service.CheckDateService;
import com.out.service.NoticeService;
import com.out.service.UserService;
import com.out.service.impl.CheckDateServiceImpl;
import com.out.service.impl.NoticeServiceImpl;
import com.out.service.impl.UserServiceImpl;
import com.out.util.FileUtil;
import com.out.validator.UserValidator;

import java.io.File;
import java.util.List;


public class UserController extends Controller {

    UserService userService = new UserServiceImpl();
    NoticeService noticeService = new NoticeServiceImpl();
    CheckDateService checkDateService = new CheckDateServiceImpl();

    public void index() {
        render("index.html");
    }

    //注册界面
    public void register() {
        render("register.html");
    }

    //注册验证
    public void registerSubmmit() {
        //jfinal实现文件上传要导入cos的包!!!!!!
        //获取参数
        UploadFile uploadFile = getFile("head");
        String imgPath = "/upload/" + uploadFile.getFileName();
        User user = getModel(User.class);
        UserDetail detail = getModel(UserDetail.class);
        String username = user.get("username");

        try {
            if (userService.exist(imgPath, username, user, detail)) {
                setAttr("message", "用户名已被注册！");
                render("register.html");
            } else {
                setAttr("username", username);
                render("register_success.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //登陆
    public void login() {
        if (getSessionAttr("login") != null) {
            redirect("/loginSubmmit");
            return;
        }

        render("login.html");
    }

    //登陆验证
    @Before(UserValidator.class)
    public void loginSubmmit() throws Exception {
        String username = getPara("username");
        String password = getPara("password");

        if (getSessionAttr("login") != null) {
            loginSuccess((String) getSessionAttr("login"));
            return;
        }

        if (!userService.exist(username)) {
            setAttr("message", "用户名不存在！");
            render("login.html");
        } else {
            if (userService.passwordCorrect(username, password)) {
                loginSuccess(username);
            } else {
                setAttr("message", "密码错误！");
                setAttr("username", username);
                render("login.html");
            }
        }
    }

    private void loginSuccess(String username) {
        String path = new FileUtil().getPath("upload");
        StringBuffer filesName = new FileUtil().listFiles(path + "/" + username);

        setAttr("filesName", filesName);

        setSessionAttr("login", username);

        List<Notice> notices = noticeService.listNotices();
        setAttr("notices", notices);
        render("login_success.html");
    }

    //登退
    public void logout() {
        if (getSessionAttr("login")!=null) {
            setSessionAttr("login", null);
            redirect("/index");
        }
    }

    public void changPassword() throws Exception {
        String username = getPara("username");
        String password1 = getPara("password1");
        String password2 = getPara("password2");
        if (!password1.equals(password2)) {
            setAttr("message", "两次输入的密码不一致！");
        } else {
            int result=userService.changPassword(username,password1);
            if (result != 0) {
                setAttr("message", "更改成功！");
            } else {
                setAttr("message", "更改失败！");
            }
        }
        redirect("/login");
    }

    public void changPasswordSuccess() {

    }

    //文件上传
    public void doUpload() {

        if (getSessionAttr("login") == null) {
            redirect("/login");
            return;
        }

        String username = getPara(0);
        StringBuffer filesName = new FileUtil().listFiles("web/upload/" + username);
        UploadFile uploadFile = getFile("file", "/" + username);
        File file = null;

        if (uploadFile == null) {
            setAttr("msg", "请选择你要上传的文件！");
            setAttr("login", "true");
            setAttr("filesName", filesName);
            setAttr("username", username);
            List<Notice> notices = noticeService.listNotices();
            setAttr("notices", notices);
        } else {
            file = uploadFile.getFile();
//
//将文件路径存到数据库中
//            String fileName = file.getName();
//            String url = "web/upload/userFile/" + file.getName();
//            com.out.model.File fileModel = new com.out.model.File();
//            fileModel.set("fileName", fileName);
//            fileModel.set("url", url);
//            fileModel.save();

            setAttr("msg", "上传成功！");
            setAttr("login", "true");
            setAttr("filesName", filesName);
            setAttr("username", username);


            List<Notice> notices = noticeService.listNotices();
            setAttr("notices", notices);

        }

        render("login_success.html");
    }

    //文件下载
    public void doDownload() {
        String name = getPara("fileName");
        renderFile(name);
    }


    //用户签到
    public void check() {

        if (getSessionAttr("login") == null) {
            redirect("/login");
            return;
        }
        String username = getPara(0);
        if (checkDateService.idChecked(username)) {
            setAttr("message", "已经签过到！");
            renderText("已经签过到！");
        } else {
            setAttr("message", "签到成功！");
            renderText("签到成功！");
        }
    }
}
