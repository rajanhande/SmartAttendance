package com.example.smartattendance;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MenuViewHolder>{
    @NonNull


    private Context mContext;
    private List<MenuData> mMenuList;

    MyAdapter(Context mContext, List<MenuData> mMenuList) {
        this.mContext = mContext;
        this.mMenuList = mMenuList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new MenuViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position)
    {
        holder.mImage.setImageResource(mMenuList.get(position).getMenuImage());
        holder.mTitle.setText(mMenuList.get(position).getMenuName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             
                 int i= position;
                 Toast.makeText(mContext,String.valueOf(i),Toast.LENGTH_SHORT).show();
                 if(i==1)
                {
                    Intent mIntent = new Intent(mContext,Study_Material.class);
                    mContext.startActivity(mIntent);
                }

                if(i==2)
                {
                    Intent mIntent = new Intent(mContext,Profile.class);
                    mContext.startActivity(mIntent);
                }


                if(i==3)
                {
                    Intent mIntent = new Intent(mContext,Leave_Application.class);
                    mContext.startActivity(mIntent);
                }

                if(i==0)
                {
                    Intent mIntent = new Intent(mContext,Attend.class);
                    mContext.startActivity(mIntent);
                }


             /*Intent mIntent = new Intent(mContext,Login.class);
                mIntent.putExtra("Title", mMenuList.get(holder.getAdapterPosition()).getMenuName());
                mIntent.putExtra("Image", mMenuList.get(holder.getAdapterPosition()).getMenuImage());
                mContext.startActivity(mIntent);
           */ }
        });
    }


    @Override
    public int getItemCount() {
        return mMenuList.size();
    }
}
class MenuViewHolder extends RecyclerView.ViewHolder
{
    ImageView mImage;
    TextView mTitle;
    CardView mCardView = itemView.findViewById(R.id.cardview);

    MenuViewHolder(View itemView)
    {
        super(itemView);

        mImage=itemView.findViewById(R.id.AttendanceRpt);
        mTitle=itemView.findViewById(R.id.tvTitle);
    }
}
