package com.example.homeworkeight;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    private String[] dataSource;

    public SocialNetworkAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }

    private MyOnClickListener listener;

    public void setOnMyOnClickListener(MyOnClickListener listener){
        this.listener = listener;
    }

    public void setData() {
        this.dataSource = dataSource;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewItem.setText(dataSource[position]);
        holder.textViewDescription.setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewItem;
        TextView textViewDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textView_item);
            textViewDescription = itemView.findViewById(R.id.textView_description);

            textViewItem.findViewById(R.id.textView_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMyClick(view, getAdapterPosition());
                }
            });
        }
    }
}
