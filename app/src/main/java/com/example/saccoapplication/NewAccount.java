package com.example.saccoapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewAccount extends AppCompatActivity {
    MyDatabaseHelper db;
    EditText e1,e2,e3,e4,e5,e6;
    Button b1, b2;

    Button bb;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new MyDatabaseHelper(this);

        e1= (EditText)findViewById(R.id.username);
        e2= (EditText)findViewById(R.id.email);
        e3= (EditText)findViewById(R.id.nin);
        e5= (EditText)findViewById(R.id.pass);
        e6= (EditText)findViewById(R.id.confirmpasas);
        e4= (EditText)findViewById(R.id.phone);

        b1 = (Button)findViewById(R.id.btn2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();

                if (s1.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"username field is empty",Toast.LENGTH_SHORT).show();
                }
                else if (s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"password field is empty",Toast.LENGTH_SHORT).show();
                }
                else if(s3.equals("")){
                    Toast.makeText(getApplicationContext(),"password field is empty",Toast.LENGTH_SHORT).show();
                }
                else if(s4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"password field is empty",Toast.LENGTH_SHORT).show();
                }
                else if(s5.equals("")) {
                    Toast.makeText(getApplicationContext(),"password field is empty",Toast.LENGTH_SHORT).show();


                }
                else  {
                    if (s5.equals(s6))
                    {
                        Boolean CheckMail = db.CheckMail(s1);
                        if (CheckMail== true)
                        {
                            Boolean insert = db.insert(s1,s2,s3,s4,s5);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Registered successful",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),NewAccount.class);
                                startActivity(intent);
                                 }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email already exits",Toast.LENGTH_SHORT).show();


                        }

                    }
                    Toast.makeText(getApplicationContext()," No matched password",Toast.LENGTH_SHORT).show();


                }

            }

        });

    }

}
