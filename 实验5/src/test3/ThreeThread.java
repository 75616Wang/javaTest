package test3;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ThreeThread extends Thread{
	private String name;
public ThreeThread(String name) {
	this.name=name;
}
public void run() {
	while (true) {
		System.out.println(new SimpleDateFormat("yyy-mm-dd  hh:mm ss").format(new Date(System.currentTimeMillis()))+"  "+this.name);
		try {
			ThreeThread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public static void main(String[] args) {
	new ThreeThread("1").start();
	new ThreeThread("2").start();
	new ThreeThread("3").start();
}
}
