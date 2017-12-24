package threads;

import java.io.*;
import java.net.*;

class DailyAdviceServer{
	String[] adviceList = {
	"ake smaller bites", 
	"Go for the tight jeans. No they do NOT make you look fat.",
	"One word: inappropriate", 
	"Just for today, be honest. Tell your boss what you *really* think", 
	"You might want to rethink that haircut."
	};
	ServerSocket serverSock;

	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	public void go(){

		try{
			serverSock = new ServerSocket(4242);
			ClientHandler clientHandler = new ClientHandler();
			Thread t1 = new Thread(clientHandler);
			t1.setName("kailide");
			t1.start();
			Thread t2 = new Thread(clientHandler);
			t2.setName("jingdong");
			t2.start();
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

	public String getAdvice(){
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}

	class ClientHandler implements Runnable {
		
		public void run(){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " start");
			while(true){
				try{
					Socket sock = serverSock.accept();
					PrintWriter writer = new PrintWriter(sock.getOutputStream());
					String advice = getAdvice();
					writer.println(threadName + ": " + advice);
					writer.close();
					System.out.println(threadName + ": " + advice);
					Thread.sleep(1000);
				}catch(IOException ex){
					ex.printStackTrace();
				}
				catch (InterruptedException ex){
					ex.printStackTrace();
				}
			}
		}
	}
}
