package com.sist.server;
import java.util.*;

import com.sist.commons.Function;

import java.net.*;
import java.io.*;

/*
 	서버
 	1. 접속담당
 	   => 접속한 클라이언트의 정보를 저장
 	2. 통신담당 : 각 클라이언트당 따로 통신
 	   ------ 쓰레드 이용
 	   => 저장된 클라이언트 정보를 이용
	   => 멤버클래스 (내부클래스)를 이용해서 서로다른 두 클래스를 쉽게 연결
	   
	  		class Server
	  		{
	  			vector waitVc;
	  			
	  			//클래스간의 공유(변수,메소드)가 많을 때 내부클래스 사용 
	  			class Client extends Thread
	  			{
	  			
	  			}  			
	  		
	  		}
 	
 
 */
public class Server implements Runnable{

	//클라이언트 정보 저장
	Vector<Client> waitVC = new Vector<Client>();
	//vector는 동기화를 가지고 있다. (ArrayList는 비동기화)
	//접속을 받는다
	ServerSocket ss;
	//클라이언트에서 서버로 연결하려면 연결선필요 -> 숫자로 구분(port) -> port가 연결선 역할
	final int PORT=3355; //port번호 결정 0~65,535 사이가능 (팀 port번호는 3050)
	
	//1. 서버구동 -> 시작하자마자 해야하기 때문에 생성자에서 구현
	public Server()
	{
		try {
			ss= new ServerSocket(PORT); //ServerSocket이 핸드폰이라고 생각
			//자동으로 IP인식
			//연결 => ip와 port가 매칭되어야 연결됨 ( 유심이라고 생각하면 됨 ) -> bind()
			//대기상태 listen()
			//단점 : 50명까지만 접근이 가능
			// new ServerSocket(100,PORT); -> 100명 접근가능
			System.out.println("서버 START..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); //2번 실행하면 Address already in use: bind오류 발생
		}
	}
	
	//Thread메소드 -> 동작
	//접속시마다 처리해주는 역할
	public void run()
	{
		while(true)
		{
			try {
				Socket s= ss.accept(); //사용자가 접속을 했다면
				//			 --------> 클라이언트가 접속했을 때만 호출되는 특수메소드
				//Socket은 발신자 정보 -> 접속된 클라이언트의 IP/PORT
				//=> 통신시작해라 명령을 내리기
				Client client = new Client(s);
				client.start(); // start를 호출하면 -> run()메소드 호출
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		//서버설정 -> 서버구동 
		new Thread(server).start(); // 접속처리 -> run()호출
	}
	
	//같은 서버에서 같은 Port를 사용하면 서버는 한 번만 수행해야한다
	//통신 담당 클래스
	class Client extends Thread
	{
		//Client의 모든 정보
		String id,name,sex;
		//Cliend랑 연결
		Socket s;
		//송수신
		//송신
		OutputStream out;
		//수신
		BufferedReader in;
		
		public Client(Socket s)
		{
			try {
				this.s=s;
				//클라이언트 컴퓨터 메모리
				out=s.getOutputStream();
				//접속한 클라이언트로 요청처리값 보낼 때 사용
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//클라이언트로부터 요청을 받을 경우에 사용
				//=> 한글처리 -> 2byte
				//InputStream -> 1byte => 한글깨짐
				//2byte로 변경 후 받는다 Reader
				//웹에서 전송 : 1byte / 받는 경우 : 2byte로 벼경
				// Encoding			  Decoding(UTF-8)
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//통신 -> Thread로 처리
		public void run()
		{
			try {
				while(true)
				{
					//사용자가 전송한 메세지를 받는다
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					//100|hong|홍길동|남자
					StringTokenizer st= new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
						case Function.LOGIN:
						{
							id=st.nextToken();
							name=st.nextToken();
							sex=st.nextToken();
							
							//1. 전체적으로 로그인정보 전송
							messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex);
							//2. 입장메세지 전송
							messageAll(Function.WAITCHAT+"|[알림]"+name+"님이 입장하셨습니다");
							//3. waitVC에 저장
							waitVC.add(this); // 메인화면으로 이동
							messageTo(Function.MYLOG+"|"+id);
							//4. 먼저 접속한 사람의 정보 전체를 보낸다
							for(Client client:waitVC)
							{
								messageTo(Function.LOGIN+"|"+client.id+"|"+client.name+"|"+client.sex);
							}
							//5 방 정보 전송
							
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
							messageAll(Function.WAITCHAT+"|[알림]"+name+"님이 퇴장하셨습니다");
							for(int i=0;i<waitVC.size();i++)
							{
								Client c=waitVC.get(i);
								if(c.id.equals(id))
								{
									messageTo(Function.MYEXIT+"|");
									waitVC.remove(i);//접속자명단에서 지우기
									try {
										in.close();//통신끊기
										out.close();
										
									} catch (Exception e) {
										// TODO: handle exception
									}
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
		// 개인별로 전송 -> 동기화 -> 신뢰성이 뛰어난 프로그램
		//			  -> 안정성이 뛰어나지만 느리다는 단점이 있다(받은걸 확인 후 보내기 때문에)
		//			  -> SMTP/FTP
		//		async function -> 비동기(AJAX), sync function -> 동기
		public synchronized void messageTo(String msg)
		{
			try {
				out.write((msg+"\n").getBytes());
				//"\n"을 해줘야 한줄씩 보낸다
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// => 접속자 전체 전송
		public synchronized void messageAll(String msg)
		{
			try {
				for(Client client:waitVC)
				{
					client.messageTo(msg);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
