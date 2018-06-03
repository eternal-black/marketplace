package com.marketplace.bean;

import com.marketplace.entity.User;
import com.marketplace.util.DBUtil;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "userBean")
@SessionScoped
public class UserBean {

    @Getter @Setter private User currentUser = new User();

    public String authorization() {
        try {
            currentUser = DBUtil.getUser(currentUser.getLogin(), currentUser.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String registration() {
        try {
            DBUtil.addUser(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateAccount() {
        try {
            DBUtil.updateUser(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteAccount() {
        try {
            DBUtil.delete(currentUser);
            currentUser = new User();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
