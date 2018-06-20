package com.marketplace.bean;

import com.marketplace.domain.User;
import com.marketplace.service.UserService;
import com.marketplace.service.impl.UserServiceImpl;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "userBean")
@RequestScoped
public class UserBean {

    @ManagedProperty(value = "#{sessionBean}")
    @Getter @Setter
    private SessionBean sessionBean;

    @Getter @Setter
    private UserService userService = new UserServiceImpl();


    public String authorization() {
        try {
            sessionBean.setCurrentUser(userService.get(
                    sessionBean.getCurrentUser().getLogin(),
                    sessionBean.getCurrentUser().getPassword()));
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public String registration() {
        try {
            userService.add(sessionBean.getCurrentUser());
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public String updateAccount() {
        try {
            userService.update(sessionBean.getCurrentUser());
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public String deleteAccount() {
        try {
            userService.delete(sessionBean.getCurrentUser());
            sessionBean.setCurrentUser(new User());
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    public String logout() {
        return "success";
    }
}
