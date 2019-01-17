create schema shardingJdbc0 default character set utf8 collate utf8_general_ci;

create schema shardingJdbc1 default character set utf8 collate utf8_general_ci;

create table shardingJdbc0.person(
  id int primary key auto_increment comment 'ID',
  name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;

-- 为了生成逻辑表代码用的
create table shardingJdbc0.user(
  id int primary key auto_increment comment 'ID',
  user_id int not null comment '用户ID',
  city_id int not null comment '城市ID',
  user_name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;

drop table shardingJdbc0.user;

create table shardingJdbc0.user0(
  id int primary key auto_increment comment 'ID',
  user_id int not null comment '用户ID',
  city_id int not null comment '城市ID',
  user_name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;

create table shardingJdbc0.user1(
  id int primary key auto_increment comment 'ID',
  user_id int not null comment '用户ID',
  city_id int not null comment '城市ID',
  user_name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;

create table shardingJdbc1.user1(
  id int primary key auto_increment comment 'ID',
  user_id int not null comment '用户ID',
  city_id int not null comment '城市ID',
  user_name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;

create table shardingJdbc1.user0(
  id int primary key auto_increment comment 'ID',
  user_id int not null comment '用户ID',
  city_id int not null comment '城市ID',
  user_name varchar(30) not null comment '名字',
  age int(3) not null comment '年龄',
  sex int(1) not null default 1 comment '性别: 1 男  0 女',
  create_time timestamp not null default current_timestamp comment '创建时间',
  create_user varchar(100) null comment '创建人',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
  update_user varchar(100) null comment '更新人',
  yn int(1) not null default 1 comment '是否有效: 1 有效  0 无效'
) engine innodb default charset =utf8;
