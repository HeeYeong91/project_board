/* 
 * 다중 게시판 구축을 위한 SQL
 * employees 테이블과 departments 테이블의 1 : 다 관계 유사
 */
DROP TABLE board;

--#1. 게시판 테이블 생성
CREATE TABLE board(
    board_id       NUMBER(20)           NOT NULL,    -- 게시판 식별번호
    category       NUMBER(10)           NOT NULL,    -- 게시판 카테고리
    title               VARCHAR2(200)     NOT NULL,  -- 게시판 이름
    description  VARCHAR2(400)                       -- 게시판 상세설명
);

DROP SEQUENCE board_id_seq;

CREATE SEQUENCE board_id_seq
    START WITH 1
    INCREMENT BY 10;


--#2. 게시판 테이블 제약조건 추가
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. 테스트 게시판 등록
INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '자유게시판', '누구나 자유롭게 글을 쓰실 수 있는 자유게시판입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '만땅자료실', '이것 저것 없는게 없는 만땅 자료실입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '묻고답하기', 'IT 관련 무엇이든 물어 보세요.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '공지사항', '공지사항입니다.');

COMMIT;

-- 게시판 전체 목록 조회
SELECT board_id, category, title, description
FROM   board
ORDER BY board_id;


--#4. 게시글 테이블 생성
DROP TABLE article;

CREATE TABLE article (
    article_id    NUMBER(20)        NOT NULL,              -- 게시글 식별번호
    board_id      NUMBER(20)        NOT NULL,              -- 게시글 소속 게시판번호
    writer        VARCHAR2(20)     NOT NULL,               -- 게시글 작성자 아이디
    subject       VARCHAR2(400)    NOT NULL,               -- 게시글 제목
    content       VARCHAR2(4000)   NOT NULL,               -- 게시글 내용
    regdate       DATE      DEFAULT  SYSDATE  NOT NULL,    -- 게시글 등록일자
    hitcount      NUMBER(20)        DEFAULT 0 NOT NULL,    -- 게시글 조회수
    passwd        VARCHAR2(8)      NOT NULL,               -- 게시글 비밀번호
    group_no      NUMBER(7)        NOT NULL,               -- 계층형 게시판 구조를 위한 게시글 그룹번호
    level_no      NUMBER(2)        NOT NULL,               -- 계층형 게시판 구조를 위한 그룹내 게시글 레벨
    order_no      NUMBER(3)        NOT NULL                -- 계층형 게시판 구조를 위한 그룹내 게시글 순서
);

--#5. 게시글 테이블 제약조건 추가
ALTER TABLE article 
    ADD (
        CONSTRAINT article_id_pk PRIMARY KEY ( article_id ),
        CONSTRAINT board_id_fk FOREIGN KEY ( board_id )   REFERENCES board ( board_id ),
        CONSTRAINT writer_fk FOREIGN KEY ( writer )  REFERENCES member (id)
);
  

--#6. 게시글 식별번호를 위한 시퀀스 생성
DROP SEQUENCE article_id_seq;

CREATE SEQUENCE article_id_seq
    START WITH   1
    INCREMENT BY 1;
    
desc member;

DROP TABLE member;

CREATE TABLE member (
    id VARCHAR2(32) NOT NULL,
    passwd VARCHAR2(16) NOT NULL,
    regdate DATE default sysdate,
    name VARCHAR2(10) NOT NULL,
    email VARCHAR2(32) NOT NULL
);

ALTER TABLE member 
    ADD (
        CONSTRAINT member_id_pk PRIMARY KEY ( id )
);

INSERT INTO member(id, passwd, name, email)
VALUES('guest1', '1111', '게스트1', 'guest1@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest2', '1111', '게스트2', 'guest2@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest3', '1111', '게스트3', 'guest3@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest4', '1111', '게스트4', 'guest4@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest5', '1111', '게스트5', 'guest5@gmail.com');

COMMIT;
