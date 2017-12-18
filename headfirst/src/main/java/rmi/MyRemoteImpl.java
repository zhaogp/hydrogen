package rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


public class MyRemoteImpl implements MyRemote {

	public String sayHello(){
		String s = "I am coming from remote server";
		System.out.println(s);
		return s;
	}
	
	public MyRemoteImpl() throws RemoteException{
	}

	public static void main(String[] args){
		try{
			MyRemote service = new MyRemoteImpl();
			MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(service, 0);			

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("MyRemoteRegister", stub);
		} catch (Exception ex){
			System.err.println("Server exception: " + ex.toString());
			ex.printStackTrace();
		}
	}
}
