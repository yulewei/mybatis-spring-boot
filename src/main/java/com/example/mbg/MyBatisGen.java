package com.example.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 Java 运行 MyBatis Generator
 * http://www.mybatis.org/generator/running/runningWithJava.html
 *
 * @author yulewei on 2017/9/24
 */
public class MyBatisGen {

    /**
     * 生成器的配置文件自行指定，从命令行参数传入
     */
    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/mybatis-generator-config.xml";
        if (args.length > 0) {
            // 从命令行参数传入，配置文件名
            fileName = args[0];
        }

        File configFile = new File(fileName);

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);

        // 重写配置文件的配置信息
        for (Context context : config.getContexts()) {
            for (TableConfiguration tableConfig : context.getTableConfigurations()) {
                // 不生成 xxxByExample 代码
//                tableConfig.setSelectByExampleStatementEnabled(false);
//                tableConfig.setCountByExampleStatementEnabled(false);
//                tableConfig.setUpdateByExampleStatementEnabled(false);
//                tableConfig.setDeleteByExampleStatementEnabled(false);
            }
        }

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String waring : warnings) {
            System.out.println(waring);
        }
    }
}
