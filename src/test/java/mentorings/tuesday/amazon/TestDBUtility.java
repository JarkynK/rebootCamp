package mentorings.tuesday.amazon;

import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDBUtility {


    public static void main(String[] args) throws SQLException {
        // expected result

//        -- 175 => 8800
//        -- 176 => 8600
//        -- 206 => 8300

        // query : select * from employees

        // Using above query, verify those data with database
        //  Emp_id    Salary
        //   175   => 8800
        //   176   => 8600
        //   206   => 8300



        DBUtility.createConnection();

        List<Map<Object, Object>> mydata = DBUtility.executeQuery("select * from employees where employee_id = 175");

        DBUtility.close();
        System.out.println("Data size: "+mydata.size());
        System.out.println("Data size: "+mydata.get(0));
//        for(Map<Object, Object> map: mydata){
//
////            System.out.println(map.get("EMPLOYEE_ID"));
//            if(map.get("EMPLOYEE_ID").toString().equalsIgnoreCase("175")){
//                if(map.get("SALARY").toString().equalsIgnoreCase("8800")){
//                    System.out.println("ID: "+ map.get("EMPLOYEE_ID") + " Salary: "+map.get("SALARY") +" is verified!");
//                }
//            }
//        }
    }
}
