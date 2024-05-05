package com.example.testbrilliant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class settingPageAdapter extends RecyclerView.Adapter<settingPageAdapter.MyViewHolder> {
    Context context;
    ArrayList<settingPageModel> settingPageModel;
    private OnItemClickListener onItemClickListener;
    public settingPageAdapter(Context context, ArrayList<settingPageModel> settingPageModel) {
        this.context = context;
        this.settingPageModel = settingPageModel;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public settingPageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate The layouts (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item,parent,false);

        return new settingPageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull settingPageAdapter.MyViewHolder holder, int position) {
        //Assigning values to the views we created in the recycler view based on the position of the recycler view
        holder.settingsItemName.setText(settingPageModel.get(position).getSettingsItemName());
        holder.settingsIcon.setImageResource(settingPageModel.get(position).getSettingsIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //Recyclerview just want to know the number of items you want to displayed

        return settingPageModel.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //Grabbing the views from our recycler view row layout file
        //Kinda like in the onCreate method

        TextView settingsItemName;
        ImageView settingsIcon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            settingsItemName = itemView.findViewById(R.id.settingsPageItem);
            settingsIcon = itemView.findViewById(R.id.settingsIcon);
        }
    }
}
