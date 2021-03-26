package com.company.data;

public class Republic extends State {
    protected int years;
    public Republic( String title, float area,float population,int years,int liveLihood){
        this.title=title;
        this.area=area;
        this.population=population;
        this.years=years;
        this.liveLihood=liveLihood;
    }

    public  int getYears() {
        return years;
    }

    @Override
    public String Info() {
        StringBuilder rezult=new StringBuilder("");
        rezult.append("Госудастрво: "+this.title+";  ");
        rezult.append("Тип правления: Республика;  ");
        rezult.append("Срок смены власти: "+this.years+";  ");
        rezult.append("Площадь: "+this.area+"км^2;  ");
        rezult.append("Население: "+this.population+"млн. человек;  ");
        rezult.append("Уровень жизни: "+this.liveLihood+"%;  ");
        return rezult.toString();
    }
}