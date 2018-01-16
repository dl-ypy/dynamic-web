/*ɾ���̳����ݿ�,�������*/
drop database if exists shopping;
/*�������ݿ�,�����ñ���*/
create database shopping default character set utf8;

use shopping;
/*ɾ������Ա��*/
drop table if exists account;
/*ɾ���û���*/
drop table if exists users;
/*ɾ����Ʒ����*/
drop table if exists category;
/*ɾ����Ʒ��*/
drop table if exists goods;
/*ɾ�����ﳵ��*/
drop table if exists forder;
/*ɾ���������*/
drop table if exists sorder;
/*ɾ����־��*/
drop table if exists logs;
/*ɾ��״̬��*/
drop table if exists status;

/*============================*/
/* Table: ����Ա��ṹ 		  */
/*============================*/
create table account
(
   /* ����Ա���,�Զ����� */
   aid                  int not null auto_increment,
   /* ����Ա��¼��  */
   alogin               varchar(20),
   /* ����Ա����  */
   aname                varchar(20),
   /* ����Ա���� */
   apass                varchar(20),
   /* ���ñ��Ϊ���� */
   primary key (aid)
);

/*============================*/
/* Table: �û���ṹ 		  */
/*============================*/
create table users
(
   /* �û����,�Զ����� */
   uid                  int not null auto_increment,
   /* �û���¼�� */
   ulogin               varchar(20),
   /* �û���ʵ���� */
   uname                varchar(20),
   /* �û���¼���� */
   upass                varchar(20),
   /* �û��Ա� */
   usex                 varchar(20),
   /* �û��绰 */
   uphone               varchar(20),
   /* �û��ʱ� */
   upost                varchar(10),
   /* �û�Email */
   uemail               varchar(20),
   /* �û����ڵ�ַ */
   uaddress             varchar(20),
   /* �����û����Ϊ���� */
   primary key (uid)
);

/*=============================*/
/* Table: ��Ʒ����ṹ 		   */
/*=============================*/
create table category
(
   /* �����,�Զ����� */
   cid                  int not null auto_increment,
   /* ������� */
   ctype                varchar(20),
   /* ����Ƿ�Ϊ�ȵ����,�ȵ������п�����ʾ����ҳ */
   chot                 bool default false,
   /* ���,���������λ����Ա���� */
   aid                  int,
   /* ���������Ϊ���� */
   primary key (cid)
);

/*=============================*/
/* Table: ��Ʒ��ṹ	 		   */
/*=============================*/
create table goods
(
   /* ��Ʒ���,�Զ����� */
   gid                  int not null auto_increment,
   /* ��Ʒ���� */
   gname                varchar(20),
   /* ��Ʒ�۸� */
   gprice               decimal(8,2),
   /* ��ƷͼƬ */
   gpic                 varchar(200),
   /* ��Ʒ�򵥽��� */
   gremark              longtext,
   /* ��Ʒ��ϸ���� */
   gxremark             longtext,
   /* ��Ʒ�������� */
   gdate                timestamp default CURRENT_TIMESTAMP,
   /* �Ƿ�Ϊ�Ƽ���Ʒ,�Ƽ���Ʒ���п�����ʾ���̳���ҳ */
   gcommend             bool,
   /* �Ƿ�Ϊ��Ч��Ʒ,��Ч��Ʒ���п�����ʾ���̳���ҳ */
   gopen                bool,
   /* ��Ʒ���ڵ������*/
   cid                  int,
   /* ������Ʒ���Ϊ���� */
   primary key (gid)
);

/*=============================*/
/* Table: ������ṹ	 		   */
/*=============================*/
create table forder
(
   /* �������,�Զ����� */
   fid                  int not null auto_increment,
   /* �ռ������� */
   fname                varchar(20),
   /* �ռ��˵绰 */
   fphone               varchar(20),
   /* ������Ϣ */
   fremark              varchar(20),
   /* �ռ������� */
   femail               varchar(20),
   /* �µ����� */
   fdate                timestamp default CURRENT_TIMESTAMP,
   /* �����ܽ�� */
   ftotal               decimal(8,2),
   /* �ռ����ʱ� */
   fpost                varchar(20),
   /* ��Ա��� */
   uid                  int,
   /* ����״̬ */
   sid                  int,
   /* ���ö������Ϊ���� */
   primary key (fid)
);
/* �޸��Զ������ĳ�ʼֵ */
ALTER TABLE forder AUTO_INCREMENT = 2013021801;

