DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id int(11) NOT NULL AUTO_INCREMENT,
  isbn varchar(13) NOT NULL COMMENT 'isbn',
  title varchar(255) NOT NULL COMMENT '书名',
  author varchar(255) NOT NULL COMMENT '作者',
  price varchar(10) NOT NULL COMMENT '定价',
  publish_date date DEFAULT NULL COMMENT '出版时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 COMMENT='书籍表';
