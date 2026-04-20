package com.example.vaquerosdelespacio;

public class Scientist extends CrewMember {
    // super here means it'll send the specific scientist stats to the parent
    public Scientist(String name) {
        // stats are the exact same as in the plan
        super(name, 2, 0, 8, 25);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        int energy = this.getEnergy();
        if (energy >= 5) {
            // formula: scientific ability (8) + (experience / 2.0)
            double progress = 8.0 + (this.getExperience() / 2.0);

            // placeholder for MissionControl integration
            // MissionControl.updateCureProgress((int) progress);

            this.setEnergy(energy - 5);
            this.addExperience(5);

            return (int) progress;
        }

        return 0;
    }
}