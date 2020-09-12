package com.example.helvoirthuis.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.helvoirthuis.Post;
import com.example.helvoirthuis.R;
import com.squareup.picasso.Picasso;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;
    public ArrayList<Post> blogPost;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public PostAdapter (Context context, ArrayList<Post> list)
    {
        blogPost = list;
        mContext=context;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mPostTitle;
        public ImageView mPostImage;
        public TextView mPostAuthor;
        public TextView mPostHeader;
        public TextView mPostDate;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setTag(this);
            mPostTitle = itemView.findViewById(R.id.postTitle);
            mPostHeader = itemView.findViewById(R.id.postHeader);
            mPostAuthor = itemView.findViewById(R.id.postAuthor);
            mPostImage = itemView.findViewById(R.id.postImage);
            mPostDate = itemView.findViewById(R.id.postDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

    }
    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row_layout , parent , false);

        return new ViewHolder(view , mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, final int position) {

        holder.itemView.setTag(blogPost.get(position));

        final Post currentItem = blogPost.get(position);

        String postAuthor = currentItem.getPost_author();
        String postTitle = currentItem.getPost_title();
        String postHeader = currentItem.getPost_header();
        String postDate = currentItem.getPost_available_date();

        Resources res = holder.itemView.getContext().getResources();
        String serverAdr = res.getString(R.string.app_server_adr) + currentItem.getPost_image();
//        System.out.println(serverAdr);

        holder.mPostAuthor.setText(postAuthor);
        holder.mPostTitle.setText(postTitle.toUpperCase());
        holder.mPostHeader.setText(Html.fromHtml(postHeader, Html.FROM_HTML_MODE_LEGACY));
        holder.mPostDate.setText(postDate);

        Picasso.get().load(serverAdr ).fit().centerCrop().into(holder.mPostImage);

    }

    @Override
    public int getItemCount() {
        return blogPost.size();
    }
}
