package test1;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Statement;
public class ShowStudents extends JFrame {
	public static String USERNAME="root";
	public static String PASSWORD="7W3j1q1";
	public static String URL="jdbc:mysql://localhost/vtest";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	public static  String DRIVER="org.gjt.mm.mysql.Driver";
	private JPanel contentPane;
	private DefaultListModel listModel=new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStudents frame = new ShowStudents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ShowStudents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JList list = new JList(listModel);
		list.setValueIsAdjusting(true);
		list.setBounds(10, 58, 444, 277);
		refreshList();
		contentPane.add(list);
		JLabel lblNewLabel_1 = new JLabel("\u5E74\u9F84>18\u7684\u5B66\u751F\u4FE1\u606F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 434, 33);
		contentPane.add(lblNewLabel_1);
	}
	public Connection getConnection() {
		try {
			conn =DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return conn;
	}
	public void  refreshList() {
		try {  
			rs = getStatment().executeQuery("select * from student where 年龄>18");  

			while(rs.next()) {  
				String id=rs.getString("id");
				String username=rs.getString("姓名");
				String age=rs.getString("年龄");
				String number=rs.getString("学号");
				String student=number+"         "+username+"          "+age;
				listModel.addElement(student);
				System.out.println("id="+id+"\tusername:"+username+"\tage:"+age+"\tnumber:"+number);
			}  
		} catch (SQLException e) {  
			System.out.println("无法查询");  
		}  
	}
	public Statement getStatment() {
		try {
			stmt=(Statement) getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	} 
}
