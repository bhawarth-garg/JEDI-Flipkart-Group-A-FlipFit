package com.flipkart.business;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

/**
 * Interface defining operations for FlipFit admin service.
 */
public interface FlipFitAdminService {

    public void CreateLists();
    public void Create();
    public void viewGymOwners();


    public void viewGyms();

    public void viewUsers();


    public void verifyGym(String gymId);
    public boolean validateAdmin(String Id, String pass);


    public void verifyGymOwner(String gymOwnerId);

    public List<FlipFitGymOwner> getUnverifiedGymOwners();


    public List<FlipFitGym> getUnverifiedGyms();
}