package dao;

import model.Task;
import util.VolunteerDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public List<Task> getAvailableTasks(){

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks WHERE task_status='Available'";

        try{

            Connection conn = VolunteerDBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Task task = new Task();

                task.setTaskId(rs.getInt("task_id"));
                task.setReportId(rs.getInt("report_id"));
                task.setVolunteerId(rs.getInt("volunteer_id"));
                task.setTaskDescription(rs.getString("task_description"));
                task.setTaskStatus(rs.getString("task_status"));

                tasks.add(task);

            }

        }catch(SQLException e){

            e.printStackTrace();

        }

        return tasks;

    }
    
    public boolean createTask(Task task){

    String sql = "INSERT INTO tasks(report_id, volunteer_id, task_description, task_status) VALUES(?,?,?,?)";

    try{

        Connection conn = VolunteerDBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, task.getReportId());

        ps.setInt(2, 0); // 0 = no volunteer assigned yet

        ps.setString(3, task.getTaskDescription());

        ps.setString(4, "Available");

        int row = ps.executeUpdate();

        return row > 0;

    }catch(SQLException e){

        e.printStackTrace();

    }

    return false;

}
    public boolean acceptTask(int taskId, int volunteerId){

    String sql = "UPDATE tasks SET volunteer_id=?, task_status='Accepted' WHERE task_id=?";

    try{

        Connection conn = VolunteerDBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, volunteerId);
        ps.setInt(2, taskId);

        int row = ps.executeUpdate();

        return row > 0;

    }catch(SQLException e){

        e.printStackTrace();

    }

    return false;

}
    public int getReportIdByTaskId(int taskId){

    String sql = "SELECT report_id FROM tasks WHERE task_id=?";

    try{

        Connection conn = VolunteerDBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, taskId);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            return rs.getInt("report_id");

        }

    }catch(SQLException e){

        e.printStackTrace();

    }

    return -1;

}
   

}