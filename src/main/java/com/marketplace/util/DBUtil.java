package com.marketplace.util;

import com.marketplace.dao.*;
import com.marketplace.dao.impl.*;
import com.marketplace.domain.*;

public class DBUtil {

    private static UserDAO userDAO = new UserDAOImpl();
    private static AddressDAO addressDAO = new AddressDAOImpl();

    // TODO: remove after adding of services layer
    public static User getUser(String login, String password) {
        try {
            return userDAO.get(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAddress(Address address){
        try {
            addressDAO.addAddress(address);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Address getAddressById(int id) throws Exception {
        try {
            return addressDAO.getAddress(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
