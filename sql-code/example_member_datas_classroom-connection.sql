update member
set mem_nickname = 'nick02'
where mem_code = 2;

commit;

drop sequence member_seq;

create sequence member_seq;

delete member;

insert into member
values(member_seq.nextval, 'id0001', '홍길일', 'nick01', 'abcd1234', '서울시 강동구', 'gildong1@gmail.com',
'010-1234-5670', '900620', sysdate, 'F');

insert into member
values(member_seq.nextval, 'id0002', '홍길이', 'nick02', 'abcd1234', '서울시 강남구', 'gildong2@gmail.com',
'010-1234-5671', '900621', sysdate, 'F');

insert into member
values(member_seq.nextval, 'id0003', '홍길삼', 'nick03', 'abcd1234', '서울시 구로구', 'gildong3@gmail.com',
'010-1234-5679', '940623', sysdate, 'M');

insert into member
values(member_seq.nextval, 'id0004', '홍길사', 'nick04', 'abcd1234', '서울시 강서구', 'gildong4@gmail.com',
'010-1234-5680', '950623', sysdate, 'F');
commit;