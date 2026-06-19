package service;

import dao.ResourceDAO;
import model.Resource;
import java.util.List;

public class ResourceService {

    private ResourceDAO resourceDAO = new ResourceDAO();

    // Add Resource
    public boolean addResource(Resource resource) {

        return resourceDAO.addResource(resource);

    }

    // View All Resources
    public List<Resource> getAllResources() {

        return resourceDAO.getAllResources();

    }

}