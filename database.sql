

drop table if exists login_details;
create table login_details (email varchar (50), password varchar (50), role varchar (50));
insert into login_details values  ('2020csb1061@iitrpr.ac.in', '123', 'student');
insert into login_details values  ('2020csb1113@iitrpr.ac.in', '123', 'student');
insert into login_details values  ('2018csb1115@iitrpr.ac.in', '123', 'student');
insert into login_details values ('apurvmudgal@iitrpr.ac.in', '123', 'instructor');
insert into login_details  VALUES('anilshukla@iitrpr.ac.in', '123', 'academics');

insert into login_details  VALUES('123', '123', 'student');
insert into login_details  VALUES('123', '123', 'instructor');
insert into login_details  VALUES('123', '123', 'academics');

//////////////////course_catalog////////////////////////////////
drop table if exists course_catalog;
CREATE TABLE course_catalog (course_code VARCHAR(10),course_title VARCHAR(255),credit_structure VARCHAR(10),prerequisites TEXT[]);
INSERT INTO course_catalog (course_code, course_title, credit_structure, prerequisites)
VALUES
    ('CSE101', 'Introduction to Computer Science', '3-0-2', NULL),
    ('CSE201', 'Data Structures and Algorithms', '3-0-2', '{CSE101}'),
    ('CSE202', 'Introduction to Database Systems', '3-0-2', '{CSE101}'),
    ('CSE301', 'Artificial Intelligence', '3-0-2', '{CSE201, CSE202}'),
    ('CSE401', 'Web Development', '3-0-2', '{CSE101}');



///course done by the student

drop table if exists courses_done;
create table courses_done(course_code varchar(20) primary key, couse_title varchar(255) ,category varchar(5),credit int , grade varchar(2), Year varchar(4), Sem varchar(2));
insert into courses_done VALUES ('cs201','data structures and algorithm', 'PC',3,'A-', '2021', 'I');
insert into courses_done VALUES ('cs202','Programing and paradigms', 'PC',3,'B-', '2021', 'II');



//////////////////////////////////

drop table if exists offered_courses;
create table offered_courses(course_code varchar(20) primary key,couse_title varchar(255) ,  credits int ,category varchar(5), cgpa_criteria float ,prerequisites TEXT[] );
insert into offered_courses VALUES( 'cs101', 'computer awareness',3 , 'PC', 10, '{}');
insert into offered_courses VALUES( 'cs302', 'architechture',3 , 'PC', 7, '{cs517}');
insert into offered_courses VALUES( 'cs301', 'database',3 , 'PC', 7, '{cs201}');



/////////////////////////////////////////////

drop table enrollment_list;
create table enrollment_list(student_id varchar(20) , course_code varchar(20),course_title varchar(255) , credits float ,category varchar(5),Year  varchar(4), Sem varchar(2), grade varchar(2), course_status varchar(10));

