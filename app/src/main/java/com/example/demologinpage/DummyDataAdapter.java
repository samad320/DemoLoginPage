package com.example.demologinpage;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DummyDataAdapter extends RecyclerView.Adapter<DummyDataAdapter.ViewHolder> {

    private List<DummyData> data;

    public DummyDataAdapter(List<DummyData> data) {
        this.data = data;
    }

    public List<DummyData> getData() {
        return data;
    }

    public void setData(List<DummyData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dummy_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DummyData dummyData = data.get(position);

        holder.nameTextView.setText(dummyData.getName());
        holder.ageTextView.setText("Age: " + dummyData.getAge());
        holder.cityTextView.setText("City: " + dummyData.getCity());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ageTextView;
        TextView cityTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
            cityTextView = itemView.findViewById(R.id.cityTextView);
        }
    }
}
