package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * JDBCを利用して、データベースに接続する際に利用するクラス
 *
 * @author 
 *
 */
public class JDBCManager {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/stream";
    private static final String USER = "root";
    private static final String PASS = "dorakonisu";

    public  static Connection getConnection() throws DAOException {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new DAOException("接続に失敗しました");
        }
    }
}
