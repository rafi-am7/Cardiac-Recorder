package com.example.cardiacrecorder.adapter;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
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
    public void onBindViewHolder(@NonNull RecordAdapter.RecordViewHolder holder, int position) {
        if (!recordList.isEmpty()) record = recordList.get(position);

        holder.dateTextView.setText(""+record.getDate());
        holder.systolicTextView.setText(""+record.getSystolic());
        holder.diastolicTextView.setText(""+record.getDiastolic());
        holder.heartTextView.setText(""+record.getHeartRate());
        if (record.getDiastolic()<80) {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, gConditionColor);
            holder.diastolicTextView.setBackground(buttonDrawable);
        }
        else if(record.getDiastolic()<=89){
           Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, nConditionColor);
            holder.diastolicTextView.setBackground(buttonDrawable);
           // holder.containerCardView.setCardBackgroundColor(unBookedColor);

        }
        else
        {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, cConditionColor);
            holder.diastolicTextView.setBackground(buttonDrawable);
            // holder.containerCardView.setCardBackgroundColor(unBookedColor);

        }


        if (record.getSystolic()<120) {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, gConditionColor);
            holder.systolicTextView.setBackground(buttonDrawable);
        }
        else if(record.getSystolic()<=139){
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, nConditionColor);
            holder.systolicTextView.setBackground(buttonDrawable);
            // holder.containerCardView.setCardBackgroundColor(unBookedColor);

        }
        else
        {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, cConditionColor);
            holder.systolicTextView.setBackground(buttonDrawable);
            // holder.containerCardView.setCardBackgroundColor(unBookedColor);

        }


        if (record.getHeartRate()>60 && record.getHeartRate()<100) {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, gConditionColor);
            holder.heartTextView.setBackground(buttonDrawable);
            holder.heartTextView.setBackgroundColor( gConditionColor);
        }
        else if(record.getHeartRate()>=40){
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, nConditionColor);
            holder.heartTextView.setBackground(buttonDrawable);
            holder.heartTextView.setBackgroundColor( nConditionColor);

        }
        else
        {
            Drawable buttonDrawable = holder.containerCardView.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, cConditionColor);
            holder.heartTextView.setBackground(buttonDrawable);
            holder.heartTextView.setBackgroundColor( cConditionColor);

        }




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

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            systolicTextView = itemView.findViewById(R.id.tvSystolic);
            diastolicTextView = itemView.findViewById(R.id.tvDiastolic);
            dateTextView = itemView.findViewById(R.id.tvDate);
            heartTextView = itemView.findViewById(R.id.tvHeartRate);
            containerCardView = itemView.findViewById(R.id.llContainerCardView);

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

