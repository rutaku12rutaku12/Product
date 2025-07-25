drop database if exists assignment9;
create database assignment9;
use assignment9;


create table products(
	pno int auto_increment , 
	constraint primary key (pno),
    puser varchar(30) not null,
    pproduct varchar(30) not null,
    pcontent longtext not null,
    pprice int not null,
    ppassword varchar(30) not null,
    pdate datetime default now() not null,
    pstatus varchar(10) default "판매중" not null
);

select * from products;
DESC products; # 초기값 확인 

# 샘플 데이터
INSERT INTO products (pno ,puser, pproduct, pcontent, pprice, ppassword ,pdate ,pstatus) VALUES 
(1,'sksksksk','정보처리 필기 기출문제','사용 안한 정보처리 필기 기출문제 팝니다.',10000,'1234','2025-07-24 14:52','판매중');
INSERT INTO products (pno,puser, pproduct, pcontent, pprice, ppassword, pdate, pstatus) VALUES 
(2,'코비진스', '나이키 에어포스', '예전에 사고 방치한 신발 싸게 팔아요.', 20000, 'q12q', '2025-07-24 15:00', '판매완료');
INSERT INTO products (pno, puser, pproduct, pcontent, pprice, ppassword, pdate, pstatus) VALUES
(3, 'honeybee', '프로그래밍 책 세트', '파이썬, 자바 책 포함 전부 팝니다.', 25000, 'abc1', '2025-07-24 15:01', '판매중'),
(4, 'mintuser', '게이밍 마우스', '거의 새 상품입니다. 사용감 없음.', 15000, 'pw22', '2025-07-24 15:02', '판매완료'),
(5, 'blue77', '캡모자', '정품 모자, 택도 그대로 있어요.', 7000, '7777', '2025-07-24 15:03', '판매중'),
(6, 'orange33', '카카오 리유저블 컵', '커피 안 마셔서 내놓습니다.', 3000, 'cof3', '2025-07-24 15:04', '판매중'),
(7, 'choco21', '스타벅스 텀블러', '선물받았는데 사용 안 함', 12000, '1111', '2025-07-24 15:05', '판매완료'),
(8, 'pinksky', '중고 노트북', 'RAM 16GB, SSD 512GB', 380000, 'not3', '2025-07-24 15:06', '판매중'),
(9, 'rabbit99', '토익 인강 자료', '정리 잘 돼 있고 깔끔해요', 10000, 'toe1', '2025-07-24 15:07', '판매중'),
(10, 'ggumdream', '한컴 타자 연습책', '초등용입니다. 상태 좋아요.', 4000, 'han1', '2025-07-24 15:08', '판매완료'),
(11, 'sunny99', '무선 키보드', '건전지 타입, 거의 새 것', 17000, 'key2', '2025-07-24 15:09', '판매중'),
(12, 'choi12', '알람 시계', '귀여운 디자인입니다.', 6000, 'alrm', '2025-07-24 15:10', '판매중'),
(13, 'lisa01', '기타피크 세트', '5개 세트로 판매합니다.', 2000, 'gita', '2025-07-24 15:11', '판매완료'),
(14, 'moon33', '데이터베이스 교재', '실기 대비에 도움돼요.', 11000, 'db12', '2025-07-24 15:12', '판매중'),
(15, 'neo22', '운동화', '거의 새 상품, 정품', 25000, 'shoo', '2025-07-24 15:13', '판매중'),
(16, 'green55', '오르골', '소리 좋고 인테리어용으로도 좋아요.', 9500, 'or22', '2025-07-24 15:14', '판매완료'),
(17, 'cloudx', '공유기', 'TP-Link 기가 인터넷용', 22000, 'net0', '2025-07-24 15:15', '판매중'),
(18, 'suzy20', '자전거 라이트', 'USB 충전식, 밝기 좋음', 8000, 'bike', '2025-07-24 15:16', '판매중'),
(19, 'apple88', '스마트폰 거치대', '차량용입니다.', 5000, 'car1', '2025-07-24 15:17', '판매완료'),
(20, 'starcat', '독서대', '튼튼하고 각도 조절 가능', 9000, 'read', '2025-07-24 15:18', '판매중');







