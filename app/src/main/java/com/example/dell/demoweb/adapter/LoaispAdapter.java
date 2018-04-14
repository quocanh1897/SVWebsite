package com.example.dell.demoweb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.demoweb.R;
import com.example.dell.demoweb.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.dell.demoweb.R.layout.dong_listview;

public class LoaispAdapter extends BaseAdapter {


    ArrayList<Loaisp> arrayListLoaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListLoaisp, Context context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListLoaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //ho tro load du lieu nhanh hon
    //nhung lan load sau da co gia tri thi k can load lai gtri
    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgLoaisp;

    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview,null);

            viewHolder.imgLoaisp =(ImageView) view.findViewById(R.id.imageviewloaisp);
            viewHolder.txttenloaisp =(TextView) view.findViewById(R.id.textviewloaisp);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();

        }
        Loaisp loaisp = (Loaisp) getItem(i);
        viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.get().load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.loading)
                .error(R.drawable.spinner)
                .into(viewHolder.imgLoaisp);

        return view;
    }
}
