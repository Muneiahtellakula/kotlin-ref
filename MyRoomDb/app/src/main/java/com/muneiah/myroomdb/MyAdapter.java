package com.muneiah.myroomdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Student_entity> list;

    public MyAdapter(Context context, List<Student_entity> student_entityList) {
        this.context = context;
        this.list = student_entityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sn.setText(list.get(position).getName());
        holder.sr.setText(list.get(position).getNumber());
        holder.tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // MainActivity.studentsDataBase.studentsDAO().delete(list.get(position));
                MainActivity.myViewModel.delete(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sn,sr,tv_edit,tv_del;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sn=itemView.findViewById(R.id.textView);
            sr=itemView.findViewById(R.id.textView2);
            tv_del=itemView.findViewById(R.id.del);
            tv_edit=itemView.findViewById(R.id.edit);
            tv_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String myname=sn.getText().toString();
                    String mynum=sr.getText().toString();
                    Intent intent=new Intent(context,UpdateActivity.class);
                    intent.putExtra("name",myname);
                    intent.putExtra("roll",mynum);
                    context.startActivity(intent);
                }
            });
        }
    }
}
