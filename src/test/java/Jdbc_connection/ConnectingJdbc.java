package Jdbc_connection;

import java.sql.*;

public class ConnectingJdbc {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classicmodels","root","Vijay@2608");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from customers");

        int a =10;
        int sum=0;

        for (int i = 1; i <=a ; i++) {
            sum=sum+i;

        }
        System.out.println(sum);
    }
}
