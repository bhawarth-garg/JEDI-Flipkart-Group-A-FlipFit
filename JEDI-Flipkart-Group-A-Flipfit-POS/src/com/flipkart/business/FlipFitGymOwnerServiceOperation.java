
package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
//import com.flipkart.dao.FlipfitGymOwnerDAOImpl;
//import com.flipkart.dao.FlipFitGymOwnerDAOInterface;
//import com.flipkart.dao.UpdatePasswordDAOImpl;
//import com.flipkart.dao.UpdatePasswordDAOInterface;

/**
 * Implementation of FlipFitGymOwnerService for managing gym owners.
 */
public class FlipFitGymOwnerServiceOperation implements FlipFitGymOwnerService {


    ArrayList<FlipFitGymOwner> GymOwners;
    ArrayList<FlipFitGym> Gyms;
    // HashMap to store gym owners
    HashMap<String, FlipFitGym> GymsOwnedByFlipFitGymOwner ;

    // Scanner object for user input
    Scanner obj = new Scanner(System.in);

    int id; // ID tracker (not used in current implementation)

    public void CreateLists()
    {
        System.out.println("Gym Owner Instance Created");
        GymOwners= new ArrayList<FlipFitGymOwner>();
        Gyms= new ArrayList<FlipFitGym>();
        // HashMap to store gym owners
        GymsOwnedByFlipFitGymOwner = new HashMap<>();

        id = 0; // ID tracker (not used in current implementation)
    }
    @Override
    public void addGymWithSlots(FlipFitGym flipFitGym) {
        Gyms.add(flipFitGym);
        for(FlipFitGymOwner owner: GymOwners)
        {
            if(Objects.equals(owner.getOwnerId(), flipFitGym.getOwnerId()))
            {
                List<FlipFitGym> OwnerSpecific= owner.getGyms();
                OwnerSpecific.add(flipFitGym);
                owner.setGyms(OwnerSpecific);
            }
        }

    }

    @Override
    public List<FlipFitGym> viewMyGyms(String ownerId) {

        for(FlipFitGymOwner owner: GymOwners)
        {
            if(Objects.equals(owner.getOwnerId(), ownerId))
            {
                return owner.getGyms();
            }
        }

        return Collections.emptyList();

    }

    @Override
    public boolean validateLogin(String email, String password) {
        for(FlipFitGymOwner owner: GymOwners)
        {
            if(Objects.equals(owner.getOwnerId(), email) && Objects.equals(owner.getPassword(), password))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createGymOwner(FlipFitGymOwner flipFitGymOwner) {
        GymOwners.add(flipFitGymOwner);
    }

    @Override
    public boolean verifyGymOwnerPassword(String email, String password) {

        return true;

    }

    @Override
    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {

        for(FlipFitGymOwner owner: GymOwners)
        {
            if(Objects.equals(owner.getOwnerId(), email) && Objects.equals(owner.getPassword(), password))
            {
                owner.setPassword(updatedPassword);
            }
        }

    }

}
