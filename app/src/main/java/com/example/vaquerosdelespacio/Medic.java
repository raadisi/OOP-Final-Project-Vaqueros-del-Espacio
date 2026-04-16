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

        // this return value is a placeholder
        return 0;
    }
}
