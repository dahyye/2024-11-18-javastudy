package com.sist.exam;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{

	private Vector<Client> waitVc = new Vector<Client>();
	
	// => 예전 프로그램 유지보수할 땐 Vector가 있을 수 있다
	private ServerSocket ss; 
	public Server() {
		try {
			ss=new ServerSocket(3355);
			System.out.println("Server Start");
			//bind(ip, port) => listen() => 대기
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		new Thread(server).start(); 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Socket s = ss.accept(); //접속을 했다면
				Client client = new Client(s);
				waitVc.add(client);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	//내부클래스
	class Client extends Thread
	{
		private Socket s;
		public Client(Socket s)
		{
			this.s=s;
			System.out.println(s.getInetAddress().getHostAddress());
			System.out.println(s.getPort());
			
		}
	}
	

}
