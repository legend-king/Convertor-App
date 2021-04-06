package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    private EditText decimal;
    private TextView text1,text2,text3;
    private Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        decimal=findViewById(R.id.decimal);
        convert=findViewById(R.id.convert);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1=decimal.getText().toString();
                long o,h1=0,x=0;
                StringBuilder b=new StringBuilder();
                char ch='A',ch1;
                StringBuilder h=new StringBuilder();
                if (d1.equals("")){
                    Toast.makeText(MainActivity4.this, "Please Enter a Decimal Value First", Toast.LENGTH_LONG).show();
                }
                else{
                    long d=Integer.parseInt(d1);
//                    b=binary(d);
                    long x2=d;
                    while(x2!=0){
                        char cha;
                        if (x2%2==0){
                            cha = 48;
                        }
                        else{
                            cha = 49;
                        }
                        b.append(cha);
                        x2/=2;
                    }
                    b.reverse();
                    if (d < 7) {
                        o = d;
                    } else {
                        o = octal(d);
                    }
                    if (d < 10) {
                        h1 = d;
                    } else if (d < 16) {
                        x = 1;
                        ch1 = (char) (ch + (d - 10));
                        h.append(ch1);
                    } else {
                        x = 1;
                        long x1 = d;
                        while (x1 != 0) {
                            if (x1 % 16 < 10) {
                                h.append(x1 % 16);
                                x1 /= 16;
                            } else {
                                h.append((char) (ch + ((x1 % 16) - 10)));
                                x1 /= 16;
                            }
                        }
                        h.reverse();
                    }
                    text1.setText("Binary : " + b);
                    text2.setText("Octal : " + o);
                    if (x == 0) {
                        text3.setText("Hexa Decimal : " + h1);
                    } else {
                        text3.setText("Hexa Decimal : " + h);
                    }

                }
            }
        });

    }
    public long octal(long a){
        if (a<7)
            return a;
        return (a%8)+10 * octal(a/8);
    }

}