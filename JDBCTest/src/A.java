import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class A {
public static void main(String[] args) {
	Connection conn=null;
	try {
		Class.forName("org.gjt.mm.mysql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("�޷�����������");
		
	}
	try {  
        conn = DriverManager.getConnection("jdbc:mysql://localhost/vtest", "root", "7W3j1q1");  
    } catch (SQLException e) {  
        System.out.println("�޷��������ݿ�");  
    }  
    try {  
        Statement stmt = (Statement) conn.createStatement();  
        
        ResultSet rs = stmt.executeQuery("select * from student");  

        while(rs.next()) {  
            String id=rs.getString("id");
            String username=rs.getString("����");
            String age=rs.getString("����");
            String number=rs.getString("ѧ��");
            
            System.out.println("id="+id+"\tusername:"+username+"\tage:"+age+"\tnumber:"+number);
            
        }  
    } catch (SQLException e) {  
        System.out.println("�޷���ѯ");  
    }  
    try {

		
	} catch (Exception e) {
		// TODO: handle exception
	}
    
    
}
}
