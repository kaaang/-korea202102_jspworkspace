select top_name, count(subcategory_id) as cnt
from topcategory t left outer join subcategory s 
on t.topcategory_id = s.topcategory_id 
group by top_name 
order by t.topcategory_id asc;




select * from subcategory where topcategory_id =(
	select topcategory_id from topcategory where top_name='Down'
);




create table product(
	product_id int primary key auto_increment 
	, subcategory_id int 
	, product_name varchar(30)
	, brand varchar(25)
	, price int default 0 
	, info text
) default character set utf8;
