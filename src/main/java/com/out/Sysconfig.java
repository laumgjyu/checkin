package com.out;

import com.jfinal.config.*;
import com.jfinal.core.Const;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.out.controller.AdminControoler;
import com.out.controller.UserController;
import com.out.model.*;

/**
 * Created by lmy on 2017/3/24.
 */
public class Sysconfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("prop.properties");
        constants.setDevMode(true);
        //更改上传文件大小的限制
        constants.setMaxPostSize(Const.DEFAULT_MAX_POST_SIZE * 10);
//        constants.setBaseDownloadPath(Const.DEFAULT_BASE_UPLOAD_PATH + "/userFile");
//        constants.setBaseUploadPath("WEB-INF/upload");

    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", UserController.class);
        routes.add("/admin", AdminControoler.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        String url = PropKit.get("jdbcUrl");
        String username = PropKit.get("user");
        String password = PropKit.get("password");
        DruidPlugin dp = new DruidPlugin(url, username, password);

        plugins.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
        arp.setShowSql(true);//显示sql语句
        arp.addMapping("t_user", User.class);
        arp.addMapping("t_admin", Admin.class);
        arp.addMapping("t_userDetail", "d_id",UserDetail.class);
        arp.addMapping("t_file", File.class);
        arp.addMapping("t_notice", Notice.class);
        arp.addMapping("t_checkDate", CheckDate.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
