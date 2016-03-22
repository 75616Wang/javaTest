package ServerSocketTest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ServerSocketTest extends JFrame {
	private ServerSocket serverSocket;
	private Socket socket;
	private JPanel contentPane;
	private JTextField textField;
	private PrintWriter writer;
	private BufferedReader reader;
	private Vector<String>vector=new Vector<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerSocketTest frame = new ServerSocketTest();
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
	public ServerSocketTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 222, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(vector);
		list.setBounds(0, 0, 206, 200);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(0, 200, 143, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("发送");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(153, 199, 53, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
			}
		});
		contentPane.add(btnNewButton);
		connection();
	}
	public void connection()
	{
		vector.add("正在连接。。。");
		try {
			serverSocket =new ServerSocket(12345);
			socket=serverSocket.accept();
			while (true) {
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(
						new OutputStreamWriter(
								socket.getOutputStream()));
				if (rootPaneCheckingEnabled) {
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
}
