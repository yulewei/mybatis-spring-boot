MyBatis 与 Spring Boot 结合的 demo 代码，使用 MySQL 数据库

---

安装 Spring Boot CLI：

```
$ brew tap pivotal/tap
$ brew install springboot
```

初始化项目脚手架：

```
$ spring init -dweb,mybatis,mysql  mybatis-spring-boot
```

添加代码：
... 略

运行项目：

```
$ mvn spring-boot:run
```

---

该示例项目中使用了 [MyBatis Generator](http://www.mybatis.org/generator/)（MBG），并使用自定义的插件 `BaseMapperPlugin` 和 `LombokPlugin`，并且用 `RemarksCommentGenerator` 优化了注释生成器的逻辑


对 MBG **定制使用**的相关介绍参见本人的博客：<http://nullwy.me/2016/12/mybatis-generator/>