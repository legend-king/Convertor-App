package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText octal;
    private TextView text1,text2,text3;
    private Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        octal=findViewById(R.id.octal);
        convert=findViewById(R.id.convert);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o1=octal.getText().toString();
                StringBuilder b= new StringBuilder();
                int c=0,r;
                long d=0,h1=0;
                char ch='A',ch1;
                int x=0;
                StringBuilder h=new StringBuilder();
                if (o1.equals("")){
                    Toast.makeText(MainActivity3.this, "Please Enter an octal value first", Toast.LENGTH_LONG).show();
                }
                else{
                    for (int i=0;i<o1.length();i++){
                        if (!(o1.charAt(i)>=48 && o1.charAt(i)<=55)){
                            Toast.makeText(MainActivity3.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                            c=1;
                            break;
                        }
                    }
                    if (c==0){
                        long o=Integer.parseInt(o1);
                        int i=0;
                        while (o!=0){
                            r= (int) (o%10);
                            d+=r*(decimal(8,i));
                            i++;
                            o/=10;
                        }
//                        b1=binary(d);
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


                        if (d < 10) {
                            h1 = d;
                        } else {
                            x = 1;
                            if (d < 16) {
                                ch1 = (char) (ch + (d - 10));
                                h.append(ch1);
                            } else {
                                long x1 = d;
                                while (x1 != 0) {
                                    if (x1 % 16 < 10) {
                                        h.append(x1 % 16);
                                    } else {
                                        h.append((char) (ch + ((x1 % 16) - 10)));
                                    }
                                    x1 /= 16;
                                }
                                h.reverse();
                            }
                        }

                    }
                    text1.setText("Decimal : " + d);
                    text2.setText("Binary : " + b);
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


}