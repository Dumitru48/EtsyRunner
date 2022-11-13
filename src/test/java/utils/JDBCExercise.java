package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCExercise {

    /*
    Connection - it helps us to priovide Db credentials and connect to the DB.
    Statement - we define our conditions/query to get the DB.
    ResiltSet - we store the data/response from the database to the result set object in Java.
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@codefish.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                "techtorial",
                "techtorialb13"
        );
        Statement statement =
                connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.next(); //it will go to the next row. If there is next row it will return TRUE and go to the next row
                           //if there is no next, row it will return false.

        System.out.println(resultSet.getString("first_name"));
        resultSet.next();//move to next record
        System.out.println(resultSet.getString("email"));

        resultSet.first();//it will move to the first row of the result set
        //resultSet.last(); It will move to the last row of the resultSet
        System.out.println(resultSet.getString("last_name"));

        resultSet.beforeFirst();//it will go to the header record

        //HOW TO PRINT HEADER RECORD(COLUMN NAMES)

       // System.out.println(resultSet.getString("phone_number"));
       // System.out.println(resultSet);

        //Metadata is a information about our data. A set of information that describes and gives the details
        //about some other data.
        // Metadata is an information about the columns, rows, datatypes in your table.


        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();//gets data about our table

        System.out.println("Column count is ->" + resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(2));
        List<Map<String, Object>> employees = new ArrayList<>();
        resultSet.first();
        while(resultSet.next()){
            Map<String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i<resultSetMetaData.getColumnCount(); i++){
                employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            //System.out.println(employee);
            employees.add(employee);
        }
        System.out.println(employees.size());
        System.out.println(employees.get(2).get("EMAIL"));

    }
}