package com.telusko.RestAPIUsingDatabase;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Path("RestUsers")
public class updateUsers {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public String updateResource(@PathParam("id") int id, RestUsers r1){
        return updateUserFromDatabase(id, r1);
    }

    public String updateUserFromDatabase(int id, RestUsers r1){
        String str = "";

        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try{
            //System.out.println(r1.getAge());
            String name = r1.getName();

            connect = jdbcUtil.getConnection();

            String query = "Update restapiusers set name = ? where id = ?";
            preparedStatement =connect.prepareStatement(query);

             preparedStatement.setString(1,name);
             preparedStatement.setInt(2,id);

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0) str = "Unable to update Document";
            else str = "Document updated successfully";




        }
        catch(Exception e){
            System.out.println("Exception occured : "+e);
        }

        finally {
            try {
                jdbcUtil.closeConncetion(connect, preparedStatement);
            } catch (Exception e) {
                System.out.println("Exception occured :" + e.getMessage());
            }
        }
        return str;
    }
}
