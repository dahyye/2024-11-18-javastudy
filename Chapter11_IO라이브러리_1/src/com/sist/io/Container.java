package com.sist.io;
import java.io.*;
import com.sist.model.*;
import java.util.*;

public class Container {
	//관련된 클래스가 여러개 있는 경우
	//Model(브라우저전송), DAO
	//클래스 모아서 관리(컴포넌트 모아서 관리=>컨테이너)
	private Map<String, Object> clsMap = new HashMap<String, Object>();
	public Container()
	{
//		clsMap.put("a", new A());
//		clsMap.put("b", new B());
//		clsMap.put("c", new C());
//		clsMap.put("d", new D());
//		clsMap.put("e", new E());
//		clsMap.put("f", new F());
//		clsMap.put("g", new G());
//		// 단점 : 클래스가 추가되면 코드를 추가해서 생성해줘야해
		
		
		File dir = new File("C:\\Users\\sist.110\\git\\java-study\\Chapter11_IO라이브러리_1\\src\\com\\sist\\model");
		//com.sist.model의 속성에서 경로명가져오기
		String pack = "com.sist.model";
		File[] files = dir.listFiles();	
		for(File f : files)
		{
			if(f.isFile())
			{
				try {
					String name = f.getName();
					String n=name.substring(0,name.lastIndexOf("."));
					String cls = pack+"."+n;
					//동적으로 메모리 할당 -> 리플렉션
					Class clsName = Class.forName(cls);
					Object obj = clsName.getDeclaredConstructor().newInstance();
					clsMap.put(n.toLowerCase(),obj);
				} 
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	//요청시마다 클래스를 찾아주는 역할
	public I getBean(String key)
	{
		return (I)clsMap.get(key);
	}

}
