package com.example.vaquerosdelespacio;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

/**
this is the main file for creating and keeping track of the crew members
 */
public class RecruitmentActivity extends AppCompatActivity {

    // we define this here so that later can grab
    private EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit); // This will link to Iv's XML

        // initialising the edit text to be used later
        // ivana's XML will replace the name here
        editName = findViewById(R.id.editCrewName);
    }

    /**
     recruiting a pilot, called when a pilot is recruited (omg)
     */
    public void recruitPilot(View view) {
        String name = editName.getText().toString();

        if (!name.isEmpty()) {
            // first step is to use Calu's classes to create a new pilot
            Pilot newPilot = new Pilot(name);

            // second is to add it to the 'vault'
            Storage.getInstance().addCrew(newPilot);

            // third is success feedback
            Toast.makeText(this, name + " joined the flight crew!", Toast.LENGTH_SHORT).show();

            // fourth to close the screen and head back to the main page
            finish();
        } else {
            Toast.makeText(this, "The Vaquero needs a name!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     repeating for the others
     */
    public void recruitMedic(View view) {
        String name = editName.getText().toString();
        if (!name.isEmpty()) {
            Medic newMedic = new Medic(name);
            Storage.getInstance().addCrew(newMedic);
            finish();
        }
    }

    public void recruitScientist(View view) {
        String name = editName.getText().toString();
        if (!name.isEmpty()) {
            Scientist newScientist = new Scientist(name);
            Storage.getInstance().addCrew(newScientist);
            Toast.makeText(this, name + " is ready for research!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "The Vaquero needs a name!", Toast.LENGTH_SHORT).show();
        }
    }

    public void recruitEngineer(View view) {
        String name = editName.getText().toString();
        if (!name.isEmpty()) {
            Engineer newEngineer = new Engineer(name);
            Storage.getInstance().addCrew(newEngineer);
            Toast.makeText(this, name + " is checking the engines!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "The Vaquero needs a name!", Toast.LENGTH_SHORT).show();
        }
    }

    public void recruitSecurity(View view) {
        String name = editName.getText().toString();
        if (!name.isEmpty()) {
            SecurityOfficer newSecurity = new SecurityOfficer(name);
            Storage.getInstance().addCrew(newSecurity);
            Toast.makeText(this, name + " is securing the perimeter!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "The Vaquero needs a name!", Toast.LENGTH_SHORT).show();
        }
    }
}
