create table board(
	board_id int primary key auto_increment
	,title varchar(100)
	, writer varchar(20)
	, content text
	, regdate timestamp default now()
	, hit int default 0
	)default character set utf8;
	
alter table product add product_img varchar(25);


create table product(
	product_id int primary key auto_increment 
	, subcategory_id int 
	, product_name varchar(30)
	, brand varchar(25)
	, price int default 0 
	, info text
) default character set utf8;


select t.topcategory_id, s.subcategory_id ,sub_name,
			product_id, product_name, brand, price, info, product_img 
from topcategory t ,subcategory s ,product p 
where t.topcategory_id =s.subcategory_id
and  s.subcategory_id = p.subcategory_id
and product_id=2;







delete from product where product_id=4;