package com.sist.main;
/*
 	
 	java.net
 	=Thread
 	=Network -> WebServer(작동하는 과정)
 		| 
 		웹 / 오라클
 		=> 서버가 이미 제작
 				http://localhost:8080/main/main.jsp
 				------------------------------------- URL
 								     ---------------- URI
 								     ----- ContextPath
 								     		구분자 : 파일명
 								     		네트워크 -> 구분자
 								     		내부 프로토콜을 사용
 								     		----------------
 								     		|서버와 클라이언트만 확인
 								     			문자열 / 정수
 								     			
 								     			
 								     			
		C/S => Client / Server => Scoket으로 통신
									전화기(ip/port)
									ex.전화번호/연결선
 			
 			port => 0~65535
 				이미 사용중인 port(0~1023)
 				8080 / 4000 / 1521 / 1433 / 3306
 				웹 => 80
 			
 			서버는 지정 / 클라이언트는 자동생성
 			
 	---------------------------------------------------------------------
 	
 	쓰레드 
 	컴퓨터의 성능을 높이기 위해 여러개의 애플리케이션을 동시에 실행
 						 --------------------------
 						 	메소드 이용 => run()
 						 	(동시에 실행되는 것은 아니다 -> 시분할)
 	쓰레드가 동작에 필요한 데이터를 가지고 있는게 아니라	프로세스가 데이터를 가지고 있다
 	 => 쓰레드는 프로세서가 가지고 있는 데이터를 공유해서 사용
 	  
 	쓰레드 사용방법
 		1. 쓰레드 상속 => 멀티쓰레드
 			class A extends Thread
 			
 		2. 인터페이스 구현 => 윈도우
 			class a implements Runnable
 					-------------------run()
 		=> 사용처
 			서버 / IO ( 단방향 => 양뱡향 ) => 입출력
 				  Client => 서버로 요청 / 서버로부터 응답
 				  					    ---------- 실시간
 				  					    
 	
 	쓰레드 생명주기
 		1. new Thread()
 			쓰레드 생성
 			=> 쓰레드 이름
 				Thread-0 : 필요시 변경 가능
 			=> 쓰레드의 우선순위 결정
 				0~10
 				MIN / MAX / NORM 
 							----- 5(중간순위
 				컴퓨터마다 다르다
 	
 		new Thread() => start => Runnable   =>   일시정지
								   run()  sleep		|
 									 |				| interrupted
 									 ----------------
 											Dead
 											
 	주요 메소드
 		1. start() : 대기상태 -> 쓰레드 동작(run)
 		2. run() : 쓰레드 동작을 정의하는 메소드
 		3. sleep() : 일시정지
 		4. interrupt : 쓰레드 종료
 		5. currentThread() : 현재 실행중인 쓰레드 이름을 가지고 온다
 		6. getName() / setName() => 쓰레드 이름 벼경
 		7. getPriority() / setPriority() : 우선순위
 			MAX_PRIORITY : 10 => 가장 빠르다 => main()
 			MIN_PRIORITY : 1 => 가장 늦다 => gc()
 			NORM_PRIORITY : 5 => 사용자 정의 쓰레드
 			
 		=> 시분할 : 쓰레드가 한 번씩 수행
 		
 			
 
 	쓰레드의 디폴트는 비동기 => 필요시 동기로 바꿀 수 있다
 	
 	
 
 
 */

class MyThread extends Thread
{
	// 동작
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			try {
				Thread.sleep(100); // 0.5초
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(getName()+":"+i);
		}
		
	}
}
public class 네트워크_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//쓰레드생성
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		MyThread m3 = new MyThread();
		MyThread m4 = new MyThread();
		MyThread m5 = new MyThread();
	
		
		//쓰레드이름부여
		m1.setName("홍길동");
		m2.setName("이순신");
		m3.setName("강감찬");
		m4.setName("박문수");
		m5.setName("심청이");
		
		
		//쓰레드우선순위
		m1.setPriority(Thread.MIN_PRIORITY);
		m2.setPriority(Thread.MIN_PRIORITY);
		m3.setPriority(Thread.MAX_PRIORITY);
		m4.setPriority(Thread.MIN_PRIORITY);
		m5.setPriority(Thread.MIN_PRIORITY);
		
		//동작명령 -> run()호출
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		
	}

}
