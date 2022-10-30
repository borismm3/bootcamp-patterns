package singletonMysql;


import java.sql.*;

public class MysqlDBClient {
    private static MysqlDBClient instance;
    private static Connection connection;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String url = "jdbc:mysql://localhost:3306/singletonmysql";
    private String username = "root";
    private String password = "9056";

    private MysqlDBClient() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /*public static Connection getConnection() {
        return connection;
    }*/

    public static MysqlDBClient getInstance() throws SQLException {
        if ( instance == null ) {
            System.out.println("Primera conexion");
            instance = new MysqlDBClient();
        }
        return instance;
    }

    public void getData() {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bootcamp");
            while ( rs.next() ) {
                System.out.println("Id: " + rs.getInt("BootcampID") +
                        "\nArea: " + rs.getString("Area") +
                        "\nStudent: " + rs.getString("Student"));
            }
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
