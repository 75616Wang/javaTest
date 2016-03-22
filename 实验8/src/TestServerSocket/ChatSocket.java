package TestServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {

	Socket socket;
	public ChatSocket(Socket s) {
		socket=s;
	}
	public void  out(String s) {
		try {
			socket.getOutputStream().write(s.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line=null;
			while((line=bufferedReader.readLine())!=null)
			{
				ChatManager.getChatManager().publish(this, line);
			}
			bufferedReader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
