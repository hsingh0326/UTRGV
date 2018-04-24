import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class main {
public static void main(String [] args){
	Thread t1 = new Thread(new MyThread1());
	Thread t2 = new Thread(new MyThread2());
	t1.start();
	t2.start();
	
}
}
class MyThread1 implements Runnable
{
	public void run(){
		for(int i =0; i < 100; i++)
		{
			System.out.println(i);
			try{
				TimeUnit.SECONDS.sleep(1);
			
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		}
	}



class MyThread2 implements Runnable
{
	public void run(){
		for(int i =100; i < 200; i++)
		{
			System.out.println(i);
			try{
				TimeUnit.SECONDS.sleep(1);
			
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		}
	}


