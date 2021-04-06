package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    private EditText hexadecimal;
    private TextView text1,text2,text3;
    private Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        hexadecimal=findViewById(R.id.hexadecimal);
        convert=findViewById(R.id.convert);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h1=hexadecimal.getText().toString();
                int c=0,d=0,o = 0;
                StringBuilder b = new StringBuilder();
                if (h1.equals("")){
                    Toast.makeText(MainActivity5.this, "Please Enter a HexaDecimal value first", Toast.LENGTH_LONG).show();
                }
                else{
                    for (int i=0;i<h1.length();i++){
                        char a=h1.charAt(i);
                        if (!((a>=48 && a<=57) || (a>='A' && a<='F'))){
                            Toast.makeText(MainActivity5.this, "HexaDecimal number can only contain digits and characters from 'A' to 'F'" , Toast.LENGTH_LONG).show();
                            c=1;
                            break;
                        }
                    }

                    if (c==0){
                        int l=h1.length()-1;
                        for (int i=0;i<h1.length();i++,l--){
                            char a=h1.charAt(i);
                            int x;
                            if (a>=48 && a<=57){
                                x = Integer.parseInt(String.valueOf(a));
                            }
                            else{
                                x = a - 55;
                            }
                            d+=x*decimal(16,l);

                        }
                        int x2=d;
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
                        
                    }
                    text1.setText("Decimal : "+d);
                    text2.setText("Binary : " + b);
                    text3.setText("Octal : " + o);
                }
            }
        });
    }
    public int decimal(int a,int b) {
        if (b == 0)
            return 1;
        else if (b % 2 == 0)
            return decimal(a * a, b / 2);
        return a * decimal(a, b - 1);
    }


    public int octal(int a){
        if (a<7)
            return a;
        return (a%8)+10 * octal(a/8);
    }
}