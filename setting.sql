commit

create table Classic
(
	Title varchar2(30) ,
	numberSold number(10) ,
	price number (10)
)

"비엘티" , "미트볼" , "이탈리안 비엠티" , "에그마요" , "참치" , "햄"

insert into Classic values ('비엘티' , 0 , 3900);
insert into Classic values ('미드볼' , 0, 3900);
insert into Classic values ('이탈리안 비엠티' , 0, 3900);
insert into Classic values ('에그마요' , 0, 3900);
insert into Classic values ('참치' , 0, 3900);
insert into Classic values ('햄' , 0, 3900);

create table FandL
(
	Title varchar2(30) ,
	numberSold number(10) ,
	price number (10)
)

"로스트 치킨" , "써브웨이 클럽" , "터키" , " 로스트 비프" , "베지" , "로티세리 치킨"

insert into FandL values ('로스트 치킨' , 0 ,4400);
insert into FandL values ('써브웨이 클럽' , 0,4400);
insert into FandL values ('터키' , 0,4400);
insert into FandL values ('로스트 비프' , 0,4400);
insert into FandL values ('베지' , 0,4400);
insert into FandL values ('로티세리 치킨' , 0,4400);

create table premium
(
	Title varchar2(30) ,
	numberSold number(10) ,
	price number (10)
)

"치킨 데리야끼" , "스파이시 이탈리안" , "터키 베이컨" , "써브웨이 멜트" , "치킨 베이컨 랜치" , "폴드포크"

insert into premium values ('치킨 데리야끼' , 0 , 5400);
insert into premium values ('스파이시 이탈리안' , 0, 5400);
insert into premium values ('터키 베이컨' , 0, 5400);
insert into premium values ('써브웨이 멜트' , 0, 5400);
insert into premium values ('치킨 베이컨 렌치' , 0, 5400);
insert into premium values ('폴드포크' , 0, 5400);

create table setMenu
(
	Title varchar2(30) ,
	numberSold number(10) ,
	price number (10)
)

insert into setMenu values ('세트 주문' , 0 , 1900)

create table cookie
(
	name varchar2(30) ,
	numberSold number(10)
)

"더블 초코칩 쿠키" , "초코칩 쿠키" , "오트밀레이즌" , "라즈베리 치즈케잌" , "화이트 초코 마카다미아"

insert into cookie values ('더블 초코칩 쿠키' , 0);
insert into cookie values ('초코칩 쿠키' , 0);
insert into cookie values ('오트밀레이즌' , 0);
insert into cookie values ('라즈베리 치즈케잌' , 0);
insert into cookie values ('화이트 초코 마카다미아' , 0);

create table bread
(
	name varchar2(30) ,
	numberSold number(10)
)

"허니 오트" , "하티" , "위트" , "파마산 오레가노" , "플랫브래드" , "화이트"

insert into bread values ('허니 오트' , 0);
insert into bread values ('하티' , 0);
insert into bread values ('위트' , 0);
insert into bread values ('파마산 오레가노' , 0);
insert into bread values ('플랫브래드' , 0);
insert into bread values ('화이트' , 0);

create table topping
(
	title varchar2(30) ,
	numberSold number(10) ,
	price number (10)
)

"에그마요" , "오믈렛" , "아보카도" , "베이컨"  

insert into topping values ('에그마요' , 3 , 1500);
insert into topping values ('오믈렛' , 0 , 1100);
insert into topping values ('아보카도' , 2 , 1100);
insert into topping values ('베이컨' , 0 , 900);

commit