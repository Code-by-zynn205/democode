create database KTKy2Java


create table Employee(
    id char(5) primary key,
	fullname nvarchar(30) not null,
	birthday datetime not null, 
	phone int not null,
	email nvarchar(30) not null,
	
);

insert into Employee(id, fullname, birthday, phone, email) values
('12345', 'Tran Kim Quyen', '6/8/2005', '0396765499', 'quyentk23ite@vku.udn.vn'),
('23456', 'Nguyen Quang Hung', '1/9/2004', '0453465652', 'hungnq23ite@gmail.com '),
('34567', 'Le Thi Bich Tram', '2/10/2003', '0336252869', 'tram2423@gmail.com')


select * from Employee
