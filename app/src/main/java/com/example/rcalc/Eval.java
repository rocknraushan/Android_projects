package com.example.rcalc;/* A Java program to evaluate a
given expression where tokens
are separated by space.
*/

import android.annotation.SuppressLint;
import android.icu.math.BigDecimal;

import java.util.Stack;

public class Eval {


    public static BigDecimal evaluateExpression(String expression) {
//            double initial = 0;
        Stack<BigDecimal> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
//            final float Percent = 0.01f;


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                String num = "";
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num += expression.charAt(i);
                    i++;
                }
                i--;

                @SuppressLint({"NewApi", "LocalSuppress"}) BigDecimal value = new BigDecimal(num);
                numbers.push(value);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    BigDecimal result = performOperation(numbers, operators);
                    numbers.push(result);
                }
                operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    BigDecimal result = performOperation(numbers, operators);
                    numbers.push(result);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            BigDecimal result = performOperation(numbers, operators);
            numbers.push(result);
        }

        return numbers.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return (op1 != '^' && op1 != '%') || (op2 != '+' && op2 != '-' && op2 != '*' && op2 != '/');
    }

    @SuppressLint("NewApi")
    public static BigDecimal performOperation(Stack<BigDecimal> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        BigDecimal a;
        BigDecimal b;
        try {
            b = numbers.pop();
        } catch (Exception e) {
            b = BigDecimal.ONE;
        }
        a = numbers.pop();


        switch (operator) {
            case '+':
                return a.add(b);
            case '-':
                return a.subtract(b);
            case '*':
                return a.multiply(b);
            case '/':
                if (b.equals(BigDecimal.ZERO))
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a.divide(b);
            case '%':
                return (a.multiply(b)).divide(new BigDecimal(100));
            case '^':
                return a.pow(b);


        }

        return BigDecimal.ZERO;
    }


    // Driver method to test above methods

}
