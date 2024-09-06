package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import com.flipkart.bean.FlipFitAdmin;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

//import com.flipkart.dao.FlipFitAdminDAOImpl;
//import com.flipkart.dao.FlipFitAdminDAOInterface;

/**
 * Implementation of FlipFitAdminService for administrative operations.
 */
public class FlipFitAdminServiceOperation implements FlipFitAdminService {

   ArrayList<FlipFitAdmin> Admins;

   FlipFitGymOwnerServiceOperation GymOwnersList;
   public FlipFitUserServiceOperations customerList;

    FlipFitAdmin admin1 ;
    FlipFitAdmin admin2 ;

    public void CreateLists()
    {
        System.out.println("Admin Instance Created");
        Admins= new ArrayList<FlipFitAdmin>();

        GymOwnersList= new FlipFitGymOwnerServiceOperation();
        GymOwnersList.CreateLists();
        customerList= new FlipFitUserServiceOperations();
        customerList.CreateInstance();

        admin1 = new FlipFitAdmin();
        admin2 = new FlipFitAdmin();
    }

   public void Create()
   {
       admin1.setAdminId("gargbahwarth@gmail.com");
       admin1.setPassword("qwerty");
       admin2.setAdminId("abc@gmail.com");
       admin2.setPassword("123456");
       Admins.add(admin1);
       Admins.add(admin2);

//       System.out.println("Admin Created Successfully"+Admins.get(0).getAdminId()+" "+ Admins.get(0).getPassword()+"      "+ Admins.get(1).getAdminId()+" "+Admins.get(1).getPassword());
   }

    public boolean validateAdmin(String Id, String pass){
        System.out.println("Validating Admin"+ Admins.size());
        for (FlipFitAdmin admin : Admins) {
            System.out.println("Validating Admin");
            if (Objects.equals(Id, admin.getAdminId()) && Objects.equals(pass, admin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // Scanner object for user input
    Scanner obj = new Scanner(System.in);

    @Override
    public void viewGymOwners() {
        int x=1;
        for(FlipFitGymOwner owner: GymOwnersList.GymOwners)
        {
            System.out.println("Owner"+x+": ");
            System.out.println("OwnerName:"+owner.getOwnerName());
            System.out.println("OwnerId: "+owner.getOwnerId());
            System.out.println("OwnerPassword:"+ owner.getPassword());
            System.out.println("OwnerPANDetails: "+owner.getPAN());
            System.out.println("-----*---------*-----------");
            x++;
        }
    }

    @Override
    public void viewGyms() {
        int x=1;
        for(FlipFitGym gym: GymOwnersList.Gyms)
        {
            System.out.println("Gym"+x+": ");
            System.out.println("GymName:"+gym.getGymName());
            System.out.println("GymId: "+gym.getGymId());
            System.out.println("GymLocation: "+gym.getLocation());
            System.out.println("GymAddress: "+gym.getGymAddress());
            System.out.println("GymOwnerEmail:"+gym.getOwnerId());
            System.out.println("GymStatus: "+gym.getStatus());
            System.out.println("Available Slots: "+gym.getSlots());
            System.out.println("-----*---------*-----------");
            x++;
        }
    }

    @Override
    public void viewUsers() {

        for(FlipFitUser customer: customerList.customers)
        {

            System.out.println("UserName:"+customer.getUserName());
            System.out.println("UserId: "+customer.getuserId());
            System.out.println("UserLocation: "+customer.getLocation());
            System.out.println("GymAddress: "+customer.getAddress());
            System.out.println("GymOwnerEmail:"+customer.getEmail());
            System.out.println("GymPassword: "+ customer.getPassword());
            System.out.println("User Contact Details "+ customer.getPhoneNumber());
            System.out.println("-----*---------*-----------");

        }

    }

    @Override
    public void verifyGym(String gymId) {
        for(FlipFitGym gym: GymOwnersList.Gyms)
        {
            if(Objects.equals(gym.getGymId(), gymId))
            {
                gym.setStatus("Verified Gym");
                break;
            }
        }
    }

    @Override
    public void verifyGymOwner(String gymOwnerId) {
        for(FlipFitGymOwner owner: GymOwnersList.GymOwners)
        {
            if(Objects.equals(owner.getOwnerId(), gymOwnerId)) {
                owner.setStatus("Verified Gym Owner");
                break;
            }
        }
    }

    @Override
    public List<FlipFitGymOwner> getUnverifiedGymOwners() {
        ArrayList<FlipFitGymOwner> UnverifiedOwners= new ArrayList<FlipFitGymOwner>();
        for(FlipFitGymOwner owner: GymOwnersList.GymOwners)
        {
           if(Objects.equals(owner.getStatus(), "Unverified"))
           {
               UnverifiedOwners.add(owner);
           }
        }
        return UnverifiedOwners;
    }

    @Override
    public List<FlipFitGym> getUnverifiedGyms() {
        ArrayList<FlipFitGym> UnverifiedGyms= new ArrayList<FlipFitGym>();
        for(FlipFitGym gym: GymOwnersList.Gyms)
        {
            if(Objects.equals(gym.getStatus(), "Unverified"))
            {
                UnverifiedGyms.add(gym);
            }
        }
        return UnverifiedGyms;
    }
}