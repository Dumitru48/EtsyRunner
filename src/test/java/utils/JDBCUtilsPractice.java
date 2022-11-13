package utils;

import java.util.List;
import java.util.Map;

public class JDBCUtilsPractice {
    public static void main(String[] args) {
        JDBCUtils.establishConnection();
        List<Map<String, Object>> regions = JDBCUtils.executeQuery("select * from regions");

        System.out.println(regions.get(2).get("REGION_NAME"));
        JDBCUtils.closeConnection();
    }
}

//HOW do you make sure