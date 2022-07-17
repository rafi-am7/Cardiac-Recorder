package com.example.cardiacrecorder.adapter;

import android.annotation.SuppressLint;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiacrecorder.AddActivity;
import com.example.cardiacrecorder.R;
import com.example.cardiacrecorder.Record;
import com.example.cardiacrecorder.UpdateActivity;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {
    private static CustomClickListener mCustomClickListener;
    private final ArrayList<Record> recordList;
    private Record record;
    private final Context mContext;
    private final int cConditionColor;
    private final int gConditionColor;
    private final int nConditionColor;

    //constructor
    public RecordAdapter(Context context, int goodConditionColor,int normalConditionColor, int criticalConditionColor, ArrayList<Record> rList) {
        this.recordList=rList;
        this.mContext = context;
        this.nConditionColor = normalConditionColor;
        this.gConditionColor = goodConditionColor;
        this.cConditionColor = criticalConditionColor;
    }

    public void setCustomClickListener(CustomClickListener customClickListener) //called from mainactivity
    {
        mCustomClickListener = customClickListener; //setting data
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //an object of roomview holder which contain itemview
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_cardview_home, parent, false);
        return new RecordViewHolder(view); //passed in itemview

    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.RecordViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (!recordList.isEmpty()) record = recordList.get(position);

        holder.dateTextView.setText(""+record.getDate());
        holder.systolicTextView.setText(""+record.getSystolic());
        holder.diastolicTextView.setText(""+record.getDiastolic());
        holder.heartTextView.setText(""+record.getHeartRate());

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpdateActivity.class);
                intent.putExtra("index",position);
                mContext.startActivity(intent);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if (record.getDiastolic()<80) holder.diastolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getDiastolic()<=89) holder.diastolicTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.diastolicTextView.setTextColor(Color.parseColor("#C3473E"));


        if (record.getSystolic()<120) holder.systolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getSystolic()<=139) holder.systolicTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.systolicTextView.setTextColor(Color.parseColor("#C3473E"));


        if (record.getHeartRate()>60 && record.getHeartRate()<100) holder.heartTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getHeartRate()>=40) holder.heartTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.heartTextView.setTextColor(Color.parseColor("#C3473E"));






    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public interface CustomClickListener {
        void customOnClick(int position, View v);

        void customOnLongClick(int position, View v);
        //declaring method which will provide to main activity //position and view will also be provided
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView systolicTextView;
        TextView heartTextView;
        TextView diastolicTextView;
        TextView dateTextView;
        CardView containerCardView;
        ImageView editButton, deleteButton;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            systolicTextView = itemView.findViewById(R.id.tvSystolic);
            diastolicTextView = itemView.findViewById(R.id.tvDiastolic);
            dateTextView = itemView.findViewById(R.id.tvDate);
            heartTextView = itemView.findViewById(R.id.tvHeartRate);
            containerCardView = itemView.findViewById(R.id.llContainerCardView);
            editButton = itemView.findViewById(R.id.editIm);
            deleteButton = itemView.findViewById(R.id.deleteIm);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        } //to create view of every list item

        @Override
        public void onClick(View view) {
            mCustomClickListener.customOnClick(getAdapterPosition(), view);  //position and view setting to provide to mainactivity
        }

        public boolean onLongClick(View view) {

            mCustomClickListener.customOnLongClick(getAdapterPosition(), view);  //position and view setting to provide to mainactivity
            return true;

        }
    }


}

