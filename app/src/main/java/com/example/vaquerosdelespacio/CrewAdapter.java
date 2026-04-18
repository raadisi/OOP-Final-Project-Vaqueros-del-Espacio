package com.example.vaquerosdelespacio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CrewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // linking the recyclerview to the UI element Iv is creating
        recyclerView = findViewById(R.id.rvCrewList);

        // setting the layout manager to a standard vertical list
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // this runs every time we return to the home screen
    @Override
    protected void onResume() {
        super.onResume();

        // since the quarters is a safe area, we loop through and restore everyone's energy
        for (CrewMember member : Storage.getInstance().getCrewList()) {
            member.restoreEnergy();
        }

        // we check if anyone didn't make it back alive before updating the list
        Storage.getInstance().removeDeadCrew();

        // here we refresh the adapter to show new recruits or updated stats
        adapter = new CrewAdapter(Storage.getInstance().getCrewList());
        recyclerView.setAdapter(adapter);
    }

    // navigation logic for the recruitment center
    public void openRecruit(View view) {
        Intent intent = new Intent(this, RecruitmentActivity.class);
        startActivity(intent);
    }

    // navigation logic for starting a mission
    public void openMission(View view) {
        Intent intent = new Intent(this, MissionActivity.class);
        startActivity(intent);
    }

    // navigation logic for the training simulator
    public void openSimulator(View view) {
        Intent intent = new Intent(this, SimulatorActivity.class);
        startActivity(intent);
    }
}