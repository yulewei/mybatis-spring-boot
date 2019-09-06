package com.example;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardTypeLocator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Main {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        StandardTypeLocator typeLocator = new StandardTypeLocator();
        typeLocator.registerImport("org.apache.commons.lang3");
        context.setTypeLocator(typeLocator);
        context.setVariable("num", 1024);
        Expression exp = parser.parseExpression("'hello '.concat('world')");
        String message = exp.getValue(context, String.class);
        System.out.println(message);

        System.out.println(parser.parseExpression("'a' == 'a'").getValue());
        System.out.println(parser.parseExpression("T(Math).PI").getValue());
        System.out.println(parser.parseExpression("T(org.apache.commons.lang3.StringUtils).isNotEmpty('a')").getValue());
        System.out.println(parser.parseExpression("T(StringUtils).isNotEmpty('a')").getValue(context));
        System.out.println(parser.parseExpression("T(math.NumberUtils).FLOAT_ONE").getValue(context));
    }

    @Test
    public void variableRegisteredOK() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("message", "Hello World!");
        String value = parser.parseExpression("#message").getValue(context, String.class);
        assertThat(value, is("Hello World!"));
    }
}
