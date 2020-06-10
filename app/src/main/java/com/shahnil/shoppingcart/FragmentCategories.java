package com.shahnil.shoppingcart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategories extends Fragment {


    private RecyclerView mRecylerView;
    private  CategoryAdapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<CategoryItems> categoryList = new ArrayList<>();
        categoryList.add(new CategoryItems(R.drawable.imgcategory_1,  ""));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_2, ""));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_3,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_4,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_5,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_6,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_7,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_8,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_9,  "" ));
        categoryList.add(new CategoryItems(R.drawable.imgcategory_10,  "" ));





       View rootview =  inflater.inflate(R.layout.fragment_categories,container,false);


        mRecylerView = rootview.findViewById(R.id.recyclerView);
        mRecylerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new CategoryAdapter(categoryList);

        mRecylerView.setLayoutManager(mLayoutManager);
        mRecylerView.setAdapter(mAdapter);

        mAdapter.setonItemClickListener(new CategoryAdapter.onItemClickListener() {
            @Override
            public void onitemclick(int position) {

                switch (position){
                    case 0:

                        Intent intent = new Intent(getActivity(), Cart.class);
                        startActivity(intent);

                        break;


                    case 1:
                        Toast.makeText(getActivity(), "item 1 clicked ", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(getActivity(), "item 2 clicked ", Toast.LENGTH_SHORT).show();
                        break;

                }





            }
        });


        return rootview;


    }
}
