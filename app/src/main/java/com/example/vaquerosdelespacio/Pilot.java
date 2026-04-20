package com.example.vaquerosdelespacio;

public class Pilot extends CrewMember {
    // super here means it'll send the specific pilot stats to the parent
    public Pilot(String name) {
        // stats are the exact same as in the plan
        super(name, 5, 5, 0, 20);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        int energy = this.getEnergy();
        if (energy >= 3) {
            // formula: technical skills (5) * 0.1
            double efficiencyBonus = 5 * 0.1;

            // cap at +2.0 to prevent runaway stacking
            efficiencyBonus = Math.min(efficiencyBonus, 2.0);

            // placeholder for MissionControl integration
            // MissionControl.applyFuelEfficiency(efficiencyBonus);

            this.setEnergy(energy - 3);
            this.addExperience(10);

            return (int) (efficiencyBonus * 10); // scaling for int return
        }

        return 0;
    }
}