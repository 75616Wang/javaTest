package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class JButtonTest extends JFrame{
	Container container;
	public JButtonTest() {
		setVisible(true);
		setBounds(400, 100, 100, 100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container=getContentPane();
		JButton button=new JButton();
		button.setText("Click Me");
		button.setBounds(50, 50, 50, 50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object object=arg0.getSource();
				String string=((JButton)object).getText();
				if (string.equals("Click Me")) {
					button.setText("Click Me Again");
				}else {
					button.setText("Click Me");
				}
			}
		});
		container.add(button);
	}
	public static void main(String[] args) {
		new JButtonTest();
	}
}
