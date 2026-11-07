package com.telusko.RestAPIUsingDatabase;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Path("RestUsers")
public class createUsers {

    @POST
    @Path("createUsers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestUsers createUsers(RestUsers r1){
        System.out.println("Here -->>>");
        createUserinDatabase(r1);
        return r1;
    }

    public void createUserinDatabase(RestUsers r1){
         Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try{
            connect = jdbcUtil.getConnection();

            String query ="Insert into RestAPIUsers(id,name,age,points) Values(?,?,?,?)";

            preparedStatement = connect.prepareStatement(query);

            preparedStatement.setInt(1,r1.getId());
            preparedStatement.setString(2,r1.getName());
            preparedStatement.setInt(3,r1.getAge());
            preparedStatement.setInt(4,r1.getPoints());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0) System.out.println("Error in Query Execution");
            else System.out.println("Query Executed Successfully");



        }
        catch(Exception e){
            System.out.println("Exception occured {}" +  e);
        }

        finally {

            try {
                jdbcUtil.closeConncetion(connect, preparedStatement);
            }
            catch(Exception e){
                System.out.println("Exceptionoccured" + e.getMessage());
            }
        }
    }
}
