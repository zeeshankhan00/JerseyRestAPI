package com.telusko.jerseyAPI;


import jakarta.xml.bind.annotation.XmlRootElement;
import org.glassfish.jersey.server.JSONP;

@XmlRootElement
public class Alien {

    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
