package 实验;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatSocket extends Thread{
	private Socket socket;
	public ChatSocket(Socket s) {
		this.socket=s;	
	}
	@Override
	public void run() {
		try {

			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (bufferedReader.readLine().equals("hello")) {
				bufferedWriter.write("hello");

			}
			bufferedWriter.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
