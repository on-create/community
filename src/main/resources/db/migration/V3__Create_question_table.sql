use community;
drop table if exists question;
create table question (
    id int auto_increment primary key,
    title varchar(50),
    description text,
    time_create datetime,
    time_modified datetime,
    creator int,
    comment_count int default 0,
    view_count int default 0,
    like_count int default 0,
    tag varchar(256)
);