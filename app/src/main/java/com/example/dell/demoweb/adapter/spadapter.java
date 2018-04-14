package com.example.dell.demoweb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.demoweb.R;
import com.example.dell.demoweb.model.sp;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class spadapter extends RecyclerView.Adapter<spadapter.itemHolder>{
    Context context;
    ArrayList<sp> arraysp;

    public spadapter(Context context, ArrayList<sp> arraysp) {
        this.context = context;
        this.arraysp = arraysp;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_spmoinhat,null);
        itemHolder itemHolder = new itemHolder(v);
        return itemHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        sp sp = arraysp.get(position);
        holder.txttensp.setText(sp.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasp.setText("Giá: " + decimalFormat.format(sp.getGiasp()) + "Đ");
        Picasso.get().load(sp.getHinhanhsp())
                .placeholder(R.drawable.loading)
                .error(R.drawable.spinner)
                .into(holder.imghinhsp);

    }

    @Override
    public int getItemCount() {
        return arraysp.size();
    }

    public class itemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsp;
        public TextView txttensp, txtgiasp;


        public itemHolder(View itemView) {
            super(itemView);
            imghinhsp = (ImageView) itemView.findViewById(R.id.imageviewsp);
            txtgiasp = (TextView) itemView.findViewById(R.id.textviewgiasp);
            txttensp = (TextView) itemView.findViewById(R.id.textviewtensp);
        }
    }

}
