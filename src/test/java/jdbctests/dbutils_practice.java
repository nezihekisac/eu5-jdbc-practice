package jdbctests;

import org.testng.annotations.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class dbutils_practice {
   // String dbUrl = "jdbc:oracle:thin:@3.235.93.120:1521:xe";
   // String dbUsername = "hr";
   // String dbPassword = "hr";

    @Test
    public void test1(){

        //create connection
        DBUtils.createConnection();
        //using method to get result as a list of maps
        List<Map<String, Object> > queryResult= DBUtils.getQueryResultMap("Select *from departments ");


        //printing the result
        for (Map<String, Object> map : queryResult) {
            System.out.println(map.toString());
        }

        //close connection
        DBUtils.destroy();
    }

    @Test
    public void test2(){

        //create connection
        DBUtils.createConnection();
        Map<String, Object> rowMap = DBUtils.getRowMap("select first_name,last_name,salary,job_id from employees where employee_id=100");

        System.out.println(rowMap.toString() );
    }

}
