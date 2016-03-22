package test1;
import java.util.*;
class S09_01_Thread extends Thread {
	int pauseTime;
	String name;
	public S09_01_Thread(int x,String n){
		pauseTime=x;
		name=n;
	}
	public void run(){
		while(true){
			try{
				System.out.println(name+":"+new Date(System.currentTimeMillis()));
				S09_01_Thread.sleep(pauseTime);
			}catch(Exception e){System.out.println(e);}
		}
	}
	static public void main(String srgs[]){
		S09_01_Thread tp1=new S09_01_Thread(1000,"Fast");
		tp1.start();
		S09_01_Thread tp2=new S09_01_Thread(3000,"Slow");
		tp2.start();
	}
}
