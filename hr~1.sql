set serveroutput on;
DECLARE 
a Number := 4;
BEGIN
a := a+1;
if mod(a,2)=0 then
DBMS_output.put_line(a);
else
DBMS_output.put_line(a+1);
end if;
END;
/

DECLARE 
i NUMBER :=1;
BEGIN
LOOP
INSERT INTO T1 VALUES(i,i+1);
i:=i+1;
EXIT WHEN i>100;
END LOOP;
END;
/

select * from t1;

DECLARE 
a Number :=1;
BEGIN
while (a<10) LOOP
a:=a+1;
DBMS_output.put_line(a);
END LOOP;
END;
/

DECLARE
k NUMBER :=1;
BEGIN
FOR a in 1..10 LOOP
k:=k+1;
DBMS_output.put_line(k);
END LOOP;
END;
/

set SERVEROUTPUT ON SIZE 1000000;
DECLARE
n_pct employees.commission_pct%TYPE;
v_eval varchar2(10);
n_emp_id employees.employee_id%TYPE:=145;
BEGIN 
select commission_pct
into n_pct
from employees
where employee_id=n_emp_id;
case n_pct
when 0 then
v_eval := 'N/A';
when 0.1 then 
v_eval := 'Low';
when 0.4 then 
v_eval := 'High';
else
v_eval := 'Fair';
END CASE;
DBMS_output.put_line('Employee'||n_emp_id||'commision'||TO_CHAR(n_pct)||'which is'||v_eval);
END;
/


set serveroutput on;
declare
r_role role.role_id%TYPE;
v_eval varchar2(10);
r_name role.name%TYPE:='Ishant';
begin
select role_id into r_role from users where name=r_name;
case r_role
when 104 then 
v_eval:='dev';
when 105 then 
v_eval:='admin';
else
v_eval:='non';
end case;
DBMS_output.put_line(v_eval);
end;
/

set SERVEROUTPUT ON;
declare
emps_name employee_salary.emp_name%type:='Ishant';
 v_eval   varchar2(10);
emp_id    employee_salary.emp_no%type;
emp_gross employee_salary.gross_salary%type;
begin
SELECT gross_salary
  INTO emp_gross
  FROM employee_salary
  WHERE emp_name = emps_name;
CASE
    WHEN emp_gross<20000 THEN
      v_eval := 0.1*emp_gross;
    WHEN 20000<=emp_gross and emp_gross<40000  THEN
      v_eval := 0.2*emp_gross;
    WHEN 40000<=emp_gross THEN
      v_eval := 0.3*emp_gross;
    ELSE
      v_eval := 'Invalid';
  END CASE;
  DBMS_OUTPUT.PUT_LINE('Employee ' || emps_name || 
                       ' taxes = ' || v_eval ||
                       ' on gross '   || emp_gross);
END;
/

set SERVEROUTPUT ON;
<<parent>>
declare 
emps_name employee_salary.emp_name%type:='&a';
begin 
insert into employee_salary values(6,emps_name,19000,4000,1000,5000,25000,30000);
<<child>>
declare
 v_eval   varchar2(10);
emp_id    employee_salary.emp_no%type;
emp_gross employee_salary.gross_salary%type;
begin
SELECT gross_salary
  INTO emp_gross
  FROM employee_salary
  WHERE emp_name = parent.emps_name;
CASE
    WHEN emp_gross<20000 THEN
      v_eval := 0.1*emp_gross;
    WHEN 20000<=emp_gross and emp_gross<40000  THEN
      v_eval := 0.2*emp_gross;
    WHEN 40000<=emp_gross THEN
      v_eval := 0.3*emp_gross;
    ELSE
      v_eval := 'Invalid';
  END CASE;
  DBMS_OUTPUT.PUT_LINE('Employee ' || parent.emps_name || 
                       ' taxes = ' || v_eval ||
                       ' on gross '   || emp_gross);
END;
END;
/


set serveroutput on;
declare
cursor cur_cheif is
select u.name as uname,r.name as rname from users u inner join role r on u.role_id=r.role_id;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
loop
fetch cur_cheif into r_cheif;
exit when cur_cheif%NOTFOUND;
DBMS_OUTPUT.PUT_LINE(r_cheif.uname||r_cheif.rname);
end loop;
close cur_cheif;
end;
/

