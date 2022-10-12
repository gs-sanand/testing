package com.gainsight.Application.services;

import com.gainsight.Application.Pojo.GSUser;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ApplicationServices {

  public Map getData(String user_id);

  public ResponseEntity<?> deleteData(String user_id);

  public ResponseEntity<?> insertData(GSUser gsUser);

  public ResponseEntity<?> updateData(GSUser gsUser);
}
