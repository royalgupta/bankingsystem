package com.example.basicbankingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basicbankingsystem.database.userdatabase;

public class adduser extends AppCompatActivity {
    EditText mname,mcontact,memail,macc;
    Button sub,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        mname=(EditText)findViewById(R.id.uname);
        mcontact=(EditText)findViewById(R.id.ucontact);
        memail=(EditText)findViewById(R.id.uemail);
        macc=(EditText)findViewById(R.id.uacc);
        sub=(Button)findViewById(R.id.submit);
        d=(Button)findViewById(R.id.del);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gname=mname.getText().toString();
                String gemail=memail.getText().toString();
                String gcontact=mcontact.getText().toString();
                String gacc=macc.getText().toString();


                process(gname,gcontact,gemail,gacc);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userdatabase user=new userdatabase(getApplicationContext());
                user.delete();
            }
        });


    }

    private void process(String gname, String gcontact, String gemail, String gacc) {
        String res=new userdatabase(this).addrecord(gname,gcontact,gemail,gacc);
        macc.setText("");
        memail.setText("");
        mcontact.setText("");
        mname.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }

}