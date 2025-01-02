package com.sist.server;
import java.util.*; //데이터가 여러개 => StringTokenizser
//사용자 정보 저장 -> vector(동기화)
import com.sist.commons.*;
import java.io.*;//송수진
//전송 -> byte단위 전송  ==> OutputStream
//받을 때 -> 2byte	 ==> BufferedReader
import java.net.*;//다른 컴퓨터와 연동
//ServerSocket : 접속 담당 / Socket : 클라이언트와 통신

public class Server implements Runnable {

	private ServerSocket ss;
	private final int PORT=3050;//서버는 하나만 돌아가야 하기 때문에 조별포트가 들어가야함
	private Vector<Client> waitVc= new Vector<Server.Client>();
	/*
	 	ArrayList의 단점 : 순서가 틀리는 경우도 있다
	 			=> 정렬 / Order By / index
	 		
	 
	 */
	
	//초기화
	public Server()
	{
		try {
			//서버 소켓 생성
			ss=new ServerSocket(PORT);
			//bind -> ip/port연결 -> 유심(개통)
			//listen() -> 대기상태
			/*
			 new ServerSocket(int count, int port);
			 웹 : 톰캣(50명), XE(50명)
			 */
			System.out.println("Server Start...");
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}
	
	//접속시에 처리 => 접속자 정보를 저장(ip/port)
	public void run() //쓰레드
	{
		try {
			while(true)
			{
				//접속을 할 때마다 저장
				Socket s = ss.accept();
				//accept는 접속할 대만 호출 -> 발신자의 정보(ip/port)가지고 있다
				//사용자의 port는 자동으로 설정된다
				//어떤위치든 상관없다
				Client client = new Client(s);
				waitVc.add(client);
				//통신을 시작해라 명령
				client.start(); //run()메소드 호출

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		new Thread(server).start();
	}
	
	//클라이언트 정보저장 => 통신(송수신)
	//클라이언트마다 따로 저장
	//내부클래스이용 -> 다른클래스의 데이터를 공유받기 위해서
	class Client extends Thread
	{
		//한 명만 연결
		Socket s; //소켓은 연결이 하나만 가능
		OutputStream out;// 송신
		BufferedReader in; //수신
		
		//초기화
		public Client(Socket s)
		{
			try {
				this.s = s;
				this.out = s.getOutputStream();
				this.in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//채팅
		public void run()
		{
			try {
				while(true)
				{
					//사용자가 보내준 데이터를 받는다
					String msg = in.readLine();
					//문자열이 "\n"로 끝나야 전송이 가능
										
					/*
					 요청 1. 접속자전체
					 	 2. 접속자한명에게 전송
					 */
					messateAll(msg);
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//전체적으로 보내는 메소드 => 동기화(안정성이 좋다)
		public synchronized void messateAll(String msg)
		{
			try {
				for(Client c : waitVc)
				{
					c.messateTo(msg);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//한명에게 보내는 메소드 => 동기화
		public synchronized void messateTo(String msg)
		{
			try {
				out.write((msg+"\n").getBytes());
				//"\n"를 꼭 붙여야한다
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	

}










