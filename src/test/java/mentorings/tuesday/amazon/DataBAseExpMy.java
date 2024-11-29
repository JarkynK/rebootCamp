package mentorings.tuesday.amazon;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBAseExpMy {

    // url : ec2-18-224-165-246.us-east-2.compute.amazonaws.com
    //prt: 1521
    //SID : xe
    //username: hr
    //password: hr
    public static void main(String[] args) {
        //  String url = "jdbc:oracle:thin:@yoururl:1521:xe";
        String url = "jdbc:oracle:thin:@ec2-18-224-165-246.us-east-2.compute.amazonaws.com:1521:xe";
        String username = "hr";
        String password = "hr";


        //3 classes that we need for testing database
        //connection => create a connection
        //statement => write query
        //resultSet => result will stored = new database

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
            ResultSet resultSet = statement.executeQuery("select first_name, last_name from employees");
            ResultSetMetaData metaData = resultSet.getMetaData();

            int numberOfColumns = metaData.getColumnCount();

            System.err.println("  Number of Columns : " + numberOfColumns);
            List<Map<Object,Object>> data = new ArrayList<>();

            int number = 1;
            while (resultSet.next()) {

                Map<Object, Object> map = new HashMap<>();

                for (int i = 1; i <= numberOfColumns; i++) {
                    map.put(metaData.getColumnName(i), resultSet.getObject(i));
                   // System.err.println(metaData.getColumnName(i) + "    " + resultSet.getObject(i) + " ");
                }
                data.add(map);


                System.out.println(number + "=> First name : " + resultSet.getObject(1) + "         Last name : " + resultSet.getObject(2));
                number++;
            }

            System.out.println("Index 1: " + resultSet.getObject(2));
            System.out.println("Index 4 : " + resultSet.getObject(3));

            System.out.println("Connection successful");

            connection.close();
            statement.close();
            resultSet.close();

            for(Map<Object, Object> map : data){
                System.out.println(map);

            }

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.err.println(e.getMessage());
            System.err.println("Connection failed ");


        }


    }

}