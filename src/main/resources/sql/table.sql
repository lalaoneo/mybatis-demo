create schema mybatis_demo default character set utf8 collate utf8_general_ci;

create table person(
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