set serveroutput on;
declare
temp number(5);
cursor cur_cheif is
select a , b from t1 where a < b for update;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
--loop
--fetch cur_cheif into r_cheif;
--exit when cur_cheif%NOTFOUND;
--temp:=r_cheif.a;
update t1 set a=b,b=a ;
--end loop;
close cur_cheif;
end;
/

set serveroutput on;
declare
temp number(5);
cursor cur_cheif is
select a , b from t1 where a < b for update;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
loop
fetch cur_cheif into r_cheif;
exit when cur_cheif%NOTFOUND;
temp:=r_cheif.a;
update t1 set a=b,b=a where current of cur_cheif;
end loop;
close cur_cheif;
end;
/

delete from t1;
select * from employees;
select * from users;

set serveroutput on;
declare
cursor cur_cheif is
select last_name,salary,hire_date from copy_emp where hire_date>'1-JAN-05' for update;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
loop
fetch cur_cheif into r_cheif;
exit when cur_cheif%NOTFOUND;
update copy_emp set salary=salary+0.1*salary where current of cur_cheif;
end loop;
close cur_cheif;
end;
/

set serveroutput on;
declare
tmp date;
cursor cur_cheif is
select last_name,hire_date from employees order by hire_date;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
--loop
fetch cur_cheif into r_cheif;
--exit when cur_cheif%NOTFOUND;
--end loop;
DBMS_OUTPUT.PUT_LINE(r_cheif.last_name||r_cheif.hire_date);
close cur_cheif;
end;
/

select last_name,hire_date from employees order by hire_date;

set serveroutput on;
declare
cursor cur_cheif is
select u.name as uname ,r.name as rname from users u join role r on u.role_id=r.role_id;
r_cheif cur_cheif%ROWTYPE;
begin
open cur_cheif;
loop
fetch cur_cheif into r_cheif;
exit when cur_cheif%NOTFOUND;
DBMS_OUTPUT.PUT_LINE(r_cheif.uname||' '||r_cheif.rname);
end loop;
end;
/


set serveroutput on;
declare
type emp is record(
first_name employee.first_name%TYPE;
emp_id employee.employee_id%TYPE;
);
emp_re emp;
type dept2 is record(
dept_name department.department_name%TYPE;
dept_id department.department_id%TYPE;
);
dept_re dept2;
type edl is record(
emp_rec emp;
dept_rec dept2;
loc_id location.location_id%TYPE;
loc_name location.city%TYPE;
);
edl_re edl;
cursor cur_cheif1 is
select first_name,employee_id from employees;
cursor cur_cheif2 is 
select department_name,department_id from departments;
cursor cur_cheif3;
begin
open cur_cheif1;
open cur_cheif2;
loop
fetch cur_cheif1 into emp_re ;
fetch cur_cheif2 into dept_re;
exit when cur_cheif1%NOTFOUND;
exit when cur_cheif2%NOTFOUND;
cursor cur_cheif3 is
select city,location_id from location where emp_re.first_name

DBMS_OUTPUT.PUT_LINE(r_cheif.uname||' '||r_cheif.rname);
end loop;
end;
/

DECLARE
    l_name customers.NAME%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the customer
    SELECT NAME INTO l_name
    FROM customers
    WHERE customer_id > l_customer_id;
    
    -- show the customer name   
    dbms_output.put_line('Customer name is ' || l_name);
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_customer_id ||  ' does not exist');
        WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('The database returns more than one customer');    
END;
/

DECLARE
    l_name customers.NAME%TYPE;
    l_customer_id customers.customer_id%TYPE := &customer_id;
BEGIN
    -- get the customer
    SELECT NAME INTO l_name
    FROM customers
    WHERE customer_id = l_customer_id;
    
    -- show the customer name   
    dbms_output.put_line('customer name is ' || l_name);
 
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_customer_id ||  ' does not exist');
END;
/

set serveroutput on;
declare 
pass_too_high exception;
pragma exception_init(pass_too_high,-20408);
u_pass users.password%TYPE:='&a';
u_name users.name%TYPE;
begin
if length(u_pass)<8 then
raise pass_too_high;
end if;
select name into u_name from users where password=u_pass;
dbms_output.put_line('customer name is ' || u_name);
end;
/
select * from users;

