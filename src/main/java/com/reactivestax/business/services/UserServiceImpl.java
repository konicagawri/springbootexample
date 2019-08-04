package com.reactivestax.business.services;

import com.reactivestax.business.model.LoginModelObject;
import com.reactivestax.business.model.RegisterModelObject;
import com.reactivestax.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    public void register(RegisterModelObject registerModelObject)
    {

        userDao.register(registerModelObject);
    }


    public RegisterModelObject validateUser(LoginModelObject loginModelObject)
    {
        return userDao.validateUser(loginModelObject);
    }

}





