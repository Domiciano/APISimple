package db;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    public DBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
    }

    //SELECT
    public ResultSet getDataBySQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public void execute(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public void close() throws SQLException {
        connection.close();
    }


}
