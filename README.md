MyBatis 与 Spring Boot 结合的 demo 代码，使用 MySQL 数据库

---

**1. 初始化项目脚手架：**

安装 Spring Boot CLI：

```
$ brew tap pivotal/tap
$ brew install springboot
```

创建项目脚手架：

```
$ spring init -dweb,mybatis,mysql  mybatis-spring-boot
```

**2. 数据库设置：**

假设存在 `jdbc:mysql://localhost:3306/testdb`，并且账号 `root`，密码 `123456`

对应 `application.properties` 中的：

```
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

数据库表设计，参见 [schema.sql](https://github.com/yulewei/mybatis-spring-boot-demo/blob/master/src/main/resources/initsql/schema.sql) 和 [data.sql](https://github.com/yulewei/mybatis-spring-boot-demo/blob/master/src/main/resources/initsql/data.sql)

Spring Boot 启动时，会自动运行这两个 SQL 文件，对应 `application.properties` 中的：

```
spring.datasource.schema=classpath:initsql/schema.sql
spring.datasource.data=classpath:initsql/data.sql
```


**3. 添加代码：**

... 略

**4. 运行项目：**

```
$ mvn spring-boot:run
```

---

该示例项目中使用了 [MyBatis Generator](http://www.mybatis.org/generator/)（MBG），并使用自定义的插件 `BaseMapperPlugin` 和 `LombokPlugin`，并且用 `RemarksCommentGenerator` 优化了注释生成器的逻辑


对 MBG **定制使用**的相关介绍参见本人的博客：<http://nullwy.me/2016/12/mybatis-generator/>