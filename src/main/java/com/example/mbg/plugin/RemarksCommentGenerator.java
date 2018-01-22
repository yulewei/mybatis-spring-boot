package com.example.mbg.plugin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * MyBatis Generator的注释生成器，会附带数据库表字段的注释到实体类中 <br>
 * <p>
 * 官方类似的功能见，在版本1.3.3中添加的 addRemarkComments <br>
 * http://www.mybatis.org/generator/configreference/commentGenerator.html <br>
 * https://github.com/mybatis/generator/issues/23
 *
 * @author yulewei on 16/9/25.
 * @see DefaultCommentGenerator#addRemarkComments
 */
public class RemarksCommentGenerator extends DefaultCommentGenerator {
	private Properties properties = new Properties();
	private boolean suppressDate = false;
	private boolean suppressAllComments = false;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
		this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));
		this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
	}

	public void addComment(XmlElement xmlElement) {
		if (this.suppressAllComments) return;

		String dateStr = this.getDateString();
		StringBuilder sb = new StringBuilder();
		sb.append("<!-- ");
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (dateStr != null) {
			sb.append(" ");
			sb.append(dateStr);
		}
		sb.append(" -->");
		xmlElement.addElement(new TextElement(sb.toString()));
	}

	@Override
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		if (this.suppressAllComments) return;

		topLevelClass.addJavaDocLine("/**");

		String remarks = introspectedTable.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
			for (String remarkLine : remarkLines) {
				topLevelClass.addJavaDocLine(" * " + remarkLine);
			}
		}

		topLevelClass.addJavaDocLine(" * ");
		topLevelClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(" *");
		addJavadocTag(topLevelClass, false);
		topLevelClass.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (this.suppressAllComments) return;

		field.addJavaDocLine("/**");

		String remarks = introspectedColumn.getRemarks();
		if (StringUtility.stringHasValue(remarks)) {
			String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
			for (String remarkLine : remarkLines) {
				field.addJavaDocLine(" * " + remarkLine);
			}
		}

		field.addJavaDocLine(" *");
		field.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable() + '.' + introspectedColumn.getActualColumnName());
		field.addJavaDocLine(" *");
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (this.suppressAllComments) return;

		field.addJavaDocLine("/**");
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}

	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (this.suppressAllComments) return;

		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (this.suppressAllComments) return;

		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (this.suppressAllComments) return;

		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		String dateStr = this.getDateString();
		javaElement.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG + (dateStr == null ? "" : ' ' + dateStr));
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if (this.suppressAllComments) return;

		innerClass.addJavaDocLine("/**");
//		innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable());
		addJavadocTag(innerClass, false);
		innerClass.addJavaDocLine(" */");
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (this.suppressAllComments) return;

		innerClass.addJavaDocLine("/**");
		addJavadocTag(innerClass, markAsDoNotDelete);
		innerClass.addJavaDocLine(" */");
	}

	protected String getDateString() {
		return this.suppressDate ? null : dateFormat.format(new Date());
	}

}
