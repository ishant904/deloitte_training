select first_name,job_id,nvl(commission_pct,0.10) from employees where job_id like '%CLERK';
select last_name,salary,commission_pct,nvl2(commission_pct,'sal+comm','sal')income from employees where department_id in (50,80);
select first_name, length(first_name)"expr1",last_name,length(last_name)"expr2",nullif(length(first_name),length(last_name))result from employees;
select manager_id from employees where last_name='King';
select last_name,job_id,salary,
CASE job_id when 'IT_PROG' then 1.10*salary
            when 'ST_CLERK' then 1.15*salary
            else salary end "REVISED SALARY" from employees;
select last_name , department_id,salary,
decode(department_id,10,1.10*salary,
20,1.15*salary,
30,1.20*salary)SALARY from employees;
select last_name,salary,DECODE(TRUNC(salary/2000,0),0,0.00,1,0.09,2,0.20,3,0.30,4,0.40,5,0.42,6,0.44,0.45)TAX_RATE from employees where department_id=80;
select count(*) from employees where (select salary from employees group by department_id having salary - min(salary)>=4000);
select department_id,count(*) from employees group by department_id;
select department_id,job_id,sum(salary)from employees group by department_id,job_id;
select count(*) from employees where salary=(select salary from employees group by department_id having salary - min(salary)>=4000);
select e.employee_id,e.last_name,e.department_id,d.department_id,d.location_id from employees e join departments d on (e.department_id=d.department_id);
select e.last_name emp,m.last_name mng from employees e join employees m on (e.manager_id=m.employee_id); 
select e.employee_id,l.city,d.department_name from employees e join departments d on d.department_id=e.department_id join locations l on d.location_id=l.location_id where l.city='Seattle';
select last_name,department_name from employees cross join departments;
select last_name from employees where salary > (select salary from employees where last_name='Abel');
select last_name ,job_id,salary from employees where job_id=(select job_id from employees where employee_id =141) and salary>(select salary from employees where employee_id=143);
select last_name,job_id,salary from employees where salary <(select avg(salary)from employees);
select employee_id,last_name from employees where job_id any (select job_id from employees group by employee_id );
select e.last_name emp,m.last_name mng from employees e join employees m on (e.manager_id=m.employee_id); 
select first_name,employee_id,manager_id from employees;
select distinct manager_id from employees;
select last_name,department_id from employees where department_id in(20,50) ;
select last_name,hire_date from employees where hire_date like '%04';
select last_name from employees where last_name like '%a%e%'or last_name like '%e%a%';
select last_name,job_id,salary from employees where (job_id='SA_REP' or job_id ='ST_CLERK') and salary not in(2500,3500,7000);
select initcap(last_name),length(select last_name from employees where last_name like 'J%' or last_name like 'A%' or last_name like 'M%' ) from employees ;
select last_name from employees where last_name like 'J%' or last_name like 'A%' or last_name like 'M%';
select last_name , round(months_between(sysdate,hire_date),0) from employees;
select e.last_name,e.hire_date,m.last_name,m.hire_date from employees e ,employees m where e.manager_id=m.employee_id and e.hire_date < m.hire_date;
select e.employee_id,e.last_name,e.department_id from employees e join departments d on e.department_id=d.department_id  join locations l on d.location_id=l.location_id where l.city like 'T%' ;
select outer.last_name from employees outer where not exists (select 'x' from employees inner where inner.manager_id=outer.employee_id);
select e.last_name,e.salary from employees e where e.hire_date > any(select a.hire_date from employees a where e.department_id=a.department_id and e.salary>a.salary); 
select last_name from employees outer where exists(select 'x' from employees inner where inner.department_id=outer.department_id and inner.hire_date>outer.hire_date and inner.salary>outer.salary);
select distinct e.last_name,a.last_name,e.hire_date,a.hire_date,e.salary,a.salary,e.department_id,a.department_id from employees e join employees a on (e.department_id=a.department_id) where (e.hire_date > a.hire_date) and (e.salary>a.salary) and (e.employee_id<>a.employee_id) ;
select e.department_id,sum(salary),(select department_name from department d where e.department_id=d.department_id) from employees e group by department_id having ;
select role_id,name from role;

set serveroutput on;
DECLARE 
a Number := 3;
BEGIN
a := a+1;
DBMS_output.put_line(a);
END;
/

insert into employee_salary values(1,'Ishant',15000,4000,1000,5000,15000,20000);
insert into employee_salary values(2,'Ram',31000,8000,1000,5000,35000,40000);
insert into employee_salary values(3,'Shyam',14000,4000,1000,5000,15000,19000);
insert into employee_salary values(4,'Jam',14000,4000,1000,5000,15000,19000);
select * from employee_salary;
delete from employee_salary where emp_name='Yash';






























