package com.telusko.jerseyAPI;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    List<Alien> alienList;

    public AlienRepository(){
        alienList = new ArrayList<>();

        Alien a1 = new Alien();

        a1.setName("Zymshan");
        a1.setPoints(20);

        Alien a2 = new Alien();

        a2.setName("Virat Kohli");
        a2.setPoints(30);

        alienList.add(a1);
        alienList.add(a2);
    }

    public List<Alien> listOfAliens(){
        return alienList;
    }

    public Alien getAlien(String alienName){
        //Alien result;

        for(Alien a1 : alienList){
            if(a1.getName().equalsIgnoreCase(alienName)) return a1;
        }

        return null;
    }

    public void createAlien(Alien a1) {
        alienList.add(a1);
    }
}
