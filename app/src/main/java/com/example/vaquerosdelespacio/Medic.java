package com.example.vaquerosdelespacio;

public class Medic extends CrewMember{
    // super here means it'll send the specific medic stats to the parent
    public Medic(String name) {
        // stats are the exact same as in the plan
        super(name, 3, 7, 0, 15);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        int energy = this.getEnergy();
        if (energy >= 5) {
            // formula: scientific ability (7) + 2
            int healing = 7 + 2;

            // placeholder for MissionControl integration
            // CrewMember patient = MissionControl.getLowestResilienceCrew();
            // if (patient != null) { patient.restoreResilience(healing); }

            this.setEnergy(energy - 5);
            this.addExperience(6);

            return healing;
        }

        return 0;
    }
}