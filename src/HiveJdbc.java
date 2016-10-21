import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveJdbc {

    private static String driverName =  "org.apache.hadoop.hive.jdbc.HiveDriver";
    private static String url="jdbc:hive://192.168.10.101:10008/default";

    public static void main(String[] args) 
                            throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
       String sql="select * from t1";
        Connection con = DriverManager.getConnection(url,"","");
        Statement stmt = con.createStatement();
        //String tableName = "hive_jdbc";
     //   String tableName="people";
        ResultSet re= stmt.executeQuery(sql);
        while(re.next())
        {
        	System.out.println(re.getInt(1));
        }
        
        //stmt.execute("drop table if exists " + tableName);
        //stmt.execute("create table " + tableName + " (key int, value string)");
        /*
        System.out.println("Create table success!");
        // show tables
        String sql = "show tables '" + tableName + "'";
        System.out.println("Running: " + sql);
        ResultSet res = stmt.executeQuery(sql);
        if (res.next()) {
            System.out.println(res.getString(1));
        }

        // describe table
        sql = "describe " + tableName;
        System.out.println("Running: " + sql);
        res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString(1) + "\t" + res.getString(2));
        }


        sql = "select * from " + tableName;
        res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(String.valueOf(res.getInt(1)) + "\t"
                                               + res.getString(2));
        }

        sql = "select count(1) from " + tableName;
        System.out.println("Running: " + sql);
        res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString(1));
        }*/
    }
}
