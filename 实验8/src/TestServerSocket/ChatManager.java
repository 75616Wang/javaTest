package TestServerSocket;

import java.util.Vector;

public class ChatManager {
	private ChatManager(){
		
	}
	Vector<ChatSocket>vector=new Vector<>();
	private static ChatManager chatManager=new ChatManager();
	public static ChatManager getChatManager()
	{
		return chatManager;	
	}
	public void add(ChatSocket s)
	{
		vector.add(s);
	}
	public void  publish(ChatSocket cs,String string) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket chatSocket=vector.get(i);
			if(!chatSocket.equals(cs))
			{
				chatSocket.out(string);
			}
		}
	}
	
}
