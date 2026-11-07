package com.telusko.RestAPIUsingDatabase;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Path("RestUsers")
public class deleteUsers {

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public String deleteUser(@PathParam("id") int id){
        return deleteUserFromDatabase(id);
    }

    public String deleteUserFromDatabase(int id){
        String str = "";
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try{
            connect = jdbcUtil.getConnection();

            String query = "Delete from restapiusers where id = ?";
            preparedStatement = connect.prepareStatement(query);

            preparedStatement.setInt(1,id);

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0) str = "Unable to Delete document";
            else str = "Document Deleted successfully";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return str;
    }
}
