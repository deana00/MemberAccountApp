/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIKA
 */
public class DBConnection {

    private static final String SQCONN = "jdbc:sqlite:"
            + "C:/Users/CIKA/Documents/NetBeansProjects/MemberAccountApp/member_account.sqlite";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(SQCONN);
            createTable(conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void createTable(Connection con) throws SQLException {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS `member` ("
                + "    `id` int(4) NOT NULL,"
                + "    `name` varchar(100) NOT NULL,"
                + "    `phonenum` int(15) NOT NULL,"
                + "    PRIMARY KEY (`id`)"
                + ");"
                + "CREATE TABLE IF NOT EXISTS `apartment_owner` ("
                + "    `id` int(4) NOT NULL,"
                + "    `apartement_num` int(4) NOT NULL,"
                + "    PRIMARY KEY (`id`),"
                + "    CONSTRAINT `AO_id` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT"
                + ");"
                + "CREATE TABLE IF NOT EXISTS `individual` ("
                + "    `id` int(4) NOT NULL,"
                + "    `birthdate` date NOT NULL,"
                + "    PRIMARY KEY (`id`),"
                + "    CONSTRAINT `Ind_id` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT"
                + ");"
                + "CREATE TABLE IF NOT EXISTS `membership` ("
                + "    `id` int(4) NOT NULL,"
                + "    `expiration_date` date NOT NULL,"
                + "    CONSTRAINT `memship_id` FOREIGN KEY (`id`) REFERENCES `member` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT"
                + ");";
        String sqlCom[] = sqlCommand.split(";");
        int i = 1;
        for (String sql : sqlCom) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            System.out.println(i++);
        }
    }
}
