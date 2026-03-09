package com.example.starrail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_trip extends RecyclerView.Adapter<adapter_trip.TripViewHolder> {
    private List<model_trip> Data;
    private OnTripClickListener Listener;

    public adapter_trip(List<model_trip> Data, OnTripClickListener Listener){
        this.Data = Data;
        this.Listener = Listener;
    }

    @NonNull
    @Override
    public adapter_trip.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card_trip, parent, false);
        return new TripViewHolder(itemCard);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_trip.TripViewHolder holder, int position) {
        model_trip currentItem = Data.get(position);
        holder.Name.setText(currentItem.getTrip_name());
        holder.Description.setText(currentItem.getTrip_description());
        holder.Price.setText(String.valueOf(currentItem.getTrip_price()));
        holder.itemView.setOnClickListener(view -> {
            if (Listener != null){
                Listener.onTripClick(currentItem);
            }
        });
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public interface OnTripClickListener{
        void onTripClick(model_trip event);
    }

    public static class TripViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Description;
        TextView Price;
        public TripViewHolder(View itemView){
            super(itemView);
            Name = itemView.findViewById(R.id.trip_name);
            Description = itemView.findViewById(R.id.trip_description);
            Price = itemView.findViewById(R.id.trip_price);
        }
    }
}
