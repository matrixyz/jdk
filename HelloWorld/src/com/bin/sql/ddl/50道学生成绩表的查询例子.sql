
Student(Sid,Sname,Sage,Ssex) ѧ����       Sid��ѧ�ţ�Sname��ѧ��������Sage��ѧ�����䣻Ssex��ѧ���Ա�
Course(Cid,Cname,Tid) �γ̱�                    Cid,�γ̱�ţ�Cname���γ����֣�Tid����ʦ���
SC(Sid,Cid,score) �ɼ���                             Sid��ѧ�ţ�Cid,�γ̱�ţ�score���ɼ�
Teacher(Tid,Tname) ��ʦ��                        Tid����ʦ��ţ� Tname����ʦ����

create table teacher(
tid int primary key,
tname varchar(20)
)
insert into teacher values(1,'tom li');
insert into teacher values(2,'frank hu');
select * from teacher;


CREATE TABLE student (
	sid INT NOT NULL,
	sname VARCHAR(20),
	sage INT,
	ssex VARCHAR(2),
	PRIMARY KEY (sid)
)  ;
insert into  student values(1,'jack',17,'��');
insert into  student values(2,'lucy',18,'Ů');

create table course  (
cid int primary key,
cname varchar(20),
tid int
);

insert into  course values(1,'����',1);
insert into  course values(2,'��ѧ',2);



create table sc (
 sid int, 
cid int,
score int
);
 insert into  sc values(1,1,100);
 insert into  sc values(1,2,80);
 insert into  sc values(2,1,98);
 insert into  sc values(2,2,90);

--1����ѯ��1���γ̱ȡ�2���γ̳ɼ��ߵ�����ѧ����ѧ�ţ� 
  select a.Sid ,'aaa' from (select sid,score from SC where Cid=1) a,(select sid,score 
  from SC where Cid=2) b 
  where a.score>b.score and a.sid=b.sid; 
--2����ѯƽ���ɼ�����60�ֵ�ͬѧ��ѧ�ź�ƽ���ɼ���  
  select Sid,avg(score) 
    from sc 
    group by Sid having avg(score) >60; 
  --2.1����ѯÿ�ųɼ�������60�ֵ�ͬѧ��ѧ�ź����֣�  
  select sc.sid,sname from (
 select sid from sc where sid not in
 (select sid from sc where score <=60) group by sid) sc left join 
 student s on s.sid=sc.sid;
 --3����ѯ����ͬѧ��ѧ�š�������ѡ�������ܳɼ��� 
  select Student.Sid,Student.Sname,count(SC.Cid),sum(score) 
  from Student left Outer join SC on Student.Sid=SC.Sid 
  group by Student.Sid,Sname 
 
 --4����ѯ�ա������ʦ�ĸ����� 
  select count(distinct(Tname)) 
  from Teacher 
  where Tname like '��%';

 --5����ѯûѧ����Ҷƽ����ʦ�ε�ͬѧ��ѧ�š������� 
    select Student.Sid,Student.Sname 
    from Student  
    where Sid not in (select distinct( SC.Sid) from
    SC,Course,Teacher where  SC.Cid=Course.Cid and 
  Teacher.Tid=Course.Tid and Teacher.Tname='Ҷƽ'); 
  
--6����ѯѧ����001������Ҳѧ����š�002���γ̵�ͬѧ��ѧ�š�������   
select sid,sname  from student where sid in(
  select a.sid from sc a ,sc b where a.cid=1 and b.cid=2 and a.sid=b.sid);
  
    select Student.Sid,Student.Sname from Student,SC where Student.Sid=SC.Sid and SC.Cid=1 and 
    exists( Select * from SC as SC_2 where SC_2.Sid=SC.Sid and SC_2.Cid=2); 
    
 --7����ѯѧ����Ҷƽ����ʦ���̵����пε�ͬѧ��ѧ�š�������
  select Sid,Sname 
  from Student 
  where Sid in (
    select sid from sc where cid in 
    (select cid from course where cid =(select tid from teacher where tname='Ҷƽ'))  
    group by sid having count(cid)=(
    select count(*) from sc where cid in (select cid from course where cid =(select tid from teacher where tname='Ҷƽ')))
    
    );--���ַ�ʽ���Ӻ�ʱ
    
    select Sid,Sname 
  from Student 
  where Sid in (
  select Sid from SC ,Course ,Teacher where SC.Cid=Course.Cid and Teacher.Tid=Course.Tid and Teacher.Tname='Ҷƽ' group by Sid 
  having count(SC.Cid)=(select count(Cid) from Course,Teacher  where Teacher.Tid=Course.Tid and Tname='Ҷƽ'));
    
  --8����ѯ�γ̱�š�002���ĳɼ��ȿγ̱�š�001���γ̵͵�����ͬѧ��ѧ�š�������   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% hard understand

  Select Sid,Sname from (
      select Student.Sid,Student.Sname,score ,(select score from SC SC_2 where SC_2.Sid=Student.Sid and SC_2.Cid=2) score2 
      from Student,SC where Student.Sid=SC.Sid and Cid=1
  
  ) S_2 where score2 <score; 
    
    --9����ѯ���пγ̳ɼ�С��60�ֵ�ͬѧ��ѧ�š������� 
  select Sid,Sname 
  from Student 
  where Sid not in (select s.Sid from Student s,SC where S.Sid=SC.Sid and score>60); 
    
   --10����ѯû��ѧȫ���пε�ͬѧ��ѧ�š������� 
    select Student.Sid,Student.Sname 
    from Student,SC 
    where Student.Sid=SC.Sid group by  Student.Sid,Student.Sname having count(Cid) <
    (select count(Cid) from Course); 
    
    
    select student.sname,sc.sid,sc.cid from student,sc where student.sid=sc.sid  and cid in(select cid from sc where sid=1);
    
--11����ѯ������һ�ſ���ѧ��Ϊ��1001����ͬѧ��ѧ��ͬ��ͬѧ��ѧ�ź�������    
    select distinct(student.Sid),Sname from Student,SC where 
Student.Sid=SC.Sid and Cid in (select Cid from SC where Sid=1);
    
    
    
--12����ѯ����ѧ��ѧ��Ϊ��001��ͬѧ����һ�ſε�����ͬѧѧ�ź�������
select distinct(s.sname),s.sid from sc,student s where  s.sid=sc.sid and sc.cid in (

select  cid from sc where sid=1)
    
    
    --13���ѡ�SC�����С�Ҷƽ����ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ��� 
update SC   set  score=(
    select t from(
           select avg(SC_2.score) as t  from SC SC_2  where SC_2.Cid = (
           select Course.cid from Course,Teacher  where  
           Course.Tid=Teacher.Tid and Teacher.Tname='Ҷƽ' )  
    ) as xx
)
where  cid=(
    select Course.cid from Course,Teacher  where  
    Course.Tid=Teacher.Tid and Teacher.Tname='Ҷƽ' )      
    
 --17����ƽ���ɼ��Ӹߵ�����ʾ����ѧ���ġ����ݿ⡱������ҵ��������Ӣ����ŵĿγ̳ɼ�����������ʽ��ʾ�� ѧ��ID,,���ݿ�,��ҵ����,Ӣ��,��Ч�γ���,��Чƽ����
  SELECT Sid as ѧ��ID 
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=1) AS ��ѧ
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=2) AS ����
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=3) AS Ӣ�� 
        ,COUNT(*) AS ��Ч�γ���, AVG(t.score) AS ƽ���ɼ� 
    FROM SC AS t 
    GROUP BY Sid 
    ORDER BY avg(t.score)  


    
    
    
  