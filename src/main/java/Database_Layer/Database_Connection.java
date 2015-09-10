/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author nuwan_rates
 */
public class Database_Connection {

    private static Connection dbCon;
    private static Database_Connection instance;

    private Database_Connection() {

    }

    public static Database_Connection GetInstance() {
        if (instance == null) {
            instance = new Database_Connection();
        }
        return instance;
    }

    private Connection getConnection() throws Exception {
        String drivers = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:Smart_Nurse";
        String username = "NuwanSQL";
        String Password = "Software";
        Class.forName(drivers);
        return DriverManager.getConnection(url, username, Password);
    }

    public void InsertValues(String SQL) throws Exception {
        try {
            Database_Connection con = Database_Connection.GetInstance();
            Connection sqlCon = con.getConnection();
            Statement st = sqlCon.createStatement();
            st.executeUpdate(SQL);
            sqlCon.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Insertion Faild. " + ex.toString(), SQL, 1);
        }
    }

    public ResultSet getData(String SQL) {
        ResultSet rs = null;
        try {
            Database_Connection con = Database_Connection.GetInstance();
            Connection sqlCon = con.getConnection();
            Statement st = sqlCon.createStatement();
            rs = st.executeQuery(SQL);
            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error occured when retrieving " + ex.toString(), SQL, 1);
        }
        return rs;
    }

    public static void closeConnection() throws SQLException {
//        dbCon.close();
    }

}
