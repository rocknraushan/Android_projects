package com.example.rcalc;/* A Java program to evaluate a
given expression where tokens
are separated by space.
*/

import android.annotation.SuppressLint;

import java.util.Stack;

public class Eval {


    public static Double evaluateExpression(String expression) {
//            double initial = 0;

//            final float Percent = 0.01f;
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                String num = "";
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num += expression.charAt(i);
                    i++;
                }
                i--;

                Double value = Double.valueOf(num);
                numbers.push(value);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    Double result = performOperation(numbers, operators);
                    numbers.push(result);
                }
                operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    Double result = performOperation(numbers, operators);
                    numbers.push(result);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            Double result = performOperation(numbers, operators);
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
    public static Double performOperation(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        Double a;
        Double b;

        b = numbers.pop();

        a = numbers.pop();


        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                } else {
                    return a / b;
                }

            case '^':
                return Math.pow(a, b);


        }

        return 0.0;
    }


    // Driver method to test above methods

}
