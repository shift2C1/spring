package com.pipichao.spring.core.springEL.Evaluation;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class CompilerConfiguration {
    public static void main(String[] args) {


        new CompilerConfiguration().hhh();
    }

    public void hhh(){

        /**
         * OFF,
         *     IMMEDIATE,
         *     MIXED;
         *
         * */

        SpelParserConfiguration config=new SpelParserConfiguration(SpelCompilerMode.OFF,this.getClass().getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(config);
        Expression expr = parser.parseExpression("payload");

        MyMessage message = new MyMessage("1001","333");

        Object payload = expr.getValue(message);
        System.out.println(payload);
    }
}
