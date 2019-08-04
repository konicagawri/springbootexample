package com.reactivestax.business.services;


import com.reactivestax.business.model.LoginModelObject;
import com.reactivestax.business.model.RegisterModelObject;

public interface UserService {

  void register(RegisterModelObject registerModelObject);

  RegisterModelObject validateUser(LoginModelObject loginModelObject);
}
