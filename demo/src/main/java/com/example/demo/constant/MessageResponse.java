package com.example.demo.constant;

public class MessageResponse {
  public static class Message {
    public static final String CREATE_TAG_SUCCESS = "CREATE TAG SUCCESS";
    public static final String DELETE_TAG_SUCCESS = "DELETE TAG SUCCESS";
    public static final String UPDATE_TAG_SUCCESS = "CREATE TAG SUCCESS";
    public static final String GET_TAG_SUCCESS = "CREATE TAG SUCCESS";
    public static final String CREATE_TRAN_SUCCESS = "CREATE TRANSACTION SUCCESS";
    public static final String DELETE_TRAN_SUCCESS = "DELETE TRANSACTION SUCCESS";
    public static final String UPDATE_TRAN_SUCCESS = "CREATE TRANSACTION SUCCESS";
    public static final String GET_TRAN_SUCCESS = "CREATE TRANSACTION SUCCESS";
  }

  public static class SQLQuery {
    public static final String ADD_TAG = "INSERT INTO tag_finance (name, description) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, description FROM tag_finance";
    public static final String DELETE_TAG = "DELETE FROM tag_finance WHERE id =?";
    public static final String UPDATE_TAG = "UPDATE tag_finance SET name =?, description =? WHERE id =?";
    public static final String GET_TAG = "SELECT id, name, description FROM tag_finance WHERE id =?";

  }
}
