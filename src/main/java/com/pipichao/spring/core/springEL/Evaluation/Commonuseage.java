package com.pipichao.spring.core.springEL.Evaluation;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

public class Commonuseage {

    //The more common usage of SpEL is
    // to provide an expression string that is evaluated against a specific object instance
    // (called the root object).

    public static void main(String[] args) {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) exp.getValue(tesla);
// name == "Nikola Tesla"

        System.out.println(name);
        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        System.out.println(result);
    }
}
