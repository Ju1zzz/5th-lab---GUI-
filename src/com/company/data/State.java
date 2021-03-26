package com.company.data;

public abstract class State {
    protected String title;
    protected int id;
    protected float area;
    protected float population;
    protected int liveLihood;
    public abstract String Info();
    private static int count=1;
    public State(){
        this.id=count;
        count++;
    }

    public int getLiveLihood() {
        return liveLihood;
    }

    public float getPopulation() {
        return population;
    }

    public int getId() {
        return id;
    }

    public float getArea() {
        return area;
    }

    public String getTitle() {
        return title;
    }

}
