package com.telusko.RestAPIUsingDatabase;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Path("RestUsers")
public class ShowUsers {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RestUsers> getUsers(){
        List<RestUsers> userList = new ArrayList<>();
        userList = getUserFromDatabase();
        return userList;
    }

    public List<RestUsers> getUserFromDatabase(){
        List<RestUsers> list = new ArrayList<>();
        RestUsers r1;
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try{
            connect = jdbcUtil.getConnection();
            String query = "Select * from restapiusers";
            preparedStatement = connect.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
              r1 = new RestUsers();
              r1.setId(rs.getInt(1));
              r1.setName(rs.getString(2));
              r1.setAge(rs.getInt(3));
              r1.setPoints(rs.getInt(4));

              list.add(r1);
            }
        }
        catch (Exception e){
            System.out.println("Exception occured : "+e);
        }
        finally {
            try{
                jdbcUtil.closeConncetion(connect,preparedStatement);
            } catch (Exception e) {
                System.out.println("Exception occured :" + e.getMessage());
            }
        }


        return list;
    }
}
