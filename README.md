## SpringBoot项目实战（论坛）

## 资料
[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[es](https://elasticsearch.cn/explore)

[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)

[BootStrap](https://v3.bootcss.com/getting-started/)

[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

## 工具
[Git](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com)

[Flyway](https://flywaydb.org/documentation/) 

## 脚本
V1__Create_user_table.sql
```sql
use community;
create table user (
    id int auto_increment primary key not null,
    account_id varchar(100),
    name varchar(50),
    token varchar(36),
    time_create datetime,
    time_modified datetime                 
) character set = utf8;
```
V2__Add_bio_col_to_user_table.sql
```sql
alter table user add bio varchar(256) null;
```
```bash
mvn flyway:migrate
```