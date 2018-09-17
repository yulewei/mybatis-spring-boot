package com.example;

import cn.idongjia.entity.CraftsmanSnapshot;
import cn.idongjia.entity.criteria.CraftsmanSnapshotExample;
import cn.idongjia.mapper.CraftsmanSnapshotMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.util.HttpUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yulewei on 2018/7/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CraftsmanSnapshotTest {

    private static final Logger logger = LoggerFactory.getLogger(CraftsmanSnapshotTest.class);

    //    public static String fileUploadUrlDev = "http://file-develop.kaipao.cc/";
    public static String fileUploadUrl = "http://file.kaipao.cc/";
    @Resource
    private CraftsmanSnapshotMapper craftsmanSnapshotMapper;

    @Test
    public void downLoad() throws IOException {
        long total = craftsmanSnapshotMapper.countByExample(new CraftsmanSnapshotExample());
        int pageSize = 1000;
        long pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        for (int page = 1; page <= pages; page++) {
            List<String> contentList = new ArrayList<>();
            PageHelper.startPage(page, pageSize, false);
            List<CraftsmanSnapshot> snapshotList = craftsmanSnapshotMapper.selectByExample(new CraftsmanSnapshotExample());
            for (CraftsmanSnapshot snapshot : snapshotList) {
                String json = null;
                try {
                    json = HttpUtils.get(fileUploadUrl + snapshot.getUrl());
                    logger.info(json);
                } catch (Exception e) {
                    logger.error("HttpUtils.get 失败");
                }
                contentList.add(json);
            }
            FileUtils.writeLines(new File("data.json"), contentList, true);
        }
    }

    @Test
    public void data() throws IOException {
        List<String> contentList = FileUtils.readLines(new File("data.json"));
        for (String jsonStr : contentList) {
            JSONObject jsonObject = null;
            try {
                jsonObject = JSON.parseObject(jsonStr);
            } catch (Exception e) {
            }
            if (jsonObject != null && jsonObject.keySet().size() == 3) {
                System.out.println(jsonStr);
            }
        }
    }
}
