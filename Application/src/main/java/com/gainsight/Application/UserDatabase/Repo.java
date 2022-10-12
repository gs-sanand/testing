package com.gainsight.Application.UserDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class Repo {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  //Creating Table
  public void createTable() {
    String query = "create table gsuser(username varchar(50), purpose varchar(50),prodready boolean, frequency integer)";
    int update = this.jdbcTemplate.update(query);
    System.out.println(update);
  }

  //inserting data to db
  public int insertData(String user_id, String username, String department, String email) {
    String q = "select count(*) from gsuser where user_id='" + user_id + "'";
    if ((Long) this.jdbcTemplate.queryForMap(q).get("count") == 0) {
      String query = "insert into gsuser(user_id, username, department, email) values(?,?,?,?)";
      int update = this.jdbcTemplate.update(query, user_id, username, department, email);
      //System.out.println(update);
      return (1);
    } else {
      return (0);
    }

  }

  public int updateData(String user_id, String username, String department, String email) {
    String q = "select count(*) from gsuser where user_id='" + user_id + "'";
    if ((Long) this.jdbcTemplate.queryForMap(q).get("count") == 1) {
      String query = "update gsuser set username='" + username + "', department='" + department + "', email='" + email + "' where user_id='" + user_id + "'";
      int update = this.jdbcTemplate.update(query);
      return (1);
    } else {
      return (0);
    }

  }

  //getting data from db
  public Map getData(String user_id) {
    String q = "select * from gsuser where user_id='" + user_id + "'";
    try {

      Map x = this.jdbcTemplate.queryForMap(q);

      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", x);
      message.put("message", "User Data");
      return (message);
    } catch (Exception e) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "UserId not Exist");
      return (message);
    }
  }

  public int deleteData(String user_id) {
    String q = "select count(*) from gsuser where user_id='" + user_id + "'";
    if ((Long) this.jdbcTemplate.queryForMap(q).get("count") == 1) {
      String query = "delete from gsuser where user_id='" + user_id + "'";
      int update = this.jdbcTemplate.update(query);
      return (1);
    } else {
      return (0);
    }
  }
}
