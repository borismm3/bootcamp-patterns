package singletonMysql;

import java.sql.SQLException;

public class SingletonMain {
    public static void main(String[]arg) throws SQLException {
        MysqlDBClient mysqlDBClient = (MysqlDBClient) MysqlDBClient.getInstance();
        mysqlDBClient.getData();
        MysqlDBClient mysqlDBClient2 = (MysqlDBClient) MysqlDBClient.getInstance();
        mysqlDBClient2.getData();
        MysqlDBClient mysqlDBClient3 = (MysqlDBClient) MysqlDBClient.getInstance();
        mysqlDBClient3.getData();
    }
}
