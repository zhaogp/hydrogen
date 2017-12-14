package rmi;

import java.rmi.*;
import java.rmi.server.*;


public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	public String sayHello(){
		String s = "rmi sayHello()";
		System.out.println(s);
		return s;
	}
	
	public MyRemoteImpl() throws RemoteException{
	}

	public static void main(String[] args){
		try{
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("Remote Hello", service);
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
