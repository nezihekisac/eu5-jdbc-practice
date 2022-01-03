package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class metadata_example {

    String dbUrl = "jdbc:oracle:thin:@3.235.93.120:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";



    @Test
    public void metadataExample() throws SQLException {

        //create connection(write connection and pick the one "connection java.sql)
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultSet object
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        //get the database related data inside the dbMetadata object
        DatabaseMetaData dbMetadata= connection.getMetaData();

        System.out.println("User =" +dbMetadata.getUserName());
        System.out.println("Database Product Name = " + dbMetadata.getUserName());
        System.out.println("Database Product Version = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("Driver name = " + dbMetadata.getDriverName());
        System.out.println("Driver version = " + dbMetadata.getDriverVersion());

        //get the resultset object metadata
        ResultSetMetaData rsMetadata=resultSet.getMetaData();

        //how many columns we have?
        int colCount=rsMetadata.getColumnCount();
        System.out.println(colCount);

        //column names
      //  System.out.println(rsMetadata.getColumnName(1));
       // System.out.println(rsMetadata.getColumnName(2));

        //print all the column names dynamically
        for(int i=1;i<=colCount;i++){
            System.out.println(rsMetadata.getColumnName(i));


        }









        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }

}


