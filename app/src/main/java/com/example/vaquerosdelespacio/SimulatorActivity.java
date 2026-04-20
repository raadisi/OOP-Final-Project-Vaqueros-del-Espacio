package com.example.vaquerosdelespacio;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class SimulatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator);
    }

    // this method simulates a training session for the whole team
    public void startGroupTraining(View view) {
        // check if we even have a crew to train
        if (Storage.getInstance().getCrewList().isEmpty()) {
            Toast.makeText(this, "No crew members to train!", Toast.LENGTH_SHORT).show();
            return;
        }

        // we loop through every member currently in the vault
        for (CrewMember member : Storage.getInstance().getCrewList()) {
            // we use the method we defined in the abstract parent class
            member.addExperience(10);

            // training is hard work, so it costs some energy
            member.defend(2);
        }

        Toast.makeText(this, "Training complete! Everyone gained 10 XP.", Toast.LENGTH_SHORT).show();

        // head back to main so the user can see the updated stats in the recyclerview
        finish();
    }
}