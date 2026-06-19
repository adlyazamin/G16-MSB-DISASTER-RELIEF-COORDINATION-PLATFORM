package service;

import dao.TaskDAO;
import model.Task;
import java.util.List;

public class TaskService {

    private TaskDAO taskDAO = new TaskDAO();

    public boolean createTask(Task task){

        return taskDAO.createTask(task);

    }

    public List<Task> getAvailableTasks(){

        return taskDAO.getAvailableTasks();

    }
    
    public boolean acceptTask(int taskId, int volunteerId){

    return taskDAO.acceptTask(taskId, volunteerId);

}
    public int getReportIdByTaskId(int taskId){

    return taskDAO.getReportIdByTaskId(taskId);

}

}