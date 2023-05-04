/*
 * @author
 *  Raushan pandey
 * */

package com.example.rcalc;

import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText display;
    TextView sec_display;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_add, btn_minus, btn_dev, btn_multiply, btn_back, btn_brace, btn_dot, btn_percent, btn_equal, btn_ac, btn_power;
    private int OpenBraces = 0;
    private boolean dotops = true;
//    StringBuilder expression = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Eval res;
        res = new Eval();
        display = (EditText) findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display.setGravity(Gravity.CENTER);
        display.setCursorVisible(false);
        sec_display = (TextView) findViewById(R.id.sec_display);
        btn_back = (Button) findViewById(R.id.back);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_ac = (Button) findViewById(R.id.ac);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_dev = (Button) findViewById(R.id.dev);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_percent = (Button) findViewById(R.id.btn_percentr);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_equal = (Button) findViewById(R.id.btn_eq);
        btn_multiply = (Button) findViewById(R.id.multiply);
        btn_brace = (Button) findViewById(R.id.brac1);
        btn_power = (Button) findViewById(R.id.btn_exponent);


        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = display.getText().toString().trim();
                if (text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-')
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());
                else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    display.setText(display.getText().append(new StringBuilder()).append("^").toString());
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    expression.append("0");
                display.setText(display.getText().append(new StringBuilder()).append("0").toString());

                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("1");
                display.setText(display.getText().append(new StringBuilder()).append("1").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("2");
                display.setText(display.getText().append(new StringBuilder()).append("2").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("3");
                display.setText(display.getText().append(new StringBuilder()).append("3").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("4");
                display.setText(display.getText().append(new StringBuilder()).append("4").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("5");
                display.setText(display.getText().append(new StringBuilder()).append("5").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("6");
                display.setText(display.getText().append(new StringBuilder()).append("6").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("7");
                display.setText(display.getText().append(new StringBuilder()).append("7").toString());

                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.append("8");
                display.setText(display.getText().append(new StringBuilder()).append("8").toString());
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                expression.append("9");
                display.setText(display.getText().append(new StringBuilder()).append("9").toString());
                try {
                    String expression = display.getText().toString();

                    BigDecimal result = (Eval.evaluateExpression(expression));
                    sec_display.setText(String.valueOf(result));
                } catch (Exception e) {

                    sec_display.setText("");

                }
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = display.getText().toString().trim();
                if (dotops && text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-') {
//                    expression.append("0.");
                    display.setText(display.getText().append(new StringBuilder()).append("0.").toString());
                    dotops = false;
                } else if (text.charAt(text.length() - 1) == '.' || text.charAt(text.length() - 1) == ')') {
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());

                } else if (dotops && text.length() > 0) {
//                    expression.append(".");
                    display.setText(display.getText().append(new StringBuilder()).append(".").toString());
                    dotops = false;


                }
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = display.getText().toString().trim();
                if (text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-') {
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());
                } else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
//                    expression.append("*");
                    display.setText(display.getText().append(new StringBuilder()).append("*").toString());
                    dotops = false;
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = display.getText().toString().trim();
                if (text.length() < 1) {
//                    expression.append("(0-1)*");
                    display.setText(display.getText().append(new StringBuilder()).append("(0-1)*").toString());

                } else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
//                    expression.append("-");
                    display.setText(display.getText().append(new StringBuilder()).append("-").toString());
                } else if (text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/') {

//                            expression.setCharAt(expression.length()-1,'-');
                    display.setText(display.getText().replace(display.getText().length(), display.getText().length() - 1, "-"));
                }
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = display.getText().toString().trim();
                if (text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-')
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());
                else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    display.setText(display.getText().append(new StringBuilder()).append("+").toString());
                }
            }
        });
        btn_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotops = true;

                String text = display.getText().toString().trim();
                if (text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-')
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());
                else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    display.setText(display.getText().append(new StringBuilder()).append("/").toString());
                }
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dotops=true;
                String text = display.getText().toString().trim();
                if (text.length() < 1 || text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '%'
                        || text.charAt(text.length() - 1) == '/'
                        || text.charAt(text.length() - 1) == '*'
                        || text.charAt(text.length() - 1) == '-')
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());
                else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    display.setText(display.getText().append(new StringBuilder()).append("%").toString());
//                    expression.append('%');
                    try {
                        String expression = display.getText() + "";
                        BigDecimal result = (Eval.evaluateExpression(expression));
                        sec_display.setText(String.valueOf(result));
                    } catch (Exception e) {

                        sec_display.setText("");

                    }
                }
            }
        });

        btn_brace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString().trim();

                if (str.length() < 1) {
//                    expression.append("(");
                    display.setText("(");
                    OpenBraces++;
                } else if (str.length() > 0) {
                    boolean digit = Character.isDigit(str.charAt(str.length() - 1));
                    if (OpenBraces > 0 && (digit || str.charAt(str.length() - 1) == ')')) {
//                        expression.append(")");
                        display.setText(String.format("%s)", str));
                        OpenBraces--;
                        dotops = false;
                    } else if (!digit) {
                        if (str.charAt(str.length() - 1) == ')') {
//                            expression.append("*(");
                            display.setText(String.format("%s*(", str));
                            dotops = false;
                            OpenBraces++;
                        } else {
//                        expression.append("(");
                            display.append("(");
                            OpenBraces++;
                        }
                    } else if (digit) {
                        display.setText(String.format("%s*(", str));
                        dotops = false;
                        OpenBraces++;
                    }

                }
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                expression.setLength(0);
                display.setText("");
                sec_display.setText("");
                dotops = true;
                OpenBraces = 0;
            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = display.getText().toString();
                if (text.charAt(text.length() - 1) != '(' && OpenBraces != 0 && Character.isDigit(text.charAt(text.length() - 1))) {
                    while (OpenBraces != 0) {
                        display.setText(display.getText().append(new StringBuilder()).append(')').toString());
                        OpenBraces--;
                    }
                }
                try {
                    String expression = display.getText().toString();
                    BigDecimal result = (Eval.evaluateExpression(expression));
                    display.setText(String.valueOf(result));
                    sec_display.setText("");
                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Invalid Expression", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   //Logic for Back button pressed
                String text = display.getText().toString();
                if (text.length() > 0) {           //Logic when expression in not null
                    if (text.charAt(text.length() - 1) == '.')      //if deleting character is a decimal make decimal operation true
                        dotops = true;
                    if (text.charAt(text.length() - 1) == ')')
                        OpenBraces++;
                    display.setText(text.substring(0, text.length() - 1));
                    try {
                        String expression = display.getText() + "";
                        BigDecimal result = (Eval.evaluateExpression(expression));
                        sec_display.setText(String.valueOf(result));
                    } catch (Exception e) {

                        sec_display.setText("");

                    }
                } else
                    display.setText("");
                sec_display.setText("");


            }
        });


    }
}