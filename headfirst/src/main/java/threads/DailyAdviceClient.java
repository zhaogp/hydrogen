package threads;

import java.io.*;
import java.net.*;

class DailyAdviceClient{

	public static void main(String[] args){
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}

	public void go(){
		try{
			Socket sock = new Socket("127.0.0.1", 4242);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			String advice = reader.readLine();
			System.out.println(advice);
			reader.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
