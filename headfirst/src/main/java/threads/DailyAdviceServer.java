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
	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	public void go(){
		try{
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true){
				Socket sock = serverSock.accept();
				Thread t = new Thread(new ClientHandler(sock));
				t.start();	
			}
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}

	public String getAdvice(){
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}

	class ClientHandler implements Runnable {
		private Socket socket;
		
		public ClientHandler(Socket s){
			socket = s;
		}
		
		public void run(){
			String threadName = Thread.currentThread().getName();
			try{
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				String advice = getAdvice();
				writer.println(threadName + ": " + advice);
				writer.close();
				System.out.println(threadName + ": " + advice);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
