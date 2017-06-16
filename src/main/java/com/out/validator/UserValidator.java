package com.out.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.out.model.User;

/**
 * Created by lmy on 2017/6/15.
 */
public class UserValidator extends Validator {
    protected void validate(Controller controller) {
        if (getController().getSessionAttr("login") == null) {
            validateRequiredString("username", "usernameMsg", "用户名不能为空！");
            validateRequiredString("password", "passwordMsg", "密码不能为空！");
        }
    }

    protected void handleError(Controller controller) {
        controller.keepModel(User.class);
        controller.setAttr("username", controller.getPara("username"));
        controller.render("login.html");
    }
}
