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

        // this return value is a placeholder
        return 0;
    }
}
