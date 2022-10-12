package com.gainsight.Application.Pojo;

public class GSUser {
  private String user_id;
  private String username;
  private String department;
  private String email;

  public GSUser(String user_id, String username, String department, String email) {
    super();
    this.user_id = user_id;
    this.username = username;
    this.department = department;
    this.email = email;
  }

  public String getUser_id() {
    return user_id;
  }

  public String getUsername() {
    return username;
  }

  public String getDepartment() {
    return department;
  }

  public String getEmail() {
    return email;
  }
}