set serveroutput on;
declare 
salary_too_high exception;
pragma exception_init(salary_too_high,-20408);
emp_id employees.employee_id%TYPE:=&a;
emp_job_id employees.job_id%TYPE;
emp_sal employees.salary%TYPE:=&b;
emp_sal_min jobs.min_salary%TYPE;
emp_sal_max jobs.max_salary%TYPE;
begin
select job_id into emp_job_id from employees where employee_id=emp_id;
select min_salary,max_salary into emp_sal_min,emp_sal_max from jobs where job_id=emp_job_id;
if emp_sal>emp_sal_min and emp_sal<emp_sal_max then
update employees set salary=emp_sal where employee_id=emp_id;
else
raise salary_too_high;
end if;
dbms_output.put_line(emp_sal);
end;
/

select * from jobs;


create or replace 
procedure hello is
begin
dbms_output.put_line('Hello world');
end;
/

SET SERVEROUTPUT ON;
declare
n number(5):='&a';
begin
dispn(n);
end;
/

create or replace 
procedure dispn(N int)is
begin
DBMS_OUTPUT.PUT_LINE('N is'||N*N);
end;

SET SERVEROUTPUT ON;
declare
id employees.employee_id%TYPE:=&a;
begin
disp_emp(id);
end;
/

create or replace 
procedure disp_emp(Id Number) is
emp_name employees.first_name%TYPE;
emp_sal employees.salary%TYPE;
begin
select first_name,salary into emp_name,emp_sal from employees where employee_id=Id;
DBMS_OUTPUT.PUT_LINE(emp_name||' '||emp_sal);
end;
/

create or replace 
procedure sum_ab(a int, b int, c out int) is
begin
c:=a+b;
end;

declare
R int;
begin
sum_ab(23,29,R);
DBMS_OUTPUT.PUT_LINE(R);
end;

create or replace
procedure emp_disp(Id number, firstName out varchar2 , lastName out varchar2) is
begin
select first_name,last_name into firstName,lastName from employees where employee_id=Id;
DBMS_OUTPUT.PUT_LINE(firstName||' '||lastName);
end;

set SERVEROUTPUT ON;
declare
id employees.employee_id%TYPE:=&a;
firstName employees.first_name%TYPE;
lastName employees.last_name%TYPE;
begin
emp_disp(id,firstName,lastName);
end;
/

create or replace
procedure emp_sal(firstName varchar2 , salary_emp out number) is
begin
select salary into salary_emp from employees where first_name=firstName;
DBMS_OUTPUT.PUT_LINE(salary_emp);
end;


set SERVEROUTPUT ON;
declare
firstName employees.first_name%TYPE:='&a';
emp_s employees.salary%TYPE;
begin
emp_sal(firstName,emp_s);
end;
/

select first_name,last_name,salary from employees where first_name='Steven';

create or replace
function add_two(a int, b int) return int is
begin
return(a+b);
end;
/


create or replace
function addSal return int is
total employees.salary%TYPE;
begin
select sum(salary) into total from employees;
return total;
end;
/

begin
DBMS_OUTPUT.PUT_LINE(addSal());
end;
/

create or replace 
function incSalary(id number) return number is
sal employees.salary%TYPE;
begin
select salary into sal from employees where employee_id=id;
return (sal+(sal*0.2));
end;
/

declare
emp_id employees.employee_id%TYPE;
begin
DBMS_OUTPUT.PUT_LINE(incSalary(100));
end;
/

CREATE TABLE audits (
      audit_id         NUMBER PRIMARY KEY,
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);

create sequence audit_seq increment by 1 start with 1 maxvalue 1000 nocache nocycle;

CREATE OR REPLACE TRIGGER customers_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON users
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;
 
   -- insert a row into the audit table   
   INSERT INTO audits (audit_id,table_name, transaction_name, by_user, transaction_date)
   VALUES(audit_seq.nextval,'CUSTOMERS', l_transaction, USER, SYSDATE);
END;

/

select * from audits;
update users set name='shyam' where id=120;



CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_salary NUMBER(8,2);
  v_name   VARCHAR2(46);
  n_emp_id NUMBER := &emp_id;
BEGIN
 
  v_name   := personnel.get_fullname(n_emp_id);
  n_salary := personnel.get_salary(n_emp_id);
 
  IF v_name  IS NOT NULL AND
    n_salary IS NOT NULL
  THEN
    dbms_output.put_line('Employee: ' || v_name);
    dbms_output.put_line('Salary:' || n_salary);
  END IF;
END;


create sequence book_seq increment by 1 start with 100 maxvalue 99999 nocache nocycle;   
insert into book values(boo_seq.currval,1503,'Alchemist',300,2005,'novel');






