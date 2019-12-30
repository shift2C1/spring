package com.pipichao.spring.core.springEL.Evaluation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Dem1 {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
//        Expression exp =expressionParser.parseExpression("'Hello World'");
//        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
//        String message=(String)exp .getValue();
//        System.out.println(message);
//        Expression exp = parser.parseExpression("'Hello World'.bytes");
//        byte[] bytes = (byte[]) exp.getValue();
//        for (byte b:bytes
//             ) {
//            System.out.println(b);
//        }
//        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
//        int length = (Integer) exp.getValue();
//        System.out.println(length);

        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);

    }
}
