-- 1.捋清楚表与表之间的关系；
-- 2.将每张表封装为实体类


prompt PL/SQL Developer import file
prompt Created on 2019年1月21日 by Administrator
set feedback off
set define off
prompt Creating ITEMS...
create table ITEMS
(
  id         INTEGER not null,
  name       VARCHAR2(20),
  price      NUMBER,
  pic        VARCHAR2(50),
  createtime DATE,
  detail     VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ITEMS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_USER...
create table T_USER
(
  id       NUMBER not null,
  username VARCHAR2(20),
  birthday DATE,
  address  VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_USER
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating ORDERS...
create table ORDERS
(
  id         INTEGER not null,
  userid     INTEGER,
  orderid    VARCHAR2(20),
  createtime DATE,
  note       VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ORDERS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ORDERS
  add foreign key (USERID)
  references T_USER (ID);

prompt Creating ORDERDETAIL...
create table ORDERDETAIL
(
  id       INTEGER not null,
  ordersid INTEGER,
  itemsid  INTEGER,
  itemsnum INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ORDERDETAIL
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ORDERDETAIL
  add foreign key (ORDERSID)
  references ORDERS (ID);
alter table ORDERDETAIL
  add foreign key (ITEMSID)
  references ITEMS (ID);

prompt Disabling triggers for ITEMS...
alter table ITEMS disable all triggers;
prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Disabling triggers for ORDERS...
alter table ORDERS disable all triggers;
prompt Disabling triggers for ORDERDETAIL...
alter table ORDERDETAIL disable all triggers;
prompt Disabling foreign key constraints for ORDERS...
alter table ORDERS disable constraint SYS_C0011537;
prompt Disabling foreign key constraints for ORDERDETAIL...
alter table ORDERDETAIL disable constraint SYS_C0011540;
alter table ORDERDETAIL disable constraint SYS_C0011541;
prompt Loading ITEMS...
insert into ITEMS (id, name, price, pic, createtime, detail)
values (1, '联想笔记本电脑', 4000.3, 'ddd', to_date('22-08-2016 18:35:38', 'dd-mm-yyyy hh24:mi:ss'), '笔记本基本信息');
insert into ITEMS (id, name, price, pic, createtime, detail)
values (2, '华为荣耀', 1500.3, 'ddd', to_date('22-08-2016 18:35:38', 'dd-mm-yyyy hh24:mi:ss'), '手机基本信息');
insert into ITEMS (id, name, price, pic, createtime, detail)
values (3, 'java从入门到精通', 23.3, 'ddd', to_date('22-08-2016 18:35:38', 'dd-mm-yyyy hh24:mi:ss'), 'JAVA基本信息');
commit;
prompt 3 records loaded
prompt Loading T_USER...
insert into T_USER (id, username, birthday, address)
values (2, '安茂', to_date('22-08-2014', 'dd-mm-yyyy'), '广州天河');
insert into T_USER (id, username, birthday, address)
values (22, '强哥', to_date('22-08-2015', 'dd-mm-yyyy'), '广州萝岗');
commit;
prompt 2 records loaded
prompt Loading ORDERS...
insert into ORDERS (id, userid, orderid, createtime, note)
values (1, 2, '1101', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'computer');
insert into ORDERS (id, userid, orderid, createtime, note)
values (2, 2, '1102', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'aaaaaaaa');
insert into ORDERS (id, userid, orderid, createtime, note)
values (3, 22, '1103', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (4, 22, '1104', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (5, 22, '1105', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (6, 22, '1106', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (7, 22, '1107', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (8, 2, '1108', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (9, 2, '1109', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (10, 2, '1110', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
insert into ORDERS (id, userid, orderid, createtime, note)
values (11, 2, '1111', to_date('22-08-2016 18:37:45', 'dd-mm-yyyy hh24:mi:ss'), 'ccccccc');
commit;
prompt 11 records loaded
prompt Loading ORDERDETAIL...
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (1, 1, 2, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (2, 1, 1, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (3, 2, 3, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (4, 3, 2, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (5, 4, 1, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (6, 5, 3, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (7, 6, 2, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (8, 7, 1, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (9, 8, 3, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (10, 9, 2, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (11, 10, 1, 10);
insert into ORDERDETAIL (id, ordersid, itemsid, itemsnum)
values (12, 11, 3, 10);
commit;
prompt 12 records loaded
prompt Enabling foreign key constraints for ORDERS...
alter table ORDERS enable constraint SYS_C0011537;
prompt Enabling foreign key constraints for ORDERDETAIL...
alter table ORDERDETAIL enable constraint SYS_C0011540;
alter table ORDERDETAIL enable constraint SYS_C0011541;
prompt Enabling triggers for ITEMS...
alter table ITEMS enable all triggers;
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;
prompt Enabling triggers for ORDERS...
alter table ORDERS enable all triggers;
prompt Enabling triggers for ORDERDETAIL...
alter table ORDERDETAIL enable all triggers;
set feedback on
set define on
prompt Done.