/*=============================*/
/* Table: �������ṹ 		   */
/*=============================*/
create table sorder
(
   /* ��������,�Զ����� */
   sid                  int not null auto_increment,
   /* ��������Ʒ������ */
   sname                varchar(20),
   /* ����ʱ��Ʒ�ļ۸� */
   sprice               decimal(8,2),
   /* ��������� */
   snumber              int not null,
   /* ������Ʒ��� */
   gid                  int,
   /* �˶�����,�����Ķ������ */
   fid                  int,
   /* ���ù�������Ϊ���� */
   primary key (sid)
);

/*=============================*/
/* Table: ��־��ṹ	 		   */
/*=============================*/
create table logs
(
   /* ��־���,�Զ����� */
   lid                  int not null auto_increment,
   /* ����·�� */
   lpath                varchar(200),
   /* ������� */
   lparam               varchar(500),
   /* �����ʱ�� */
   ldate                timestamp default CURRENT_TIMESTAMP,
   /* ������û�����,�洢�û���� */
   uid                  int,
   /* ����ǹ���Ա����,�洢����Ա��� */
   aid                  int,
   /* ������־���Ϊ���� */
   primary key (lid)
);


/*=============================*/
/* Table: ����״̬��ṹ 		   */
/*=============================*/
create table status
(
   /* ״̬���,�Զ����� */
   sid                  int not null auto_increment,
   /* ����״̬ */
   status               varchar(10),
   /* ���ö������Ϊ���� */
   primary key (sid)
);

/* ���������Լ��,��ʵ������,ͨ������������Լ���������ݿ����Լ�� */
/*
alter table sorder add constraint foreign key (gid)
      references goods (gid) on delete SET NULL on update SET NULL;

alter table sorder add constraint foreign key (fid)
      references forder (fid) on delete SET NULL on update SET NULL;

alter table category add constraint foreign key (aid)
      references account (aid) on delete SET NULL  on update SET NULL;

alter table forder add constraint foreign key (sid)
      references status (sid) on delete SET NULL on update SET NULL;

alter table forder add constraint foreign key (uid)
      references users (uid) on delete SET NULL on update SET NULL;

alter table goods add constraint foreign key (cid)
      references category (cid) on delete set null on update set null;

alter table logs add constraint foreign key (aid)
      references account (aid) on delete SET NULL on update SET NULL;

alter table logs add constraint foreign key (uid)
      references users (uid) on delete SET NULL on update SET NULL;
*/

/* ����Ա��������*/
INSERT INTO account (alogin,aname,apass) VALUES ('admin','С��','admin');

/* �û��������� */
INSERT INTO users (ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)
VALUES ('user','С��','user','��','13812345678','423456','10000@qq.com','�й����㵺');

INSERT INTO users (ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)
VALUES ('user2','С��','user2','Ů','13812345679','888888','20000@qq.com','�й�����');

/* ���������� */
INSERT INTO category (ctype,chot,aid) VALUES ('��ʿ����',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('Ůʿ����',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('������Ʒ',true,1);

INSERT INTO category (ctype,chot,aid) VALUES ('���ðٻ�',true,1);

/* ��Ʒ�������� */
INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('ʥ������',0.1,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('��������',1999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('��������',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('����������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('����Ůװ',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('ѩ��ѥ',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('ŷ��Ůװ',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('Ů������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('���ܵ�����',3998.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('��ʿ������',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('����Ӳ��',599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('��ˮţ����',399.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('������',150.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('�ϰ���',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('�յ�',3599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO goods (gname,gprice,gpic,gremark,gxremark,gcommend,gopen,cid) VALUES 
('����',0.1,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

/* status�������� */

INSERT INTO status (status) VALUES ('δ֧��');
INSERT INTO status (status) VALUES ('��֧��');
INSERT INTO status (status) VALUES ('��������');
INSERT INTO status (status) VALUES ('�ϵ�');

/* Forder�������� */
INSERT INTO forder (fname,fphone,fremark,femail,ftotal,fpost,uid) 
VALUES ('С��','12345678','���ղ�Ҫ����','10000@qq.com',0.3,'432345',1);

/* sorder ��������  */
INSERT INTO sorder (sname,sprice,snumber,gid,fid) VALUES ('ʥ������',0.1,1,1,2013021801);
INSERT INTO sorder (sname,sprice,snumber,gid,fid) VALUES ('����',0.1,2,16,2013021801);

SELECT * FROM account;
SELECT * FROM users;
SELECT * FROM category;
SELECT * FROM goods;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;