
package com.sist.io;

import java.io.*;
import java.util.*;

public class IO_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		final int EOF=-1;
		//한글로 된 파일 제어 => 2byte => Reader / Writer
		
		try {
			
			//삭제를 하면 중간에 공백이 생기기때문에 사원권리 시스템에서 사용하기에는 어려움이 있다
			//ObjectInputStream / ObjectOutputStream 은 list가 통째로 저장이 가능->많이 사용하진 않아 
			
			
			while(true)
			{
				System.out.println("===== Menu ======");
				System.out.println("1. 사원 목록");
				System.out.println("2. 사원 등록");
				System.out.println("3. 종료");
				System.out.println("=================");
				System.out.println("메뉴 선택: ");
				int menu = scan.nextInt();
				if(menu==3)
				{
					System.out.println("종료되었습니다");
					break;
				}
				else if(menu==1)
				{
					FileReader fr = new FileReader("c:\\java_data\\sawon2.txt");
					int i=0;
					String data = "";
					while((i=fr.read())!=EOF) 
					{
						data+=(char)i;
					}
					String[] sawons = data.split("\n");//사원별
					
					for(String sa : sawons)
					{
						if(sa==null||sa.equals(""))
						{
							System.out.println("등록된 사원이 없습니다");
							break;
						}
						String[] sawon = sa.split("\\|");//사원의 각 정보별
						System.out.println("사번 : "+sawon[0]);
						System.out.println("이름 : "+sawon[1]);
						System.out.println("부서 : "+sawon[2]);
						System.out.println("직위 : "+sawon[3]);
						System.out.println("근무지 : "+sawon[4]);
						System.out.println("연봉 : "+sawon[5]);
						System.out.println("=====================");
					}
					fr.close();
					
				}
				else if(menu==2)
				{
					FileWriter fw = new FileWriter("c:\\java_data\\sawon2.txt",true);
	Sawon sa = new Sawon();
					System.out.print("이름 입력 : ");
					sa.setName(scan.next());
					System.out.print("부서 입력 : ");
					sa.setDept(scan.next());
					System.out.print("직위 입력 : ");
					sa.setJob(scan.next());
					System.out.print("근무지 입력 : ");
					sa.setLoc(scan.next());
					System.out.print("연봉 입력 : ");
					sa.setPay(scan.nextInt());
					
					String msg = maxSabun()+"|"+sa.getName()+"|"+sa.getDept()+"|"+sa.getJob()+"|"+sa.getLoc()+"|"+sa.getPay()+"\r\n";
					System.out.println(msg);
					fw.write(msg);
					System.out.println("사원 등록 완료");
					fw.close();
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public static int maxSabun()
	{
		int max=0;
		FileReader fr = null;
		try 
		{
			fr=new FileReader("c:\\java_data\\sawon2.txt");
			int i=0;
			String data="";
			while((i=fr.read())!=-1)
			{
				data+=(char)i;
			}
			String[] datas=data.split("\n");
			for(String sa : datas)
			{
				String[] sawon = sa.split("//|");
				if(sa==null||sa.equals(""))
				{
					break;
				}
				
				if(max<Integer.parseInt(sawon[0]))
					max=Integer.parseInt(sawon[0]);
				//사번을 계속 입력할 순 없으니까 사번을 자동으로 입력하는 코드
			}
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				fr.close();
			} 
			catch (Exception e2) 
			{
				// TODO: handle exception
			}
		}
		return max+1;
	}

}
