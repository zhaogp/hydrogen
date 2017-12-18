package rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class MyRemoteClient {
	public static void main(String[] args){
			String host = (args.length < 1 ? null : args[0]);
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			MyRemote service = (MyRemote) registry.lookup("MyRemoteRegister");
			String s = service.sayHello();
			System.out.println(s + " from client");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
