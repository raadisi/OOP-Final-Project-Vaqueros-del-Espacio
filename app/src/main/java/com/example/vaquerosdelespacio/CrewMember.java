package com.example.vaquerosdelespacio;

public abstract class CrewMember {
    // we protect the strings so that the child objects don't need to use a bunch of extra setter methods
    protected String name;
    protected int combatSkill;
    protected int scientificAbility;
    protected int technicalSkills;
    protected int energy;
    protected int maxEnergy;
    protected int experience;

    // this is the constructor, it runs when a child class is created
    public CrewMember(String name, int combat, int science, int tech, int energy){
        this.name = name;
        this.combatSkill = combat;
        this.scientificAbility = science;
        this.technicalSkills = tech;
        this.energy = energy;
        this.maxEnergy = energy;
        this.experience = 0;
    }

    // this is polymorphism, as 'act' means a different thing to each crew member
    public abstract int act();

    // as all crewmembers take damage teh same way, this can be put here in the parent class
    public void defend(int damage){
        this.energy -= damage;
        if (this.energy < 0){
            this.energy = 0; // here to make sure that energy cannot go negative
        }
    }

    // all crewmembers can use this in the Quarters (yay)
    public void restoreEnergy(){
        this.energy = this.maxEnergy;
    }

    // getters
    public String getName(){
        return name;
    }
    public int getEnergy(){
        return energy;
    }
    public int getExperience(){
        return experience;
    }

    // experience system, same for all crewmembers
    public void addExperience(int amount){
        this.experience += amount;
        // for later... maybe; we can make leveling up have advantages by coding those in here
    }
}
