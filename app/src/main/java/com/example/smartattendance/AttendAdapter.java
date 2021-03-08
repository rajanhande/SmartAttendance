package com.example.smartattendance;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartattendance.MVP.Attendance;
import com.example.smartattendance.MVP.Study;

import java.util.List;

public class AttendAdapter extends RecyclerView.Adapter<AttendAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Attendance> productList;

    public AttendAdapter(Context mCtx, List<Attendance> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public AttendAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardviewattend, null);
        return new AttendAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendAdapter.ProductViewHolder holder, int position) {
        Attendance product = productList.get(position);

        //loading the image
        /*Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));*/

        holder.txtsub.setText(product.getDate());



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView txtsub, txtnotes;
        //ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            txtsub = itemView.findViewById(R.id.txtDate);


            // imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
