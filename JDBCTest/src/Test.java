import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) {
	Connection conn = null;  
    try {  
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
    } catch (ClassNotFoundException e) {  
        System.out.println("无法加载驱动");  
    }  
   
}
}
