# multi-database-demo

### 目的

springboot架构下操作多数据库 。


### 准备

1. 创建两数据库，名称分别为test1,test2
2. 执行docs/sql文件夹下对应两个SQL

### 使用

#### 步骤：

1. 修改配置文件中有关数据库的用户名和密码-默认账号密码是root/root
2. 启动工程
3. 访问地址
 - localhost:8080/user/getListdbone，查询数据库test1中user表数据
 - 返回结果
 ```json
 [
     {
         "id": 2,
         "username": "李四",
         "gender": "女"
     }
 ]
  ```
 - localhost:8080/user/getListdbtwo，查询数据库test2中user表数据
 - 返回结果
 ```json
[
    {
        "id": 1,
        "username": "张三",
        "gender": "男"
    }
]
  ```
