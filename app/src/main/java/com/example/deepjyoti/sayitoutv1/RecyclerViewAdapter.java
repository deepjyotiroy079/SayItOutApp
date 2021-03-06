package com.example.deepjyoti.sayitoutv1;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Article> articleList;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Article> articleNames, Context context) {
        this.articleList = articleNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final Article article = articleList.get(position);
        holder.article_name.setText(article.getArticle_title());

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, article.getArticle_title(), Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                Intent intent = new Intent(context, ArticleActivity.class);
                intent.putExtra("article_title", article.getArticle_title());
                intent.putExtra("article_content", article.getArticle_content());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView article_name;
        RelativeLayout parent_layout;
        public ViewHolder(View itemView) {
            super(itemView);
            article_name = itemView.findViewById(R.id.article_name);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
