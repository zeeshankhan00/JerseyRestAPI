package com.telusko.jerseyAPI;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();
    @GET
    //@Produces(MediaType.APPLICATION_XML)
   // @Produces(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Alien> getAlien(){

        System.out.println("Entering into getAlien");
        return repo.listOfAliens();
    }

    @GET
   // @Produces(MediaType.APPLICATION_XML)
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Path("alien/{name}")
    public Alien getAlien(@PathParam("name") String name){

        return repo.getAlien(name);
    }

    @POST
    @Path("createAlien")
    public Alien createALien(Alien a1){

        System.out.println(a1);
        repo.createAlien(a1);
//       List<Alien> aliens = repo.alienList;
//       repo.getAlien(aliens);
        return a1;
    }
}
