package ru.innopolis.web.constants;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class Queries {
    public static final String VERIFY_LOGIN_DATA_QUERY = "SELECT ID, PASSWORD FROM users WHERE login = ?";
    public static final String EDIT_USER_QUERY = "UPDATE users SET login=?, fullname=?, email=?, sex=? where id=?";
    public static final String ADD_NEW_USER_QUERY = "INSERT INTO USERS (LOGIN,PASSWORD,FULLNAME,EMAIL,SEX,ROLE) VALUES (?,?,?,?,?,?)";
    public static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USERS WHERE ID=?";
    public static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM USERS WHERE ID=?";
    public static final String GET_LECTIONS_QUERY = "SELECT * FROM LECTIONS";
    public static final String GET_LECTION_BY_ID_QUERY = "SELECT * FROM LECTIONS where id=?";
    public static final String DELETE_LECTION_BY_ID_QUERY = "DELETE FROM LECTIONS WHERE id=?";
    public static final String ADD_LECTION_QUERY = "INSERT INTO LECTIONS (name, text) VALUES (?,?)";
    public static final String EDIT_LECTION_QUERY = "UPDATE LECTIONS SET NAME=?, TEXT=? WHERE ID =?";
    public static final String GET_USERS_QUERY = "SELECT * FROM USERS";
}
