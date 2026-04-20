package com.example.vaquerosdelespacio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {

    private ArrayList<CrewMember> crewList;

    public CrewAdapter(ArrayList<CrewMember> crewList) {
        this.crewList = crewList;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this links to Iv's item_crew.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crew, parent, false);
        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        CrewMember member = crewList.get(position);

        // setting the name and details from the crewmember object
        holder.name.setText(member.getName());
        holder.details.setText("Energy: " + member.getEnergy() + " | XP: " + member.getExperience());
    }

    @Override
    public int getItemCount() {
        return crewList.size();
    }

    public static class CrewViewHolder extends RecyclerView.ViewHolder {
        TextView name, details;

        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);
            // linking to the IDs Iv provided in her XML
            name = itemView.findViewById(R.id.textCrewName);
            details = itemView.findViewById(R.id.textCrewDetails);
        }
    }
}