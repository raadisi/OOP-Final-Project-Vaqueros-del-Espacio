package com.example.vaquerosdelespacio;
import java.util.ArrayList;

public class Storage {
    // one single instance, existing throughout the entire app life
    private static Storage instance;

    // a list of all our crew members
    private ArrayList<CrewMember> crewList = new ArrayList<>();

    private Storage(){} // private to prevent other classes from accessing it

    public static synchronized Storage getInstance(){
        if (instance == null){
            instance = new Storage();
        }
        return instance;
    }

    // welcome to methodland
    // to add a new crew member
    public void addCrew(CrewMember member){
        crewList.add(member);
    }

    // to get the whole list (for the recyclerview)
    public ArrayList<CrewMember> getCrewList() {
        return crewList;
    }

    // if they die
    public void removeDeadCrew(){
        crewList.removeIf(member -> member.getEnergy() <= 0);
    }
}
