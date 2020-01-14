package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    boolean operation_pressed = false,op_done = true,equal_pressed=false;
    private double Value1 = 0, Value2 = 0;
    private char current_op;

    void set_num(TextView calculator_screen, String x){
        if(!op_done)
            calculator_screen.append(x);
        else {
            calculator_screen.setText(x);
            op_done = false;
        }
        operation_pressed=false;
    }

    void set_action(Model model1, TextView calculator_screen, String content, char act) {
        if(Error(content,calculator_screen))
            return;

        Value1 = Double.parseDouble(content);

//        if(!equal_pressed)
//        equal_op(calculator_screen,model1,content);


        operation_pressed = true;
        op_done = true;
        current_op = act;


        equal_pressed=false;
    }

    boolean Error(String content,TextView calculator_screen) {
        if(content.isEmpty()) {
            calculator_screen.setText("0");
            return true;
        }
        return false;
    }

        void equal_op(TextView calculator_screen, Model model1, String content){
            Value2 = Double.parseDouble(content);
            op_done = true;
            switch (current_op) {
                case '+':

                    calculator_screen.setText(String.valueOf(model1.add(Value1,Value2)));
                    break;
                case '-':
                    if (!equal_pressed)
                        calculator_screen.setText(String.valueOf(model1.sub(Value1,Value2)));
                    else
                        calculator_screen.setText(String.valueOf(model1.sub(Value2,Value1)));
                    break;
                case '*':
                    calculator_screen.setText(String.valueOf(model1.mult(Value1,Value2)));
                    break;
                case '/':
                    if (!equal_pressed)
                        calculator_screen.setText(String.valueOf(model1.divide(Value1,Value2)));
                    else
                        calculator_screen.setText(String.valueOf(model1.divide(Value2,Value1)));
                    break;
                default:
                    calculator_screen.setText(content);
                    break;
            }
            if (!equal_pressed)
                Value1 = Value2;


        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView calculator_screen = findViewById(R.id.calculator_screen);
        final Button num_0 = findViewById(R.id.num_0);
        final Button num_1 = findViewById(R.id.num_1);
        final Button num_2 = findViewById(R.id.num_2);
        final Button num_3 = findViewById(R.id.num_3);
        final Button num_4 = findViewById(R.id.num_4);
        final Button num_5 = findViewById(R.id.num_5);
        final Button num_6 = findViewById(R.id.num_6);
        final Button num_7 = findViewById(R.id.num_7);
        final Button num_8 = findViewById(R.id.num_8);
        final Button num_9 = findViewById(R.id.num_9);
        final Button C = findViewById(R.id.C);
        final Button pos_neg = findViewById(R.id.pos_neg);
        final Button percent = findViewById(R.id.percent);
        final Button divide = findViewById(R.id.divide);
        final Button num_mult = findViewById(R.id.num_mult);
        final Button num_sub = findViewById(R.id.num_sub);
        final Button num_add = findViewById(R.id.num_add);
        final Button equals = findViewById(R.id.equals);
        final Button dot = findViewById(R.id.dot);



        final View.OnClickListener calculator_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model model1 = new Model();
                
                final int id = v.getId();
                String content = calculator_screen.getText().toString();

                if(!content.isEmpty()) {
                    C.setText("C");
                }
                switch(id) {
                    case R.id.num_0:
                        set_num(calculator_screen,"0");
                        break;
                    case R.id.num_1:
                        set_num(calculator_screen,"1");
                        break;
                    case R.id.num_2:
                        set_num(calculator_screen,"2");
                        break;
                    case R.id.num_3:
                        set_num(calculator_screen,"3");
                        break;
                    case R.id.num_4:
                        set_num(calculator_screen,"4");
                        break;
                    case R.id.num_5:
                        set_num(calculator_screen,"5");
                        break;
                    case R.id.num_6:
                        set_num(calculator_screen,"6");
                        break;
                    case R.id.num_7:
                        set_num(calculator_screen,"7");
                        break;
                    case R.id.num_8:
                        set_num(calculator_screen,"8");
                        break;
                    case R.id.num_9:
                        set_num(calculator_screen,"9");
                        break;
                    case R.id.divide:
                        set_action(model1, calculator_screen,content,'/');
                        break;
                    case R.id.num_mult:
                        set_action(model1,calculator_screen,content,'*');
                        break;
                    case R.id.num_sub:
                        set_action(model1,calculator_screen,content,'-');
                        break;
                    case R.id.num_add:
                        set_action(model1,calculator_screen,content,'+');
                        break;


                    case R.id.dot:
                        if(Error(content,calculator_screen))
                            return;

                        boolean first_dot=true;
                        for(int i=0;i<content.length();i++)
                            if(content.charAt(i)=='.')
                                first_dot=false;
                        if(first_dot)
                            calculator_screen.append(".");

                        break;
                    case R.id.C:
                        if(content.isEmpty()) {
                            String temp = "AC";
                            C.setText(temp);
                            operation_pressed = false;
                            current_op = '0';
                            return;
                        }
                        calculator_screen.setText("");
                        break;
                    case R.id.pos_neg:
                        if(Error(content,calculator_screen))
                            return;

                        boolean positive=true;
                        if(content.charAt(0)=='-')
                            positive=false;
                        if(positive) {
                            String temp = "-" + content;
                            calculator_screen.setText(temp);
                        }
                        else {
                            int temp = content.length();
                            calculator_screen.setText(content.substring(1, temp));
                        }
                        break;
                    case R.id.percent:
                        if(Error(content,calculator_screen))
                            return;

                        Value1 = Double.parseDouble(content);
                        calculator_screen.setText(String.valueOf(model1.divide(Value1,100)));
                        break;


                        case R.id.equals:
                        if(Error(content,calculator_screen) || operation_pressed)
                            return;

                        equal_op(calculator_screen,model1,content);
                        equal_pressed = true;


                        break;

                }
            }
        };


        num_0.setOnClickListener(calculator_listener);
        num_1.setOnClickListener(calculator_listener);
        num_2.setOnClickListener(calculator_listener);
        num_3.setOnClickListener(calculator_listener);
        num_4.setOnClickListener(calculator_listener);
        num_5.setOnClickListener(calculator_listener);
        num_6.setOnClickListener(calculator_listener);
        num_7.setOnClickListener(calculator_listener);
        num_8.setOnClickListener(calculator_listener);
        num_9.setOnClickListener(calculator_listener);
        num_0.setOnClickListener(calculator_listener);
        pos_neg.setOnClickListener(calculator_listener);
        percent.setOnClickListener(calculator_listener);
        divide.setOnClickListener(calculator_listener);
        num_mult.setOnClickListener(calculator_listener);
        num_sub.setOnClickListener(calculator_listener);
        num_add.setOnClickListener(calculator_listener);
        equals.setOnClickListener(calculator_listener);
        C.setOnClickListener(calculator_listener);
        dot.setOnClickListener(calculator_listener);


    }
}
