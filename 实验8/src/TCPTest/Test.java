package TCPTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Test {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(12345);
			while (true) {
				Socket socket=serverSocket.accept();
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
				String string=null;
				while ((string=bufferedReader.readLine())!=null) {
					System.out.println(string);
					if (string.equals("hello")) {

						bufferedWriter.write("hello!");
					}
				}
				bufferedWriter.close();
				bufferedReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
