package 데이터베이스;
/*
 
 GROUP BY 문제
관리자 페이지 -> 분기별 통계 / 회원통계
그룹을 나눠서 그룹별 처리
--- 컬럼안에 같은 값을 가지고 있는 것을 설정
	------------ 부서별 / 직위별 / 입사일별 / 함수를 이용해서 처리가능

1. 각 부서별로 최대 급여를 구하세요.
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

2. 각 직급(job)별로 최대 급여를 구하세요. 
SELECT job, MAX(sal)
FROM emp
GROUP BY job;
//2중
SELECT deptno, job, SUM(sal),AVG(sal),COUNT(*)
FROM emp
GROUP BY detpno,job
ORDER BY deptno ASC;

3. 각 부서별로 평균 급여를 구하세요.
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
ORDER BY deptno;

4. 각 직급(job)별의 인원수를 구하세요.
SELECT job, COUNT(*)
FROM emp
GROUP BY job;

5. 각 부서별 보너스(comm)을 받는  인원수 출력 . 
SELECT deptno, COUNT(*)
FROM emp
WHERE comm!=0 AND comm IS NOT NULL
GROUP BY deptno;

6. 각 년도별로 입사한 인원수를 구하세요.

SELECT SUBSTR(hiredate,1,2), COUNT(*)
FROM emp
GROUP BY SUBSTR(hiredate,1,2)



7.  부셔별 평균급여를 구하고 그 결과 평균급여가 2000 이상인 부서만 출력하세요.
SELECT deptno,avg(sal), COUNT(*)
FROM emp
GROUP BY deptno
HAVING avg(sal)>=2000

JOIN 문제
1. 사원 이름이 SCOTT인 사원의 사번(empno), 이름(ename), 부서명(dname)를 출력하세요.
SELECT empno, ename, dname
FROM emp, dept
WHERE emp.deptno=dept.deptno AND ename='SCOTT';


SELECT empno, ename, dname
FROM emp JOIN dept
ON emp.deptno=dept.deptno AND ename='SCOTT';

2. 사원이름과 급여(sal)와 급여등급(grade)을 출력하세요.
SELECT ename, sal, grade
FROM emp, salgrade
WHERE sal BETWEEN salgrade.losal AND salgrade.hisal

SELECT ename, sal, grade
FROM emp JOIN salgrade
ON sal BETWEEN salgrade.losal AND salgrade.hisal


3. 위 2번문제에서 부서명을 추가시켜 출력하세요.
SELECT ename, sal, grade, dname
FROM emp, salgrade, dept
WHERE emp.deptno=dept.deptno AND sal BETWEEN salgrade.losal AND salgrade.hisal

SELECT ename, sal, grade, dname
FROM emp JOIN dept
ON emp.deptno=dept.deptno  
JOIN salgrade
ON sal BETWEEN salgrade.losal AND salgrade.hisal


4. 사원이름과 매니저의 이름을 아래와 같은 형식으로 출력하세요.
     "XXX"의 매니져는 "XXX" 입니다. 
SELECT '"'||ename||'" 의 매니저는 "'||job||'"입니다.'
FROM emp;

매니저?

5. 부서번호가 30번인 사원들의 이름, 직급(job), 부서번호(deptno), 부서위치(loc)를 출력하세요.
SELECT ename, job, emp.deptno, loc
FROM emp, dept
WHERE emp.deptno=dept.deptno AND emp.deptno=30;	

SELECT ename, job, emp.deptno, loc
FROM emp JOIN dept
ON emp.deptno=dept.deptno AND emp.deptno=30;

6. 보너스(comm)을 받은사원의 이름, 보너스, 부서명, 부서위치를 출력하세요.
SELECT ename, comm, dname, loc
FROM emp, dept
WHERE emp.deptno=dept.deptno AND comm IS NOT NULL AND comm!=0;

SELECT ename, comm, dname, loc
FROM emp JOIN dept
ON emp.deptno=dept.deptno AND comm IS NOT NULL AND comm!=0;



7. DALLAS에서 근무하는 사원들의 이름, 직급, 부서번호, 부서명을 출력하세요.
SELECT ename, job, emp.deptno, dname
FROM emp, dept	
WHERE emp.deptno=dept.deptno AND loc='DALLAS';


SELECT ename, job, emp.deptno, dname
FROM emp JOIN dept	
ON emp.deptno=dept.deptno AND loc='DALLAS';



8. 이름에 'A'가 들어가는 사원들의 이름과 부서명을 출력하세요.

SELECT ename, dname
FROM emp, dept
WHERE emp.deptno=dept.deptno AND ename LIKE '%A%';


SELECT ename, dname
FROM emp JOIN dept
ON emp.deptno=dept.deptno AND ename LIKE '%A%';

 
 
 */
public class 데이터베이스_GROUPBY_JOIN예제 {

}
