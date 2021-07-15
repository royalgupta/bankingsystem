package com.example.basicbankingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.basicbankingsystem.adapter.adapter1;
import com.example.basicbankingsystem.database.userdatabase;
import com.example.basicbankingsystem.model.model;

import java.util.ArrayList;

public class showuser extends AppCompatActivity {

    RecyclerView rec;
    ArrayList<model> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showuser);
        data =new ArrayList<model>();

        rec =(RecyclerView)findViewById(R.id.recycle);
        rec.setLayoutManager(new LinearLayoutManager(this));
        Cursor c=new userdatabase(this).fetch();
        while(c.moveToNext())
        {
            model obj=new model(c.getString(1),c.getString(2),c.getString(3),c.getString(4));
            data.add(obj);
            Log.i("res",data.get(0).getName());
        }
        adapter1 adp=new adapter1(data);
        rec.setAdapter(adp);


    }
}