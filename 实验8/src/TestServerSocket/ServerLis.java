package TestServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerLis extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				ServerSocket serverSocket=new ServerSocket(12345);
				Socket socket=serverSocket.accept();
				JOptionPane.showMessageDialog(null, "连接成功");
//				int i=0;
//				while (true) {
//					i++;
//					String string=i+"\n";
//					socket.getOutputStream().write(string.getBytes("UTF-8"));
//					
//				}
				ChatSocket chatSocket=new ChatSocket(socket);
				chatSocket.start();
				ChatManager.getChatManager().add(chatSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		}
		
}
