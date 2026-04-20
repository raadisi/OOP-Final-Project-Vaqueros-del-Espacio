package com.example.vaquerosdelespacio;

public class Engineer extends CrewMember{
    // super here means it'll send the specific engi stats to the parent
    public Engineer(String name) {
        // stats are the exact same as in the plan
        super(name, 5, 1, 10, 20);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        int energy = this.getEnergy();
        if (energy >= 4) {
            // formula: technical skills (10) * 2
            int repairAmount = 10 * 2;

            // placeholder for MissionControl integration
            // MissionControl.repairShip(repairAmount);

            this.setEnergy(energy - 4);
            this.addExperience(4);

            return repairAmount;
        }

        return 0;
    }
}