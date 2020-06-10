package com.shahnil.shoppingcart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private  ArrayList<CategoryItems> mCategoryList;

    private onItemClickListener mlistener;

    public interface onItemClickListener{
        void onitemclick(int position);
    }

    public void setonItemClickListener(onItemClickListener listener){
        mlistener = listener;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        public ImageView mimageView1;
        public TextView mcategoryName1;


        public CategoryViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);

            mimageView1 = itemView.findViewById(R.id.imageView1);
            mcategoryName1 = itemView.findViewById(R.id.item1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onitemclick(position);

                        }
                    }

                }
            });


        }
    }

    public CategoryAdapter(ArrayList<CategoryItems> CategoryList){
        mCategoryList = CategoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent,false);
        CategoryViewHolder cvh = new CategoryViewHolder(v, mlistener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryItems currentitem = mCategoryList.get(position);
        holder.mimageView1.setImageResource(currentitem.getMimageresource1());
        holder.mcategoryName1.setText(currentitem.getMcategoryName1());


    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}

