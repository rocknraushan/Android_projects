/*
 * @author
 *  Raushan pandey
 * */

package com.example.rcalc;

import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    StringBuilder expression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Eval res;
        res = new Eval();
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display.setGravity(Gravity.CENTER);
        display.setCursorVisible(false);
        sec_display = findViewById(R.id.sec_display);
        btn_back = findViewById(R.id.back);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_ac = findViewById(R.id.ac);
        btn_add = findViewById(R.id.btn_add);
        btn_dev = findViewById(R.id.dev);
        btn_dot = findViewById(R.id.btn_dot);
        btn_percent = findViewById(R.id.btn_percentr);
        btn_minus = findViewById(R.id.btn_minus);
        btn_equal = findViewById(R.id.btn_eq);
        btn_multiply = findViewById(R.id.multiply);
        btn_brace = findViewById(R.id.brac1);
        btn_power = findViewById(R.id.btn_exponent);


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
                    expression.append("^");
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("0");
                display.setText(display.getText().append(new StringBuilder()).append("0").toString());


                GetResult();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("1");
                display.setText(display.getText().append(new StringBuilder()).append("1").toString());

                GetResult();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("2");
                display.setText(display.getText().append(new StringBuilder()).append("2").toString());
                GetResult();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("3");
                display.setText(display.getText().append(new StringBuilder()).append("3").toString());
                GetResult();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("4");
                display.setText(display.getText().append(new StringBuilder()).append("4").toString());
                GetResult();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("5");
                display.setText(display.getText().append(new StringBuilder()).append("5").toString());
                GetResult();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("6");
                display.setText(display.getText().append(new StringBuilder()).append("6").toString());
                GetResult();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("7");
                display.setText(display.getText().append(new StringBuilder()).append("7").toString());

                GetResult();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("8");
                display.setText(display.getText().append(new StringBuilder()).append("8").toString());
                GetResult();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expression.append("9");
                display.setText(display.getText().append(new StringBuilder()).append("9").toString());
                GetResult();
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
                    expression.append("0.");
                    display.setText(display.getText().append(new StringBuilder()).append("0.").toString());
                    dotops = false;
                } else if (text.charAt(text.length() - 1) == '.' || text.charAt(text.length() - 1) == ')') {
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());

                } else if (dotops && text.length() > 0) {
                    expression.append(".");
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
                    expression.append("*");
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
                    expression.append("(0-1*");
                    display.setText(display.getText().append(new StringBuilder()).append("(-").toString());
                    OpenBraces++;

                } else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    expression.append("-");
                    display.setText(display.getText().append(new StringBuilder()).append("-").toString());
                } else if (text.charAt(text.length() - 1) == '+'
                        || text.charAt(text.length() - 1) == '^'
                        || text.charAt(text.length() - 1) == '/') {
                    expression.append("(0-1*");
                    display.setText(display.getText().append(new StringBuilder()).append("(-").toString());
                    OpenBraces++;
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
                        || text.charAt(text.length() - 1) == '-') {
                    display.setText(display.getText().append(new StringBuilder()).append("").toString());

                } else if (Character.isDigit(text.charAt(text.length() - 1)) || text.charAt(text.length() - 1) == ')') {
                    dotops = true;
                    display.setText(display.getText().append(new StringBuilder()).append("+").toString());
                    expression.append("+");
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
                    display.setText(display.getText().append(new StringBuilder()).append("÷").toString());
                    expression.append("/");
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
                    expression.append('%');

                }
            }
        });

        btn_brace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = display.getText().toString().trim();

                if (str.length() < 1) {
                    expression.append("(");
                    display.setText("(");
                    OpenBraces++;
                } else if (str.length() > 0) {
                    boolean digit = Character.isDigit(str.charAt(str.length() - 1));
                    if (OpenBraces > 0) {
                        if (digit || str.charAt(str.length() - 1) == ')') {
                            expression.append(")");
                            display.setText(String.format("%s)", str));
                            OpenBraces--;
                            dotops = false;
                        }
                    } else if (!digit) {
                        if (str.charAt(str.length() - 1) == ')') {
                            expression.append("*(");
                            display.setText(String.format("%s(", str));
                            dotops = false;
                            OpenBraces++;
                        } else {
                            expression.append("(");
                            display.append("(");
                            OpenBraces++;
                        }
                    } else if (digit) {
                        display.append("*(");
                        display.setText(String.format("%s(", str));
                        dotops = false;
                        OpenBraces++;
                    }

                }
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setLength(0);
                display.setText("");
                sec_display.setText("");
                dotops = true;
                OpenBraces = 0;
            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = expression.toString();
                if (text.charAt(text.length() - 1) != '(' && OpenBraces != 0 && (Character.isDigit(text.charAt(text.length() - 1)) || Character.isLetter(')'))) {
                    while (OpenBraces != 0) {
//                        display.setText(display.getText().append(new StringBuilder()).append(')').toString());
                        expression.append(")");
                        OpenBraces--;
                    }
                }
                try {

                    BigDecimal result = (Eval.evaluateExpression(expression.toString()));
                    display.setText(String.valueOf(result));
                    sec_display.setText("");
                    expression = new StringBuilder(result.toString());
                    Log.d("value", expression.toString());
                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Invalid Expression", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                  //Logic for Back button pressed

                String minus = "";
//                String minuscheck=null;
                if (expression.length() >= 5) {
                    minus = expression.substring(expression.length() - 5, expression.length());
                }
                Log.d("minuscheck", minus);
                String text = display.getText().toString();
                if (text.length() > 0) {           //Logic when expression in not null
                    if (text.charAt(text.length() - 1) == '.')      //if deleting character is a decimal make decimal operation true
                        dotops = true;
                    if (text.charAt(text.length() - 1) == ')')
                        OpenBraces++;

                    if (minus.equals("(0-1*")) {
                        expression.delete(expression.length() - 5, expression.length());
                        display.setText(text.substring(0, text.length() - 2));
                        Log.d("Touched it", expression.toString());
                        OpenBraces--;                                                                   //As (- get deleted whole at once !
                    } else {
                        display.setText(text.substring(0, text.length() - 1));
                        expression.deleteCharAt(expression.length() - 1);
                        Log.d("expression", expression.toString());
                        Log.d("minus2", minus);
                    }
                    try {
                        BigDecimal result = (Eval.evaluateExpression(expression.toString()));
                        sec_display.setText(String.valueOf(result));
                    } catch (Exception e) {

                        sec_display.setText("");

                    }
                } else {
                    display.setText("");
                    sec_display.setText("");
                    expression.setLength(0);
                }

            }
        });


    }

    private void GetResult() {
        Log.d("expression=", expression.toString());
        try {
            BigDecimal result = (Eval.evaluateExpression(expression.toString()));
            sec_display.setText(String.valueOf(result));
        } catch (Exception e) {

            sec_display.setText("");

        }
    }
}