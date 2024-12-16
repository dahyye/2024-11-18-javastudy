package 취업정보;

//오라클 설치 

//https://www.oracle.com/kr/database/technologies/xe-downloads.html
//Oracle Database 21c Express Edition for Windows x64
//다운받은 파일  C:\oracleDev 폴더안에 넣기
//폴더에 알집풀기
//setup파일설치
//happy
//sqlplus검색후 관리자권한클릭
//system->비밀번호 입력->alter session set "_ORACLE_SCRIPT"=true;-> 세션이 변경되었습니다 //비밀번호에 #붙여야하는데 그걸 안하기 위해 변경
//create user hr identified by happy; -> 사용자가 생성  //hr이라는 계정에 비밀번호 happy
//grant create session to hr;    //권한부여
//grant connect,resource to hr;
//alter user hr default tablespace users quota unlimited on users; ->사용자가 변경되었습니다.  //테이블스페이스 설정
//conn hr/happy -> 연결되었습니다
//@c:\oracleDev\emp -> 파일에 저장되어 있는 emp라는 파일 읽어오기
//select * from emp; -> 데이터 출력
//exit -> 나가기
//C:\app\sist.110\product\21c\dbhomeXE\network\admin\sample 에서 tns안에 1521확인

//C:\app\sist.110\product\21c\dbhomeXE\jdbc\lib안에 있는 ojdbc8.jar파일을 오라클dev폴더안에 넣기



//sql developer 설치
//https://www.oracle.com/kr/database/sqldeveloper/technologies/download/
//Windows 64-bit with JDK 17 included


//네이버 카페 오라클 교재 데이터베이스 다운(알집안에 파일3개) 후 oracleDev폴더안에 넣기

public class 수업_설치 {

}
