/* 
 * ���� �Խ��� ������ ���� SQL
 * employees ���̺�� departments ���̺��� 1 : �� ���� ����
 */
DROP TABLE board;

--#1. �Խ��� ���̺� ����
CREATE TABLE board(
    board_id       NUMBER(20)           NOT NULL,    -- �Խ��� �ĺ���ȣ
    category       NUMBER(10)           NOT NULL,    -- �Խ��� ī�װ�
    title               VARCHAR2(200)     NOT NULL,  -- �Խ��� �̸�
    description  VARCHAR2(400)                       -- �Խ��� �󼼼���
);

DROP SEQUENCE board_id_seq;

CREATE SEQUENCE board_id_seq
    START WITH 1
    INCREMENT BY 10;


--#2. �Խ��� ���̺� �������� �߰�
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. �׽�Ʈ �Խ��� ���
INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '�����Խ���', '������ �����Ӱ� ���� ���� �� �ִ� �����Խ����Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 1, '�����ڷ��', '�̰� ���� ���°� ���� ���� �ڷ���Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '������ϱ�', 'IT ���� �����̵� ���� ������.');

INSERT INTO board(board_id, category, title, description)
VALUES (board_id_seq.NEXTVAL, 2, '��������', '���������Դϴ�.');

COMMIT;

-- �Խ��� ��ü ��� ��ȸ
SELECT board_id, category, title, description
FROM   board
ORDER BY board_id;


--#4. �Խñ� ���̺� ����
DROP TABLE article;

CREATE TABLE article (
    article_id    NUMBER(20)        NOT NULL,              -- �Խñ� �ĺ���ȣ
    board_id      NUMBER(20)        NOT NULL,              -- �Խñ� �Ҽ� �Խ��ǹ�ȣ
    writer        VARCHAR2(20)     NOT NULL,               -- �Խñ� �ۼ��� ���̵�
    subject       VARCHAR2(400)    NOT NULL,               -- �Խñ� ����
    content       VARCHAR2(4000)   NOT NULL,               -- �Խñ� ����
    regdate       DATE      DEFAULT  SYSDATE  NOT NULL,    -- �Խñ� �������
    hitcount      NUMBER(20)        DEFAULT 0 NOT NULL,    -- �Խñ� ��ȸ��
    passwd        VARCHAR2(8)      NOT NULL,               -- �Խñ� ��й�ȣ
    group_no      NUMBER(7)        NOT NULL,               -- ������ �Խ��� ������ ���� �Խñ� �׷��ȣ
    level_no      NUMBER(2)        NOT NULL,               -- ������ �Խ��� ������ ���� �׷쳻 �Խñ� ����
    order_no      NUMBER(3)        NOT NULL                -- ������ �Խ��� ������ ���� �׷쳻 �Խñ� ����
);

--#5. �Խñ� ���̺� �������� �߰�
ALTER TABLE article 
    ADD (
        CONSTRAINT article_id_pk PRIMARY KEY ( article_id ),
        CONSTRAINT board_id_fk FOREIGN KEY ( board_id )   REFERENCES board ( board_id ),
        CONSTRAINT writer_fk FOREIGN KEY ( writer )  REFERENCES member (id)
);
  

--#6. �Խñ� �ĺ���ȣ�� ���� ������ ����
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
VALUES('guest1', '1111', '�Խ�Ʈ1', 'guest1@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest2', '1111', '�Խ�Ʈ2', 'guest2@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest3', '1111', '�Խ�Ʈ3', 'guest3@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest4', '1111', '�Խ�Ʈ4', 'guest4@gmail.com');

INSERT INTO member(id, passwd, name, email)
VALUES('guest5', '1111', '�Խ�Ʈ5', 'guest5@gmail.com');

COMMIT;
