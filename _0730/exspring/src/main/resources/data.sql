-- 회원정보(member) 저장을 위한 테이블 생성
-- 회원아이디 mem_id 문자열(최대 50바이트)
-- 회원비밀번호 mem_pass 문자열(최대 50바이트)
-- 회원이름 mem_name 문자열(최대 50바이트)
-- 회원포인트 mem_point 숫자(최대10자리정수)

create table member (
mem_id VARCHAR2(50),
mem_pass VARCHAR2(50),
mem_name VARCHAR2(50),
mem_point NUMBER(10,0),
PRIMARY KEY (mem_id)
);


INSERT INTO member
(mem_id, mem_pass, mem_name, mem_point)
values
('a001','1234','고길동', 100);

commit; --다른 사람도 볼 수 있게끔

select * from member;

update member set mem_point = 333 where mem_id='a001'; 

delete from member where mem_id='a003';

select mem_id, mem_pass, mem_name, mem_point from member;

--학생 테이블
create table student (
stu_no VARCHAR2(50), --학번(사칙연산을 하지않는 폰번호 학번과 같은 경우 문자취급)
stu_name VARCHAR2(50), --이름
stu_score NUMBER(10,0), --성적
PRIMARY KEY (stu_no)
);

select * from student;




---------------------------------------------------------------------------

--게시판 첨부파일 테이블 (끌어서 alt+x)
CREATE TABLE attach(
att_no NUMBER(10,0) PRIMARY KEY,	--첨부파일번호
att_org_name VARCHAR2(255),	--첨부파일의 원래 파일명
att_new_name VARCHAR2(255),	--서버에 저장한 파일명
att_bbs_no NUMBER(10,0),	--첨부파일이 속한 게시글의 글번호
FOREIGN KEY (att_bbs_no) REFERENCES bbs (bbs_no)
);

select * from attach;

CREATE SEQUENCE seq_att_no; --첨부파일번호 생성을 위한 시퀀스

select seq_att_no.nextval from dual;


SELECT bbs_no, bbs_title, bbs_content,bbs_writer, bbs_reg_date, bbs_count,
att_no,att_org_name, att_new_name, att_bbs_no
FROM bbs left outer join attach on bbs_no = att_bbs_no	--inner join 으로 할 경우 첨부파일이 없는 게시글은 뜨지 않음 
WHERE bbs_no =66;


----------------------------------------------------------------------------------------
--포인트 내림차순으로 정렬하여 2번째부터 4번째까지만 조회
SELECT *
FROM (SELECT ROW_NUMBER() OVER(ORDER BY mem_point desc)as RN, mem_id, mem_pass, mem_name, mem_point from member)
WHERE RN>=2 AND RN<=4;


SELECT mem_id, mem_pass, mem_name, mem_point, rnum
FROM (SELECT mem_id, mem_pass, mem_name, mem_point, rownum rnum
		from (SELECT mem_id, mem_pass, mem_name, mem_point
				from member
				order by mem_point desc)
	  WHERE rownum <=4)
WHERE rnum>=2;


----------------------------------------------------------------------------------------
--게시판 댓글 테이블
CREATE TABLE reply(
rep_no NUMBER(10,0) PRIMARY KEY, --댓글번호
rep_content CLOB, --댓글내용
rep_writer VARCHAR2(50), --댓글작성자아이디
rep_date DATE DEFAULT SYSDATE, --댓글작성일
rep_bbs_no NUMBER(10,0), --댓글이속한게시글번호
FOREIGN KEY (rep_writer) REFERENCES member(mem_id),
FOREIGN KEY (rep_bbs_no) REFERENCES bbs(bbs_no)
);

select * from reply;

CREATE SEQUENCE seq_rep_no; --댓글번호 생성을 위한 시퀀스
select seq_rep_no.nextval from dual;
