package com.example.appbookstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DanhGiaAdapter extends RecyclerView.Adapter<DanhGiaAdapter.DanhGiaHolder> {
    List<DanhGiaObj> danhGiaObjList;
    List<DanhGiaObj> tatCaDanhGia;
    Context context;

    public DanhGiaAdapter(List<DanhGiaObj> tatCaDanhGia) {
        this.danhGiaObjList = tatCaDanhGia;
        this.tatCaDanhGia = tatCaDanhGia;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<DanhGiaObj> getTatCaDanhGia() {
        return tatCaDanhGia;
    }

    public void setTatCaDanhGia(List<DanhGiaObj> tatCaDanhGia) {
        this.tatCaDanhGia = tatCaDanhGia;
    }

    public List<DanhGiaObj> getDanhGiaObjList() {
        return danhGiaObjList;
    }

    public void setDanhGiaObjList(List<DanhGiaObj> danhGiaObjList) {
        this.danhGiaObjList = danhGiaObjList;
    }

    @NonNull
    @Override
    public DanhGiaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danh_gia, parent,false);
        return new DanhGiaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhGiaHolder holder, int position) {
        DanhGiaObj danhGiaObj = danhGiaObjList.get(position);
        if(danhGiaObj == null)
            return;
        if(danhGiaObj.getAvt() != null)
            Glide.with(context).load("http://192.168.1.7/android/Bookstore/public/bookstore/image/" +
                    danhGiaObj.getAvt()).into(holder.user_avt);
        holder.user_name.setText(danhGiaObj.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            holder.user_date.setText(sdf2.format(sdf.parse(danhGiaObj.getDate())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.user_cmt.setText(danhGiaObj.getCmt());
        holder.user_rating.setRating(danhGiaObj.getRating());
    }

    @Override
    public int getItemCount() {
        if(danhGiaObjList != null) {
            return danhGiaObjList.size();
        }
        return 0;
    }

    public class DanhGiaHolder extends RecyclerView.ViewHolder {
        private ImageView user_avt;
        private TextView user_name, user_date, user_cmt;
        private RatingBar user_rating;
        public DanhGiaHolder(@NonNull View itemView) {
            super(itemView);
            user_avt = itemView.findViewById(R.id.user_avt);
            user_name = itemView.findViewById(R.id.user_name);
            user_date = itemView.findViewById(R.id.user_date);
            user_cmt = itemView.findViewById(R.id.user_cmt);
            user_rating = itemView.findViewById(R.id.user_rating);
        }
    }
}