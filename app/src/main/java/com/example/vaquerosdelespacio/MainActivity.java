package com.example.vaquerosdelespacio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this should link to the XML file Ivana is making
        // won't stop being an error until she's done with it
        setContentView(R.layout.activity_main);
    }

    /**
     this method will be linked to the 'Recruit' button.
     */
    public void openRecruit(View view) {
        // Create an Intent to go from 'this' screen to 'RecruitmentActivity'
        Intent intent = new Intent(this, RecruitmentActivity.class);
        startActivity(intent);
    }

    /**
     * this method will be linked to the 'Mission' button.
     */
    public void openMission(View view) {
        Intent intent = new Intent(this, MissionActivity.class);
        startActivity(intent);
    }

    /**
     * healing in the quarters
     * the quarters is a safe area where energy restores
     * we can run this whenever the user returns to the Main Screen.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Loop through everyone in storage and refill their energy
        for (CrewMember member : Storage.getInstance().getCrewList()) {
            member.restoreEnergy();
        }

        // After restoring energy, check if anyone died in a mission
        // before they could get back to the quarters.
        Storage.getInstance().removeDeadCrew();
    }
}