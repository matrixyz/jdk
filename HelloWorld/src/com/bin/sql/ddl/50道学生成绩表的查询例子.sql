
Student(Sid,Sname,Sage,Ssex) 学生表       Sid：学号；Sname：学生姓名；Sage：学生年龄；Ssex：学生性别
Course(Cid,Cname,Tid) 课程表                    Cid,课程编号；Cname：课程名字；Tid：教师编号
SC(Sid,Cid,score) 成绩表                             Sid：学号；Cid,课程编号；score：成绩
Teacher(Tid,Tname) 教师表                        Tid：教师编号； Tname：教师名字

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
insert into  student values(1,'jack',17,'男');
insert into  student values(2,'lucy',18,'女');

create table course  (
cid int primary key,
cname varchar(20),
tid int
);

insert into  course values(1,'语文',1);
insert into  course values(2,'数学',2);



create table sc (
 sid int, 
cid int,
score int
);
 insert into  sc values(1,1,100);
 insert into  sc values(1,2,80);
 insert into  sc values(2,1,98);
 insert into  sc values(2,2,90);

--1、查询“1”课程比“2”课程成绩高的所有学生的学号； 
  select a.Sid ,'aaa' from (select sid,score from SC where Cid=1) a,(select sid,score 
  from SC where Cid=2) b 
  where a.score>b.score and a.sid=b.sid; 
--2、查询平均成绩大于60分的同学的学号和平均成绩；  
  select Sid,avg(score) 
    from sc 
    group by Sid having avg(score) >60; 
  --2.1、查询每门成绩都大于60分的同学的学号和名字；  
  select sc.sid,sname from (
 select sid from sc where sid not in
 (select sid from sc where score <=60) group by sid) sc left join 
 student s on s.sid=sc.sid;
 --3、查询所有同学的学号、姓名、选课数、总成绩； 
  select Student.Sid,Student.Sname,count(SC.Cid),sum(score) 
  from Student left Outer join SC on Student.Sid=SC.Sid 
  group by Student.Sid,Sname 
 
 --4、查询姓“李”的老师的个数； 
  select count(distinct(Tname)) 
  from Teacher 
  where Tname like '李%';

 --5、查询没学过“叶平”老师课的同学的学号、姓名； 
    select Student.Sid,Student.Sname 
    from Student  
    where Sid not in (select distinct( SC.Sid) from
    SC,Course,Teacher where  SC.Cid=Course.Cid and 
  Teacher.Tid=Course.Tid and Teacher.Tname='叶平'); 
  
--6、查询学过“001”并且也学过编号“002”课程的同学的学号、姓名；   
select sid,sname  from student where sid in(
  select a.sid from sc a ,sc b where a.cid=1 and b.cid=2 and a.sid=b.sid);
  
    select Student.Sid,Student.Sname from Student,SC where Student.Sid=SC.Sid and SC.Cid=1 and 
    exists( Select * from SC as SC_2 where SC_2.Sid=SC.Sid and SC_2.Cid=2); 
    
 --7、查询学过“叶平”老师所教的所有课的同学的学号、姓名；
  select Sid,Sname 
  from Student 
  where Sid in (
    select sid from sc where cid in 
    (select cid from course where cid =(select tid from teacher where tname='叶平'))  
    group by sid having count(cid)=(
    select count(*) from sc where cid in (select cid from course where cid =(select tid from teacher where tname='叶平')))
    
    );--这种方式更加耗时
    
    select Sid,Sname 
  from Student 
  where Sid in (
  select Sid from SC ,Course ,Teacher where SC.Cid=Course.Cid and Teacher.Tid=Course.Tid and Teacher.Tname='叶平' group by Sid 
  having count(SC.Cid)=(select count(Cid) from Course,Teacher  where Teacher.Tid=Course.Tid and Tname='叶平'));
    
  --8、查询课程编号“002”的成绩比课程编号“001”课程低的所有同学的学号、姓名；   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% hard understand

  Select Sid,Sname from (
      select Student.Sid,Student.Sname,score ,(select score from SC SC_2 where SC_2.Sid=Student.Sid and SC_2.Cid=2) score2 
      from Student,SC where Student.Sid=SC.Sid and Cid=1
  
  ) S_2 where score2 <score; 
    
    --9、查询所有课程成绩小于60分的同学的学号、姓名； 
  select Sid,Sname 
  from Student 
  where Sid not in (select s.Sid from Student s,SC where S.Sid=SC.Sid and score>60); 
    
   --10、查询没有学全所有课的同学的学号、姓名； 
    select Student.Sid,Student.Sname 
    from Student,SC 
    where Student.Sid=SC.Sid group by  Student.Sid,Student.Sname having count(Cid) <
    (select count(Cid) from Course); 
    
    
    select student.sname,sc.sid,sc.cid from student,sc where student.sid=sc.sid  and cid in(select cid from sc where sid=1);
    
--11、查询至少有一门课与学号为“1001”的同学所学相同的同学的学号和姓名；    
    select distinct(student.Sid),Sname from Student,SC where 
Student.Sid=SC.Sid and Cid in (select Cid from SC where Sid=1);
    
    
    
--12、查询至少学过学号为“001”同学所有一门课的其他同学学号和姓名；
select distinct(s.sname),s.sid from sc,student s where  s.sid=sc.sid and sc.cid in (

select  cid from sc where sid=1)
    
    
    --13、把“SC”表中“叶平”老师教的课的成绩都更改为此课程的平均成绩； 
update SC   set  score=(
    select t from(
           select avg(SC_2.score) as t  from SC SC_2  where SC_2.Cid = (
           select Course.cid from Course,Teacher  where  
           Course.Tid=Teacher.Tid and Teacher.Tname='叶平' )  
    ) as xx
)
where  cid=(
    select Course.cid from Course,Teacher  where  
    Course.Tid=Teacher.Tid and Teacher.Tname='叶平' )      
    
 --17、按平均成绩从高到低显示所有学生的“数据库”、“企业管理”、“英语”三门的课程成绩，按如下形式显示： 学生ID,,数据库,企业管理,英语,有效课程数,有效平均分
  SELECT Sid as 学生ID 
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=1) AS 数学
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=2) AS 语文
        ,(SELECT score FROM SC WHERE SC.Sid=t.Sid AND Cid=3) AS 英语 
        ,COUNT(*) AS 有效课程数, AVG(t.score) AS 平均成绩 
    FROM SC AS t 
    GROUP BY Sid 
    ORDER BY avg(t.score)  


    
    
    
  