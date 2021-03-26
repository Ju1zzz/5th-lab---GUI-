package com.company.data;

import java.util.ArrayList;

public class Federation {
    private ArrayList<State> states = new ArrayList<>();
    public Federation(){
        states.add(new Republic("Germany",200000,5 ,6,50));
        states.add(new Republic("Italy",20001,10,4,70));
        states.add(new Monarchy("Turkey" ,20145,12,"Unknown",80));
        states.add(new Monarchy("United Kingdom" ,2605119,21,"Queen Elizabeth",90));
        states.add(new Republic("Cyprus",9251,2, 5, 72));
    }

    public void add(State state) {
        this.states.add(state);
    }
    public void remove(int id){
        this.states.remove(id);
    }
    public int size() {
        return this.states.size();
    }
    public State get(int id) {
        return states.get(id);
    }
    public State set(int id,State state) {
        return states.set(id,state);
    }
}