insert into enrollment_list VALUES('2020csb1061', 'cs301' , 'Databases' ,4,'PC', '2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'cs302' , 'Analysis and Design Algorith' ,4, 'PC','2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'cs303' , 'Operating System' ,3,'PC', '2022','I', 'A','completed');
insert into enrollment_list VALUES('2020csb1061', 'Hs104' , 'Professional Ethics' ,1.5, 'PE','2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'GE111' , 'ntroduction To Environmental Science And Engineering' ,3,'PE', '2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'BM101A' , 'Biology for Engineers' ,3, 'PE','2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'NS102' , 'NSS II ' ,1,'PE', '2022','I', 'A', 'completed');

insert into enrollment_list VALUES('2020csb1061', 'HS202' , 'HUMAN GEOGRAPHY AND SOCIAL NEEDS' ,3,'PE', '2022','II', 'A-', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'MA202' , 'Probability and Statistics' ,3, 'PE','2022','II', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'GE108' , ' Basic Electronics' ,3,'PE', '2022','II', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'GE109' , 'Introduction to Engineering Products ' ,1.5,'PE', '2022','II', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'CS202' , 'Programming Paradigms and Pragmatics' ,4,'PC', '2022','II', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'CS204' , 'Computer Architecture' ,4,'PC', '2022','II', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1061', 'NS101' , 'NSS I ' ,1, 'PE','2022','II', 'A', 'completed');

insert into enrollment_list VALUES('2020csb1061', 'HS301' , 'Industrial Management' ,3, 'PE','2022','II', NULL, 'running');
insert into enrollment_list VALUES('2020csb1061', 'CS304' , 'Computer Networks' ,4, 'PC','2022','II', NULL, 'running');
insert into enrollment_list VALUES('2020csb1061', 'CS305' , 'Software Engineering' ,4,'PC', '2022','II', NULL, 'running');
insert into enrollment_list VALUES('2020csb1061', 'CS306' , 'Theory of Computation' ,3, 'PC','2022','II', NULL, 'running');
insert into enrollment_list VALUES('2020csb1061', 'CP301' , 'Development Engineering Project' ,3, 'PE','2022','II', NULL, 'running');
insert into enrollment_list VALUES('2020csb1061', 'NS103' , 'NSS III' ,1, 'PE','2022','II', NULL, 'running');


-- for cg
insert into enrollment_list VALUES('2020csb1063', 'NS102' , 'NSS II ' ,1,'PE', '2022','I', 'A', 'completed');
insert into enrollment_list VALUES('2020csb1063', 'cs301' , 'Databases' ,4,'PC', '2022','I', 'A-', 'completed');
insert into enrollment_list VALUES('2020csb1063', 'cs302' , 'Analysis and Design Algorith' ,4, 'PC','2022','I', 'B', 'completed');
insert into enrollment_list VALUES('2020csb1063', 'cs303' , 'Operating System' ,3,'PC', '2022','I', 'B-','completed');
insert into enrollment_list VALUES('2020csb1063', 'Hs104' , 'Professional Ethics' ,1.5, 'PE','2022','I', 'C', 'completed');
insert into enrollment_list VALUES('2020csb1063', 'GE111' , 'ntroduction To Environmental Science And Engineering' ,3,'PE', '2022','I', 'C-', 'completed');
insert into enrollment_list VALUES('2020csb1063', 'BM101A' , 'Biology for Engineers' ,3, 'PE','2022','I', 'D', 'completed');





-- database for completed year student ;

insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');

insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');

insert into enrollment_list VALUES('2018csb1115', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');



insert into enrollment_list VALUES('2018csb1115', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs202', 'human geography ',3,'pe', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs202', 'human geography ',3,'pe', 2020,'I','A-', 'completed');



insert into enrollment_list VALUES('2018csb1115', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');



insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'pe', 2021,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'pe', 2021,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'pe', 2021,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'I','A-', 'completed');



insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2021,'II','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cp302', 'capstone-I',3,'pc', 2021,'II','A-', 'completed');


insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2022,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2022,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2022,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'hs301', 'industrial management',3,'el', 2022,'I','A-', 'completed');
insert into enrollment_list VALUES('2018csb1115', 'cp303', 'capstone-II',3,'pc', 2022,'I','A-', 'completed');



-- database for 3rd  year student

insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');

insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');

insert into enrollment_list VALUES('2020csb1113', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'cs201', 'data structures',3,'pc', 2019,'II','A-', 'completed');



insert into enrollment_list VALUES('2020csb1113', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs202', 'human geography ',3,'pc', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs202', 'human geography ',3,'pe', 2020,'I','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs202', 'human geography ',3,'pe', 2020,'I','A-', 'completed');



insert into enrollment_list VALUES('2020csb1113', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');
insert into enrollment_list VALUES('2020csb1113', 'hs104', 'professional ethics ',3,'pe', 2020,'II','A-', 'completed');



insert into enrollment_list VALUES('2020csb1113', 'hs301', 'industrial management',3,'pe', 2021,'I',null ,'running ');
insert into enrollment_list VALUES('2020csb1113', 'hs301', 'industrial management',3,'pe', 2021,'I', null,'running');
insert into enrollment_list VALUES('2020csb1113', 'hs301', 'industrial management',3,'pe', 2021,'I',null, 'running');
insert into enrollment_list VALUES('2020csb1113', 'hs301', 'industrial management',3,'el', 2021,'I', null,'running');
insert into enrollment_list VALUES('2020csb1113', 'hs301', 'industrial management',3,'el', 2021,'I',null,'running');



-- database for 1 yar students



insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I','A-', 'completed');




insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I', null,'running');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I', null,'running');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I', null,'running');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I', null,'running');
insert into enrollment_list VALUES('2022csb1111','ma102','linear algebra', 3,'pc',2019,'I', null,'running');




-- database for marks uploaad
insert into enrollment_list values('2020csb1070','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1071','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1072','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1073','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1074','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1075','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1076','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1077','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1078','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1079','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');
insert into enrollment_list values('2020csb1080','ml101','machine learning ', 3 , 'pc', 2023, 'I', null , 'running');


///////////////////////students details /////////////////////////////
drop table student_details;
create table student_details (user_id varchar (20) primary key , email varchar (50),first_name varchar(50), last_name varchar(50),  Age int , Mobile_no int, degree varchar(10),department varchar (50),year_of_entry varchar(4), current_status varchar(50) );
insert into student_details VALUES ('2020csb1061', '2020csb1061@iitrpr.ac.in', 'Abhay' ,'Shukralia', 21, 792472427, 'Btech','Computer Science and engineering', '2020','running');




///////////////////////////////////////approve_students /////////////////////////
drop table approve_students;
create table approve_students (entry_no varchar (20), course_code  varchar (20) , approval_status varchar (50));
insert into approve_students VALUES ('2020csb1069', 'cs101', 'pending instructor approval');
insert into approve_students VALUES ('2020csb1069', 'cs102', 'pending instructor approval');

