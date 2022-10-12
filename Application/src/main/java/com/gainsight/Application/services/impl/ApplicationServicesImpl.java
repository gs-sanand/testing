package com.gainsight.Application.services.impl;

import com.gainsight.Application.Pojo.GSUser;
import com.gainsight.Application.UserDatabase.Repo;
import com.gainsight.Application.services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ApplicationServicesImpl implements ApplicationServices {

  @Autowired
  private Repo databaseOperation;

  @Override
  public Map getData(String user_id) {
    Map data = this.databaseOperation.getData(user_id);
    return (data);
  }

  @Override
  public ResponseEntity<?> deleteData(String user_id) {
    int res = this.databaseOperation.deleteData(user_id);

    if (res == 1) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "User Deleted");
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    } else {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "User Not Exist");
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }

  }

  @Override
  public ResponseEntity<?> insertData(GSUser gsUser) {
    int res = this.databaseOperation.insertData(gsUser.getUser_id(), gsUser.getUsername(), gsUser.getDepartment(), gsUser.getEmail());

    if (res == 1) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", gsUser);
      message.put("message", "User Created");
      return ResponseEntity.status(HttpStatus.CREATED).body(message);
    } else {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "UserId Already Exist");
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
  }

  @Override
  public ResponseEntity<?> updateData(GSUser gsUser) {

    int res = this.databaseOperation.updateData(gsUser.getUser_id(), gsUser.getUsername(), gsUser.getDepartment(), gsUser.getEmail());

    if (res == 1) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", gsUser);
      message.put("message", "User Updated");
      return ResponseEntity.status(HttpStatus.OK).body(message);
    } else {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "UserId Not Exist");
      return ResponseEntity.status(HttpStatus.OK).body(message);
    }
  }

}
