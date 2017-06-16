package com.out.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.out.model.Admin;

/**
 * Created by lmy on 2017/6/15.
 */
public class AdminValidator extends Validator {
    protected void validate(Controller controller) {
        validateRequiredString("adminname", "adminnameMsg", "管理员不能为空！");
        validateRequiredString("adminpassword", "adminpasswordMsg", "管理员密码不能为空！");
    }

    protected void handleError(Controller controller) {
        controller.keepModel(Admin.class);
        controller.setAttr("adminname", controller.getPara("adminname"));
        controller.render("adminLogin.html");
    }
}
