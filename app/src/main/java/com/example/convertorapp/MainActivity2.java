package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText binary;
    private Button convert;
    private TextView text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        binary=findViewById(R.id.binary);
        convert=findViewById(R.id.convert);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b1 = binary.getText().toString();
                if (b1.equals("")) {
                    Toast.makeText(MainActivity2.this, "Please Enter a binary value first", Toast.LENGTH_LONG).show();
                } else {
                    int c = 0, x = 0;
                    long d = 0;
                    long o = 0;
                    StringBuilder h = new StringBuilder();
                    int h1 = 0;
                    char ch = 'A', ch1;
                    for (int i = 0; i < b1.length(); i++) {
                        char a = b1.charAt(i);
                        if (a != '0' && a != '1') {
                            Toast.makeText(MainActivity2.this, "Binary number can only contain 0 and 1", Toast.LENGTH_LONG).show();
                            c = 1;
                            break;
                        }


                    }
                    if (c == 0) {
                        int l = b1.length() - 1;
                        for (int i = 0; i < b1.length(); i++, l--) {
                            if (b1.charAt(i) == '1') {
                                d += decimal(2, l);
                            }
                        }
                        if (d < 7) {
                            o = d;
                        } else {
                            o = octal(d);
                        }
                        if (d < 10) {
                            h1 = (int) d;
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
                    }
                    text1.setText("Decimal : " + d);
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
    public long decimal(int a,int b){
        if (b==0)
            return 1;
        else if(b%2==0)
            return decimal(a*a,b/2);
        return a*decimal(a,b-1);
    }
    public long octal(long a){
        if (a<7)
            return a;
        return (a%8)+10 * octal(a/8);
    }
}