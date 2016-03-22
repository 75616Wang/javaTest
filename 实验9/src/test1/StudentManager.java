package test1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.mysql.jdbc.Statement;
public class StudentManager extends JFrame {
	public static String USERNAME="root";
	public static String PASSWORD="7W3j1q1";
	public static String URL="jdbc:mysql://localhost/vtest";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	public static  String DRIVER="org.gjt.mm.mysql.Driver";
	private JPanel contentPane;
	private JTextField number;
	private JTextField name;
	private JTextField age;
	private DefaultListModel listModel=new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManager frame = new StudentManager();
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
	public StudentManager() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JList list = new JList(listModel);
		list.setValueIsAdjusting(true);
		list.setBounds(10, 58, 444, 137);
		new JScrollPane(list);
		refreshList();
		contentPane.add(list);
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 205, 152, 15);
		contentPane.add(label);
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(172, 205, 131, 15);
		contentPane.add(label_1);
		JLabel lblNewLabel = new JLabel("\u5E74\u9F84");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(313, 205, 141, 15);
		contentPane.add(lblNewLabel);
		number = new JTextField();
		number.setBounds(10, 230, 152, 21);
		contentPane.add(number);
		number.setColumns(10);
		name = new JTextField();
		name.setBounds(172, 230, 131, 21);
		contentPane.add(name);
		name.setColumns(10);
		age = new JTextField();
		age.setBounds(313, 230, 141, 21);
		contentPane.add(age);
		age.setColumns(10);
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addStudent(number.getText(),name.getText(),age.getText());
				String student="";
				student=name.getText()+"          "+number.getText()+"          "+age.getText();
				listModel.addElement(student);
			}
		});
		button.setBounds(123, 276, 203, 33);
		contentPane.add(button);
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u4FE1\u606F");
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
			rs = getStatment().executeQuery("select * from student");  

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
	public void  addStudent( String number,String name,String age) {
		String sql="INSERT INTO `student`(`姓名`, `年龄`, `学号`) VALUES ('"+name+"','"+age+"','"+number+"')";
		//		String sql="INSERT INTO `student`(`姓名`, `年龄`, `学号`) VALUES ('asf','13','6')";
		try {
			getStatment().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
