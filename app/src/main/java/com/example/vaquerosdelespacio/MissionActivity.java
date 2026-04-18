package com.example.vaquerosdelespacio;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MissionActivity extends AppCompatActivity {

    private TextView logText;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        // this will display the mission updates
        logText = findViewById(R.id.textMissionLog);
    }

    // the main logic for encountering a threat or finding research
    public void startMission(View view) {
        if (Storage.getInstance().getCrewList().isEmpty()) {
            Toast.makeText(this, "No crew to send on mission!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 1. roll a random event (1-10)
        int eventRoll = random.nextInt(10) + 1;

        // 2. determine the threat level
        int threatPower = 15; // static for now, can scale later
        int crewPower = 0;

        // 3. sum up the crew's power using polymorphism (Calu's act() methods)
        for (CrewMember member : Storage.getInstance().getCrewList()) {
            crewPower += member.act();
            // missions are tiring!
            member.defend(3);
        }

        // 4. resolve the event based on your project document
        if (eventRoll > 7) {
            // positive event: research materials found
            logText.setText("SUCCESS: Essential research materials found! Progress toward cure increased.");
            for (CrewMember m : Storage.getInstance().getCrewList()) {
                m.addExperience(20); // extra reward
            }
        } else if (crewPower >= threatPower) {
            // survival: standard mission completion
            logText.setText("THREAT NEUTRALIZED: The crew survived the encounter. Total Power: " + crewPower);
        } else {
            // danger: the threat was too strong
            logText.setText("DANGER: The threat was too strong! Crew took heavy damage.");
            for (CrewMember m : Storage.getInstance().getCrewList()) {
                m.defend(5); // extra penalty
            }
        }
    }

    public void exitMission(View view) {
        // heading back home
        finish();
    }
}