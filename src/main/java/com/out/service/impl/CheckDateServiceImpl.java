package com.out.service.impl;

import com.out.dao.CheckDateDao;
import com.out.dao.UserDao;
import com.out.dao.impl.CheckDateDaoImpl;
import com.out.model.CheckDate;
import com.out.model.User;
import com.out.service.CheckDateService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public class CheckDateServiceImpl implements CheckDateService {
    CheckDateDao dao = new CheckDateDaoImpl();

    public boolean idChecked(String username) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(date);

        List<CheckDate> checkDates = dao.findByName(username);

        boolean isChecked = false;
        Date check = null;
        System.out.println(checkDates);
        if (checkDates != null) {
            int u_id = -1;
            for (CheckDate checkDate : checkDates) {
                check = checkDate.getDate("checkDate");
                u_id = checkDate.getInt("u_id");
                if (check != null && dateStr.equals(dateFormat.format(check))) {
                    System.out.println(u_id);
                    isChecked = true;
                    return true;
                }
            }
                dao.checkin(u_id, dateStr);
        } else {
            User user = UserDao.dao.findFirst("SELECT * FROM t_user WHERE username=?", username);
            int u_id = user.getInt("id");
            dao.checkin(u_id, dateStr);
        }
        return isChecked;
    }

    public List<CheckDate> listCheckedDays(int id) {
        List<CheckDate> checkDates = dao.listCheckedDays(id);
        return checkDates;
    }
}
