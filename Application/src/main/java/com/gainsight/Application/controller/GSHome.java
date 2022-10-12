package com.gainsight.Application.controller;


import com.gainsight.Application.Pojo.GSUser;
import com.gainsight.Application.services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/gainsight")
public class GSHome {

  @Autowired
  private ApplicationServices applicationServices;

  @GetMapping("/gs-initialise/{user_id}")
  public Map findRecord(@PathVariable("user_id") @Size(min = 5, max = 5, message = "Length of user I'd must be of 5 character") String user_id) {
    return (this.applicationServices.getData(user_id));
  }

  @DeleteMapping("/gs-initialise/{user_id}")
  public ResponseEntity<?> deleteRecord(@PathVariable("user_id") @Size(min = 5, max = 5, message = "Length of user I'd must be of 5 character") String user_id) {
    return (this.applicationServices.deleteData(user_id));
  }

  @PostMapping("/gs-initialise")
  public ResponseEntity<?> addRecord(@RequestBody GSUser gsUser) {

    if (gsUser.getUser_id().length() != 5) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "User_id must be of 5 characters");
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }

    return (this.applicationServices.insertData(gsUser));
  }

  @PutMapping("/gs-initialise")
  public ResponseEntity<?> updateRecord(@RequestBody GSUser gsUser) {

    if (gsUser.getUser_id().length() != 5) {
      LinkedHashMap message = new LinkedHashMap();
      message.put("rid", null);
      message.put("result", true);
      message.put("data", new HashMap());
      message.put("message", "User_id must be of 5 characters");
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
    }

    return (this.applicationServices.updateData(gsUser));
  }

}
