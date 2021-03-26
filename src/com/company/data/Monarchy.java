package com.company.data;

public class Monarchy extends State {
    protected String nameBoss;
    public Monarchy( String title,float area,float population,String nameBoss,int liveLihood){
        this.title =title;
        this.area=area;
        this.population=population;
        this.nameBoss=nameBoss;
        this.liveLihood=liveLihood;
    }

    public String getNameBoss() {
        return nameBoss;
    }

    @Override
    public String Info() {
        StringBuilder rezult=new StringBuilder("");
        rezult.append("Госудастрво: "+this.title+";  ");
        rezult.append("Тип правления: Монархия;  ");
        rezult.append("Имя правителя: "+this.nameBoss+";  ");
        rezult.append("Площадь: "+this.area+" км^2;");
        rezult.append("Население: "+this.population+"млн. человек; ");
        rezult.append("Уровень жизни: "+this.liveLihood+"%;  ");
        return rezult.toString();
    }

}
