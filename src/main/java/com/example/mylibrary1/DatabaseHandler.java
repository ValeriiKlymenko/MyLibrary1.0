package com.example.mylibrary1;
//імпрортуємо для роботи з БД
import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
//14.авторизація. починаємо авторизацію.Імортуємо
import  java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    //3. конект до БД дуже важливий код! у точності має бути
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        //тут написано "com.mysql.cj.jdbc.Driver", а у прикладі "com.mysql.jdbc.Driver", пише що застаріло...
        //яле якщо поставити, як у прикладі то працює, тільки пише що застарілий
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    // 6.підключити mysql-connector-java-8.0.29
    //7.запис нового юзера у  БД
    public void singUpUser (User user)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," +
                Const.USER_LASTNAME + "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," +
                Const.USER_MAIL + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstnameusers());
            prSt.setString(2, user.getLastnameusers());
            prSt.setString(3, user.getLoginusers());
            prSt.setString(4, user.getPasswordusers());
            prSt.setString(5, user.getMailusers());

            prSt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //2.ДОДАТИ книгу.
    public void AddNewBook (Book book)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.BOOK_TABLE + "(" +
                Const.BOOK_NAME + "," + Const.BOOK_ID_AUTOR + "," +  Const.BOOK_CATEGORY + "," +
                Const.BOOK_ID_TYPE + "," + Const.BOOK_ID_STATUS + "," + Const.BOOK_PAGE + ","  +
                Const.BOOK_NOTES  + ")" +
                //+ Const.BOOK_DATASTART
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getNamebook());
            prSt.setString(2, book.getIdautor());
            prSt.setString(3, book.getCategorybook());
            prSt.setString(4, book.getIdtype());
            prSt.setString(5, book.getIdstatus());
            prSt.setString(6, book.getPagebook());
            prSt.setString(7, book.getNotesbook());
           // prSt.setString(8, book.getDatastartbook());

            prSt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //15. авторизація. вертає конкретного користувача (якщо він буде знайдений)
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLoginusers());
            prSt.setString(2, user.getPasswordusers());

            resSet = prSt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
}


