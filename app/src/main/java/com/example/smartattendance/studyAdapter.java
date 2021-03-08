package com.example.smartattendance;

import com.example.smartattendance.MVP.Study;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class studyAdapter extends RecyclerView.Adapter<studyAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<Study> productList;

    public studyAdapter(Context mCtx, List<Study> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview_study_material, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Study product = productList.get(position);

        //loading the image
        /*Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));*/

        holder.txtsub.setText(product.getSubName());
        holder.txtnotes.setText(product.getDescr());



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

            txtsub = itemView.findViewById(R.id.txtsub);
            txtnotes = itemView.findViewById(R.id.txtnotes);

           // imageView = itemView.findViewById(R.id.imageView);
        }
    }
}




