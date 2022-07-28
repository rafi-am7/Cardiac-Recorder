package com.example.cardiacrecorder.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiacrecorder.R;
import com.example.cardiacrecorder.Record;

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
                if (mCustomClickListener != null) {
                   // int position = holder.getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mCustomClickListener.onEditClick(position);
                    }
                }

            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomClickListener != null) {
               //    int position = holder.getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mCustomClickListener.onDeleteClick(position);
                    }
                }


            }

        });

        if (record.getDiastolic()>59 && record.getDiastolic() < 91) holder.diastolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getDiastolic()>39 && record.getDiastolic() < 121) holder.diastolicTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.diastolicTextView.setTextColor(Color.parseColor("#C3473E"));


        if (record.getSystolic()>89 && record.getSystolic()<141) holder.systolicTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getSystolic()>59 && record.getSystolic()<181) holder.systolicTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.systolicTextView.setTextColor(Color.parseColor("#C3473E"));


        if (record.getHeartRate()>60 && record.getHeartRate()<100) holder.heartTextView.setTextColor(Color.parseColor("#FF018786"));
        else if(record.getHeartRate()>=40 && record.getHeartRate()<=120) holder.heartTextView.setTextColor(Color.parseColor("#3C96DD"));
        else holder.heartTextView.setTextColor(Color.parseColor("#C3473E"));


    }

    /**
     * function for getting number of saved records
     * @return
     */
    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public interface CustomClickListener {
        void customOnClick(int position, View v);

        void customOnLongClick(int position, View v);

        void onDeleteClick(int position);

        void onEditClick(int position);
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
            mCustomClickListener.customOnClick(getAbsoluteAdapterPosition(), view);  //position and view setting to provide to mainactivity
        }


        public boolean onLongClick(View view) {

            mCustomClickListener.customOnLongClick(getAbsoluteAdapterPosition(), view);  //position and view setting to provide to mainactivity
            return true;

        }
    }


}

