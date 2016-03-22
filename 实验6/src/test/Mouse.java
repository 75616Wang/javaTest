package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class Mouse extends JFrame {
	Container container;
	public static void main(String[] args) {
		Mouse mouse=new Mouse();
	}
	public Mouse() {
		setVisible(true);
//		setResizable(false);
		setBounds(400, 100, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container=getContentPane();
		JTextField jTextField=new JTextField();
		jTextField.setBounds(20, 20, 350, 20);
		container.add(jTextField);
		JButton button =new JButton();
		button.setText("show");
		button.setBounds(20, 100, 50, 20);
		container.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jTextField.setText(new SimpleDateFormat("yyyy-mm-dd  hh:mm-ss").format(new java.util.Date(System.currentTimeMillis())));
			}
		});
	}
}
