package com.muneiah.firebasefileuploading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Pojo> pojoList;

    public MyAdapter(Context context, ArrayList<Pojo> pojoList) {
        this.context = context;
        this.pojoList = pojoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView n,m;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.row_tv_name);
            m=itemView.findViewById(R.id.row_tv_nu);
        }
    }
}
