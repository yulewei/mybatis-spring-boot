package com.example.mbg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.StringUtility;

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

		// 项目的根目录
		String curProjectDir = new File(".").getCanonicalPath();
		if (!configFile.exists()) {
			curProjectDir = new File("..").getCanonicalPath();
			configFile = new File(curProjectDir + "/" + fileName);
		}

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);

		// 重写配置文件的配置信息
		for (Context context : config.getContexts()) {
			for (TableConfiguration tableConfig : context.getTableConfigurations()) {
				if (!StringUtility.stringHasValue(tableConfig.getMapperName())) {
					// 参见 org.mybatis.generator.api.IntrospectedTable#calculateJavaClientAttributes
					tableConfig.setMapperName("I" + tableConfig.getDomainObjectName() + "DAO");
				}
			}

			// 若无法通过相对路径找到目标目录，尝试使用绝对路径
			JavaModelGeneratorConfiguration javaModelGeneratorConfig = context.getJavaModelGeneratorConfiguration();
			String targetProject = javaModelGeneratorConfig.getTargetProject();
			if (!new File(targetProject).exists()) {
				javaModelGeneratorConfig.setTargetProject(curProjectDir + "/" + targetProject);
			}
			SqlMapGeneratorConfiguration sqlMapGeneratorConfig = context.getSqlMapGeneratorConfiguration();
			targetProject = sqlMapGeneratorConfig.getTargetProject();
			if (!new File(targetProject).exists()) {
				sqlMapGeneratorConfig.setTargetProject(curProjectDir + "/" + targetProject);
			}
			JavaClientGeneratorConfiguration javaClientGeneratorConfig = context.getJavaClientGeneratorConfiguration();
			targetProject = javaClientGeneratorConfig.getTargetProject();
			if (!new File(targetProject).exists()) {
				javaClientGeneratorConfig.setTargetProject(curProjectDir + "/" + targetProject);
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
