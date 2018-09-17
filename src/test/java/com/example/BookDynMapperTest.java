//package com.example;
//
//import com.dynamic.entity.BookDyn;
//import com.dynamic.mapper.BookDynMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//import static org.mybatis.dynamic.sql.SqlBuilder.and;
//import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
//import static org.mybatis.dynamic.sql.SqlBuilder.isLessThan;
//import static org.mybatis.dynamic.sql.SqlBuilder.isNull;
//import static com.dynamic.mapper.BookDynDynamicSqlSupport.*;
//
///**
// * @author yulewei on 2018/5/1
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BookDynMapperTest {
//
//    @Resource
//    BookDynMapper bookDynMapper;
//
//    @Test
//    public void name() {
//        List<BookDyn> allRecords = bookDynMapper.selectByExample()
//                .where(id, isEqualTo(3))
//                .and(id, isEqualTo(1))
//                .or(isbn, isNull(), and(id, isLessThan(6)))
//                .build().execute();
//        System.out.println(allRecords);
//    }
//
////    @Test
////    public void name1() {
////        List<BookDyn> allRecords = bookDynMapper.selectAll();
////        System.out.println(allRecords);
////    }
//}
