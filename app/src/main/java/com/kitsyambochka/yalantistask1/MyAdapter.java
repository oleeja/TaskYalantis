package com.kitsyambochka.yalantistask1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Developer on 16.03.2016.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<Uri> mImageUri;
    private Context mContext;
    private OnItemRecyclerViewListener mImageListener;

    public MyAdapter(ArrayList<Uri> imageUri, Context context, OnItemRecyclerViewListener mImageListener) {
        this.mImageUri = imageUri;
        this.mContext = context;
        this.mImageListener = mImageListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Picasso.with(mContext).load(mImageUri.get(position)).error(R.drawable.no_image)
                .into(((ViewHolder) holder).mImageView);

        ((ViewHolder) holder).mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageListener != null) {
                    mImageListener.onImageViewClick();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUri.size();
    }
}