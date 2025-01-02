package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.commons.*;

/*

 	class Server
 	{
 		Vector w = new Vector()
 		=> new Server()
 	}
 	
	class Client
	{
		Server server = new Server()
		server.w => 불가능 
		//서버가 한 컴퓨터에서 여러개를 돌릴 수 없어 1개만 돌아가야해
		//( port가 같은 경우는 사용할 수 없다! ) 
	}

 	===> 사용할 수 있는 2가지 방법 (클래스안클래스 , static)
 	
 	 //클래스 안 클래스
 	class Server
 	{
 		vector waitVc = new Vector() // 접속자 저장 공간
 						
 		class Client
 		{
 			// 접속자마다 따로 통신만 담당
 			 		   -------> 쓰레드를 사용
 			 		   			접속된 사람들과 통신
 			// 멤버클래스를 이용한다
 		}
 	}
 	
 	class Server
 	{
 		static Vector w = new Vector()
 		=> new Server()
 	}
 	
	class Client
	{
		
		server.w
	}
 	
 
 
 */

//접속시에 처리 -> 교환 소켓 / 대기 소켓
public class Server implements Runnable{
	
	//private Vector<Client> waitVc = new Vector<Server.Client>(); //원래는 Server.을 해야하지만 지금은 생략가능
	private Vector<Client> waitVc = new Vector<Client>();
	//1. 저장공간(접속자) -> 동기화
	
	//2. 서버가동
	private ServerSocket ss;
	//3. 접속시 -> 연결라인 -> port
	private final int PORT=3050;
	//4. 서버가동 -> ServerSocket초기화
	public Server()
	{
		try {
			ss=new ServerSocket(PORT);
			//bind => 개통
			//listen() => 대기
			System.out.println("Server Start...");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); //서버 2번연결하면 오류
		}
	}
	//5. 접속시 처리 => 사용자 정보를 받아서 Client 클래스로 전송
	//통신이 가능하게 만든다
	public void run()
	{
		try {
			
			while(true)
			{
				Socket s = ss.accept(); //접속
				//접속시에 발신자 정보를 받는다
				//각 쓰레드로 전송->각자 따로 통신이 가능
				Client client = new Client(s);
				client.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Server server = new Server();
		new Thread(server).start();
		
	}
	//클라이언트마다 통신을 담당
	//Server가 가지고 있는 모든 자원(변수,메소드)을 사용할 수 있다
	/*
	 이런방식으로 사용하는 경우
	 - 쓰레드 : 데이터가 없고 공유를 받아
	 	외부에서 호출할 때 상위클래스.하위클래스 ( Server.Client )
		
	쓰레드 : 한 개의 프로그램에서 여러개의 프로그램을 동시에 시작
		   ------------    ------------------
			프로세스			쓰레드 
	
	 */
	class Client extends Thread // Thread -> 동시동작 
	{
		Socket s;//클라이언트의 ip
		OutputStream out; //송신
		BufferedReader in; //수신 (한글포함(2byte))
		
		String id, name, sex, pos;
		//DB를 연결하면 ID중복체크 -> PRIMARY KEY(중복제거)
		
		public Client(Socket s)
		{
			/*
			 	서버 => 클라이언트 ip
			 	클라이언트 => 서버 ip
			 	
			 	readLine()<==>write()
			 	write()<==>readLine()
			 	
			 
			 */
			
			try {
				this.s = s;
				out = s.getOutputStream();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			//자바 프로그램에서 가장 쉬운 프로그램 => 네트워크, 데이터베이스 => 패턴이1개, 모든 개발자가 같은 형식으로 코딩
			
			
		}

		/*
		 	서버의 기능
		 	1. 저장
		 	2. 수정
		 	3. 읽기 / 쓰기
		 	4. 검색
		 */
		// 실제 통신
		public void run()
		{
			try {
				while(true)
				{
					//1. 사용자로부터 요청값 받기
					String msg = in.readLine();
					// 로그인이 되면 => 100|id|name|sex
					System.out.println("Client -> "+msg);
					StringTokenizer st = new StringTokenizer(msg,"|");
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol)
					{
						case Function.LOGIN: //로그인을 요청했다면 => 기능을 숫자로 표현 -> 내부프로토콜
						{
							// 로그인 => 회원가입 내용을 전송
							id=st.nextToken();
							name=st.nextToken();
							sex=st.nextToken();
							pos="대기실";
							
							//이미 접속이 된 사람에게 새로들어온사람으 정보 전송
							messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex+"|"+pos);
							//입장메세지 전송
							messageAll(Function.WAITCHAT+"|[알림] "+name+"님 입장하셨습니다");
							//waitVc에 저장
							waitVc.add(this);
							//화면을 변경
							messageTo(Function.MYLOG+"|"+id);
							//접속된 모든 정보를 로그인된 사람에게 전송
							for(Client c : waitVc)
							{
								messageTo(Function.LOGIN+"|"+c.id+"|"+c.name+"|"+c.sex+"|"+c.pos);
							}
							
						}
						break;
						
						case Function.WAITCHAT:
						{
							messageAll(Function.WAITCHAT+"|["+name+"] "+st.nextToken());
						}
						break;
						
						case Function.EXIT:
						{
							messageAll(Function.EXIT+"|"+id);
							messageAll(Function.WAITCHAT+"|[알림]"+name+"님 퇴장하셨습니다");
							messageTo(Function.MYEXIT+"|"); //나가는사람 윈도우종료
							for(int i=0;i<waitVc.size();i++)
							{
								Client c = waitVc.get(i);
								if(c.id.equals(id)) 
								{
									waitVc.remove(i);
									try {
										in.close();
										out.close();
										//통신(송수신) 끊기
									} catch (Exception e) {
										// TODO: handle exception
									}
									break;
								}
							}
						}
						break;
						
						case Function.INFO:
						{
							String yid=st.nextToken();
							for(Client c : waitVc)
							{
								if(yid.equals(c.id))
								{
									//원래는 오라클에서 데이터 가져와서 보여줘야해
									messageTo(Function.INFO+"|"+c.id+"|"+c.name+"|"+c.sex+"|"+c.pos);

									break;
								}
							}
						}
						break;
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// 접속자 전체 : 대기실
		public synchronized void messageAll(String msg)
		{
			for(int i=0;i<waitVc.size();i++)
			{
				Client c = waitVc.get(i);
				try {
					c.messageTo(msg);
				} catch (Exception e) {
					// TODO: handle exception
					waitVc.remove(i);
					//접속이 안되면 제거
				}
			}
		}
		
		//접속자 개인 : 쪽지보내기, 정보보기, 귓속말
		public synchronized void messageTo(String msg)
		{
			try {
				out.write((msg+"\n").getBytes());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}

}











