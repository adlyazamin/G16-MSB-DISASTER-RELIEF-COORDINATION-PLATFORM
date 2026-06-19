package dao;

import model.Resource;
import util.ResourceDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResourceDAO {

    public boolean addResource(Resource resource){

        String sql = "INSERT INTO resources(resource_name, quantity, location, status) VALUES(?,?,?,?)";

        try{

            Connection conn = ResourceDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, resource.getResourceName());
            ps.setInt(2, resource.getQuantity());
            ps.setString(3, resource.getLocation());
            ps.setString(4, resource.getStatus());

            int row = ps.executeUpdate();

            return row > 0;

        }catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    public List<Resource> getAllResources(){

        List<Resource> resources = new ArrayList<>();

        String sql = "SELECT * FROM resources";

        try{

            Connection conn = ResourceDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Resource resource = new Resource();

                resource.setResourceId(rs.getInt("resource_id"));
                resource.setResourceName(rs.getString("resource_name"));
                resource.setQuantity(rs.getInt("quantity"));
                resource.setLocation(rs.getString("location"));
                resource.setStatus(rs.getString("status"));

                resources.add(resource);

            }

        }catch(SQLException e){

            e.printStackTrace();

        }

        return resources;

    }

}