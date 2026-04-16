package com.example.vaquerosdelespacio;

public class Pilot extends CrewMember {
    // super here means it'll send the specific pilot stats to the parent
    public Pilot(String name) {
        // stats are the exact same as in the plan
        super(name, 6, 2, 8, 10);
    }

    @Override
    public int act() {
        // hi calu you've got this one
        // remember to refer to the doc sent way up at the start of the whatsapp group for stats

        // this return value is a placeholder
        return 0;
    }
}
