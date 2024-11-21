/*
 1. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{  
    int a, b;  
    a = 6;  
    b = 2;   
    System.out.printf("덧셈 연산 결과: %d \n", a+b);  
    System.out.printf("뺄셈 연산 결과: %d \n", a-b);  
    System.out.printf("곱셈 연산 결과: %d \n", a*b);  
    System.out.printf("나누기 연산 결과: %d \n", a/b);
    System.out.printf("나머지 연산 결과: %d \n", a%b);
}


덧셈 연산 결과: 8
뺄셈 연산 결과: 4
곱셈 연산 결과: 12
나누기 연산 결과: 3
나머지 연산 결과: 0


2. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{  
      int num1, num2;   
      num1 = 10/3;
       // '몫' 출력   
      num2 = 10%3;
       // '나머지' 출력
   System.out.printf("몫: %d \n", num1);   
   System.out.printf("나머지: %d \n", num2); 
}


몫: 3
나머지:1


3. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{
     int num1=1, num2=2, num3=3, num4=4, num5=5;     
     num1 = num1 +    num2;
     num2 = num2 - 2;     
     num3 = num3 * 2;     
     num4 = num4 / 2;     
     num5 = num5 % 2;     
     System.out.printf( "%d, %d, %d, %d, %d   \n",num1,num2,num3,num4,num5);   
}

3, 0, 6, 2, 1


4. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{
      int num1=10;   
      System.out.printf("%d \n", num1);
      num1++;
      System.out.printf("%d \n", num1);
      ++num1;
      System.out.printf("%d \n", num1);
      --num1;
      System.out.printf("%d \n", num1);
      num1--;
      System.out.printf("%d \n", num1);
}


10
11
12
11
10



5. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{
       int num1=10, num2=10;   
       int a, b;   
       a = ++num1;
       b = num2++;

       System.out.printf("%d, %d \n", b, num2);
}

B=10
Num2=11


6. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{
        int num1=10, num2=10;   
        int a, b;   
        num1 = num1 + 1;
        a = num1;
        System.out.printf("%d, %d \n", a, num1);
        b = num2;
        num2 = num2 + 1;
        System.out.printf("%d, %d \n", b, num2);
}

A=11,Num1=11
B=10,num2=11



7. 다음 결과값을 작성하시오

public static void main(String[] arg) 
{
    int num1=10, num2=10;
    System.out.printf("%d \n", ++num1);
    System.out.printf("%d \n", num1);
    System.out.printf("%d \n", num2++);
    System.out.printf("%d \n", num2);
}

11
11
10
11



8. 다음 괄호안에 맞는 연산자를 작성하시오

public class Main {
       public static void main(String[] args) {
             
             int a = 5;
             int b = 5;
             
             System.out.println("a와 b가 같은가요?" + (    ));
             System.out.println("a가 b보다 큰가요?" + (     ));
             System.out.println("a가 b보다 작은 가요 ?" + (    ));
             System.out.println("a가 b와 같은면서 3보다 큰가요?" +   (         ));
             System.out.println("a가 50이 아닌가요? " + (         ));
             
       }
}
(boolean)(a==b)
(boolean)(a>b)
(boolean)(a<b)
(boolean)(a==b&&a>3)
(boolean)(a==50)






 
 */






import java.util.Scanner;
public class 자바제어문_단일조건문test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 9. Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 양수인지 음수인지 판별하여 출력하라
		/*
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		
		int a=scan.nextInt();
		System.out.println(a>=0 ? a+"는(은)양수입니다" : a+"는(은)음수입니다");
		*/
		
		
		
		/* 
	
		10. 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라

	
		*/
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		
		int a=scan.nextInt();
		System.out.println(a%3==0 ? a+"는(은)3의배수" : a+"는(은)3의배수가아니다");
		*/
		
		/* 
		
		11. Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.


	
		*/
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("2자리 정수(10~99)를 입력해주세요 : ");
		
		int a=scan.nextInt();
		int b=a/10;
		int c=a%10;
		
		System.out.println(b==c ? "10의자리와 1의자리가같습니다" : "10의자리와 1의자리가다릅니다");
		*/
		/*
		 
		 12. 숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울, 그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라. 


		*/
		/*
		 
		Scanner scan=new Scanner(System.in);
		System.out.print("달를 입력해주세요(1~12) : ");
		
		int a=scan.nextInt();
		
		if(a>=3&&a<=5){
			System.out.println(a+"월은 봄입니다");
		}
		if(a>=6&&a<=8) {
			System.out.println(a+"월은 여름입니다");
		}
		if(a>=9&&a<=11) {
			System.out.println(a+"월은 가을입니다");
		}
		if(a==12||a==1||a==2) {
			System.out.println(a+"월은 겨울입니다");
		}
		
		*/
		


		
	}

}
