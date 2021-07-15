package com.example.basicbankingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class description extends AppCompatActivity {
    String un,uc,ue,uac,mamt;
    TextView t1,t2,t3,t4;
    Button b;
    public description()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        t1=(TextView)findViewById(R.id.dname);
        t2=(TextView)findViewById(R.id.dcon);
        t3=(TextView)findViewById(R.id.demail);
        t4=(TextView)findViewById(R.id.dacc);
        b=(Button) findViewById(R.id.razor);
        Intent intent=getIntent();
        un=intent.getStringExtra("name");
        uc=intent.getStringExtra("con");
        ue=intent.getStringExtra("email");
        uac=intent.getStringExtra("acc");
        t1.setText(un);
        t2.setText(uc);
        t3.setText(ue);
        t4.setText(uac);
      /*  b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li=LayoutInflater.from(getApplicationContext());
                final View dialogxml=li.inflate(R.layout.dialog,null);
                AlertDialog.Builder dialog=new AlertDialog.Builder(getApplicationContext());
                dialog.setTitle("Enter your amount");

                dialog.setView(dialogxml);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText amt=(EditText)findViewById(R.id.editText);
                        mamt=amt.getText().toString();
                        dialog.dismiss();



                    }
                });
                AlertDialog builder =dialog.create();
                builder.show();
                Toast.makeText(getApplicationContext(),"t"+mamt,Toast.LENGTH_SHORT).show();




            }
        });*/
    }
    public void a(View view)
    {
        LayoutInflater li=LayoutInflater.from(getApplicationContext());
        final View dialogxml=li.inflate(R.layout.dialog,null);
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Enter your amount");

        dialog.setView(dialogxml);


        EditText input=(EditText)dialogxml.findViewById(R.id.editText);
        Button o=(Button)dialogxml.findViewById(R.id.ok);
        AlertDialog builder =dialog.create();
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i=Integer.parseInt(input.getText().toString());
                i=i*100;
                mamt=i.toString();
                //Toast.makeText(getApplicationContext(),mamt,Toast.LENGTH_SHORT).show();
                builder.dismiss();
                Intent intent=new Intent(getApplicationContext(),razor.class);
                intent.putExtra("name",un);
                intent.putExtra("contact",uc);
                intent.putExtra("email",ue);
                intent.putExtra("account",uac);
                intent.putExtra("amount",mamt);
                startActivity(intent);

            }
        });


        builder.show();





    }


}