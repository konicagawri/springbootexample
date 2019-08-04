package com.reactivestax.dao;


import com.reactivestax.business.model.LoginModelObject;
import com.reactivestax.business.model.RegisterModelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public void register(RegisterModelObject registerModelObject) {
    String sql = "insert into users values(?,?,?,?,?,?,?)";

  jdbcTemplate.update(sql,new Object[] {
          registerModelObject.getUserName(),
          registerModelObject.getPassword(),
          registerModelObject.getFirstName(),
          registerModelObject.getLastName(),
          registerModelObject.getEmail(),
          registerModelObject.getAddress(),
          registerModelObject.getPhoneNo()
  });
  }

  @Override
  public RegisterModelObject validateUser(LoginModelObject loginModelObject) {
    String sql = "select * from users where username='" + loginModelObject.getUserName() + "' and password='"
            +loginModelObject.getPassword() + "'";

    List<RegisterModelObject> registerModelObjects =  jdbcTemplate.query(sql, new UserMapper());
    return registerModelObjects.size() > 0 ? registerModelObjects.get(0) : null;
  }
}

class UserMapper implements RowMapper<RegisterModelObject> {

  public RegisterModelObject mapRow(ResultSet rs, int arg1) throws SQLException {
    RegisterModelObject registerModelObject = new RegisterModelObject();

    registerModelObject.setUserName(rs.getString("username"));
    registerModelObject.setPassword(rs.getString("password"));
    registerModelObject.setFirstName(rs.getString("firstname"));
    registerModelObject.setLastName(rs.getString("lastname"));
    registerModelObject.setEmail(rs.getString("email"));
    registerModelObject.setAddress(rs.getString("address"));
    registerModelObject.setPhoneNo(rs.getInt("phone"));
    return registerModelObject;
  }
}