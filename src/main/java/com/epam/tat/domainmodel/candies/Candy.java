package com.epam.tat.domainmodel.candies;


public class Candy extends CandyBase {
    private String name;
    private int weight;

    public Candy(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {return name;}

    @Override
    public void setName(String name) {this.name = name;}

    @Override
    public int getWeight() {return  weight;}

    @Override
    public void setWeight(int weight) {this.weight = weight;}
}
