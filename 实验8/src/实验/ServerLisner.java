package 实验;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ServerLisner extends Thread {
	@Override
	public void run() {
		try {while (true) {
			ServerSocket serverSocket=new ServerSocket(12345);
			Socket socket=serverSocket.accept();
			JOptionPane.showMessageDialog(null, "连接成功");
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (bufferedReader.readLine().equals("hello")) {
				bufferedWriter.write("hello");

			}
			bufferedWriter.close();
			bufferedReader.close();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
