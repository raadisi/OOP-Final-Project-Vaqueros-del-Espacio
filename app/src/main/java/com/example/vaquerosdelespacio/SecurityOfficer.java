package com.example.vaquerosdelespacio;

public class SecurityOfficer extends CrewMember {
    // super here means it'll send the specific security stats to the parent
    public SecurityOfficer(String name) {
        // stats are the exact same as in the plan
        super(name, 10, 10, 0, 10);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        int energy = this.getEnergy();
        if (energy >= 2) {
            // formula: combat skill (10)
            int damageDealt = 10;

            // placeholder for MissionControl integration
            // Threat target = MissionControl.getCurrentThreat();
            // if (target != null) { target.reduceHealth(damageDealt); }

            this.setEnergy(energy - 2);
            this.addExperience(3);

            return damageDealt;
        }

        return 0;
    }
}