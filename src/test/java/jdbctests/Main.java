package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

      String dbUrl="jdbc:oracle:thin:@3.235.93.120:1521:xe";
      String dbUsername="hr";
      String dbPassword="hr";

//create connection(write connection and pick the one "connection java.sql)
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
//create statement object
        Statement statement=connection.createStatement();
//run query and get the result in resultSet object
        ResultSet resultSet=statement.executeQuery("Select * from departments");

        //move pointer to first row
//      resultSet.next();
//
////getting information with column name
//      System.out.println(resultSet.getString("region_name"));
//      //getting information with column index(starts from 1)
//      System.out.println(resultSet.getString(2));
//
//      System.out.println(resultSet.getInt(1)+" - "+resultSet.getString("region_name"));
//
//      //move pointer to the second row
//      resultSet.next();
//
//      System.out.println(resultSet.getString("region_name"));
//      //getting information with column index(starts from 1)
//      System.out.println(resultSet.getString(2));
//
//      System.out.println(resultSet.getInt(1)+" - "+resultSet.getString("region_name"));
//
//      //move pointer to the third row
//      resultSet.next();
//      System.out.println(resultSet.getInt(1)+" - "+resultSet.getString("region_name"));
//
//
//

      while(resultSet.next()){

        System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3)+" - "+resultSet.getString(4));

      }




      //close all connections
        resultSet.close();
        statement.close();
        connection.close();


    }

}
