package com.out.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.out.model.CheckDate;
import com.out.model.Notice;
import com.out.model.User;
import com.out.model.UserDetail;
import com.out.service.*;
import com.out.service.impl.*;
import com.out.util.ExcelUtil;
import com.out.util.FileUtil;
import com.out.validator.AdminValidator;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public class AdminControoler extends Controller {

    private UserService userService = new UserServiceImpl();
    private AdminService adminService = new AdminServiceImpl();
    private UserDetailService detailService = new UserDetailServiceImpl();
    private NoticeService noticeService = new NoticeServiceImpl();
    private CheckDateService checkDateService = new CheckDateServiceImpl();

    //登陆
    public void login() {
        render("adminLogin.html");
    }


    //管理员登陆
    @Before(AdminValidator.class)
    public void adminLoginSubmmit() throws Exception {

        String adminname = getPara("adminname");
        String adminpassword = getPara("adminpassword");

        if (adminService.exist(adminname)) {
            if (adminService.passwordCorrect(adminname, adminpassword)) {
                setSessionAttr("login", "admin");
                list();
            } else {
                setAttr("message", "密码错误！");
                setAttr("adminname", adminname);
                render("adminLogin.html");
            }

        } else {
            setAttr("message", "管理员不存在！");
            render("adminLogin.html");
        }
    }

    //列出用户
    public void list() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int pageNumber;
        if (getParaToInt(0) != null) {
            pageNumber = getParaToInt(0);

        } else {
            pageNumber = 1;
        }
        setAttr("pageNumber", pageNumber);

        List<User> users = userService.listByPage(pageNumber);
        setAttr("users", users);

        StringBuffer filesName = new FileUtil().listFiles("web/upload");
        setAttr("filesName", filesName);

        render("crud.html");
    }

    //删除
    public void delete() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int id = getParaToInt(0);
        userService.deleteById(id);
        redirect("/admin/list");
    }

    //更新
    public void update() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int id = getParaToInt(0);
        User user = userService.findById(id);
        setAttr("user", user);
        render("update.html");
    }

    //更新成功
    public void updateSuccess() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        User user = getModel(User.class);
        UserDetail detail = getModel(UserDetail.class);
        String username = user.get("username");

        if (userService.exist(username)) {
            userService.update(user);
            detailService.update(detail);
            User user2 = userService.findById((Integer) user.get("id"));
            setAttr("user", user2);
            setAttr("message", "更新成功！");
            list();
        } else {
            User user2 = userService.findById((Integer) user.get("id"));
            setAttr("user", user2);
            setAttr("message", "用户名已被注册！");
            render("update.html");
        }
    }

    //通过姓名查找用户
    public void findByName() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        String name = getPara("name");
        if (name == null || name.trim().equals("")) {
            setAttr("error", "搜索内容不能为空！");
            list();
        } else {
            User user = userService.findByName(name);
            setAttr("users", user);
            render("crud.html");
        }
    }
    //导出到excel
    public void export() throws IOException {
        Workbook workbook = ExcelUtil.exportToExcel("exportTemplate.xls", userService.list());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/result.xls"));
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        renderText("success!");
    }

    //删除库中的文件
    public void deleteFile() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        String fileName = getPara("deleteFileName").trim();
        File file = new File("web/upload/userFile/" + fileName);
        if (file.exists()) {
            boolean success1 = file.delete();
//            boolean success2 = fileDao.deleteByName(fileName);

            //TODO 从数据库中删除

            if (success1) {
                setAttr("result", "删除成功！");

            } else {
                setAttr("result", "删除失败！");
            }
            list();
            return;
        } else {
            setAttr("error", "所要删除的文件不存在！");
            list();
            return;
        }
    }

    //修改公告
    public void modifyNotice() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int id = getParaToInt(0);
        Notice notice = noticeService.findById(id);
        setAttr("notice", notice);
        render("modifyNotice.html");
    }

    //修改公告成功
    public void modifyNoticeSuccess() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int id = getParaToInt("id");
        String content = getPara("notice");
        Db.update("UPDATE t_notice SET notice=? WHERE id=?", content, id);
        listNotice();
    }

    //添加公告
    public void addNotice() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        Notice notice = getModel(Notice.class);
        notice.save();
        setAttr("message", "添加成功！");
        render("notice.html");
    }

    //删除公告
    public void deleteNotice() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int id = getParaToInt(0);
        noticeService.deleteById(id);
        listNotice();
    }

    //列出公告
    public void listNotice() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        List<Notice> notices = noticeService.listNotices();
        setAttr("notices", notices);
        render("notice.html");
    }

    //列出签到情况
    public void listCheckedDays() {
        if (getSessionAttr("login")==null) {
            redirect("/admin/login");
            return;
        }
        int userId = getParaToInt(0);
        List<CheckDate> checkDates = checkDateService.listCheckedDays(userId);
        setAttr("checkedDays", checkDates);
        render("checkedDays.html");
    }

}
