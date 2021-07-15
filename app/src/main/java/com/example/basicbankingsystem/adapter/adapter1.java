package com.example.basicbankingsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicbankingsystem.R;
import com.example.basicbankingsystem.description;
import com.example.basicbankingsystem.model.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter1 extends RecyclerView.Adapter<adapter1.viewholder> {
    ArrayList<model> dataholder;
    Context context;
    public adapter1(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }
    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        context=parent.getContext();
        return new adapter1.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull adapter1.viewholder holder, int position) {
        holder.t1.setText(dataholder.get(position).getName());
        holder.t2.setText(dataholder.get(position).getContact());
        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //description dec=new description("abhi",dataholder.get(position).getContact(), dataholder.get(position).getEmail(), dataholder.get(position).getAccno());
                Intent intent=new Intent(context, description.class );
                intent.putExtra("name",dataholder.get(position).getName());
                intent.putExtra("con",dataholder.get(position).getContact());
                intent.putExtra("email",dataholder.get(position).getEmail());
                intent.putExtra("acc",dataholder.get(position).getAccno());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        CardView c;
        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.user);
            t2=(TextView)itemView.findViewById(R.id.contact);
            c=(CardView)itemView.findViewById(R.id.card);
        }
    }
}
