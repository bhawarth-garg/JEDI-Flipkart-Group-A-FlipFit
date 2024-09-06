package com.flipkart.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.flipkart.bean.FlipFitBookings;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.bean.FlipFitUser;

/**
 * Implementation of user-related operations for FlipFit application.
 */
public class FlipFitUserServiceOperations implements FlipFitUserServices {

   ArrayList<FlipFitUser> customers;
   ArrayList<FlipFitBookings> bookings;

    FlipFitGymOwnerServiceOperation GymOwnersList;

    public void CreateInstance()
    {
        System.out.println("Customer Instance Created");
        customers= new ArrayList<FlipFitUser>();
        bookings= new ArrayList<FlipFitBookings>();

        GymOwnersList= new FlipFitGymOwnerServiceOperation();

    }
    @Override
    public boolean validateUser(String email, String password) {
        System.out.println("Customers: "+customers+"  "+customers.size());
        for(FlipFitUser customer:customers )
        {
            if(Objects.equals(customer.getPassword(), password) && Objects.equals(customer.getEmail(), email))
                return true;
        }
        return false;
    }

    @Override
    public boolean cancelSlots(int bookingId) {

        String GymOfCancellation="";
        String SlotId= "";
        for(FlipFitBookings booking: bookings)
        {
            if(booking.getBookingId()==bookingId) {
                GymOfCancellation = booking.getGymId();
                SlotId= booking.getSlotId();
                booking.setBookingStatus("Cancelled");
                booking.setSlotId("N/A");
                break;
            }
        }
        for(FlipFitGym gym: GymOwnersList.Gyms)
        {
            if(!GymOfCancellation.isEmpty() && !SlotId.isEmpty() && gym.getGymId()==GymOfCancellation)
            {
                for(FlipFitSlots slot: gym.getSlots())
                {
                    if(Objects.equals(slot.getSlotsId(), SlotId))
                        return true;
                }
            }
        }
        return false;

    }

    @Override
    public List<FlipFitBookings> getAllBookings(String userId) {
       ArrayList<FlipFitBookings> UserSpecificBookings= new ArrayList<FlipFitBookings>();
       for(FlipFitBookings UserBooking: bookings)
       {
           if(Objects.equals(UserBooking.getUserId(), userId))
           {
               UserSpecificBookings.add(UserBooking);
           }
       }
       return UserSpecificBookings;
    }

    @Override
    public List<FlipFitGym> getAllGymsWithSlots() {
       ArrayList<FlipFitGym> AvailableGyms= new ArrayList<FlipFitGym>();

       for(FlipFitGym gym: GymOwnersList.Gyms)
       {
           for(FlipFitSlots slot: gym.getSlots())
           {
               if(slot.getSeatCount()>0) {
                   AvailableGyms.add(gym);
                   break;
               }
           }
       }

       return AvailableGyms;
    }

    @Override
    public boolean bookSlots(String gymId, int time, String email) {
        FlipFitBookings new_booking= new FlipFitBookings(), lastbooking;
        int id= 1;

        if(!bookings.isEmpty())
        {
            lastbooking= bookings.get(bookings.size()-1);
            id= lastbooking.getBookingId()+1;
        }

        for(FlipFitGym gym: GymOwnersList.Gyms)
        {
            if(Objects.equals(gym.getGymId(), gymId))
            {
                for(FlipFitSlots slot: gym.getSlots())
                {
                    if(slot.getStartTime()==time && slot.getSeatCount()>0)
                    {
                        new_booking.setBookingStatus("Booked");
                        new_booking.setGymId(gymId);
                        new_booking.setBookingId(id);
                        new_booking.setSlotId(slot.getSlotsId());
                        new_booking.setUserId(email);
                        new_booking.setTime(time);
                        new_booking.setCreatedAt(time);
                        new_booking.setStatus("Booked Successfully");
                        bookings.add(new_booking);
                        return true;

                    }
                }
            }
        }
        return false;
    }


    @Override
    public void createUser(FlipFitUser flipFitUser) {
        customers.add(flipFitUser);

    }

    @Override
    public void updateGymUserPassword(String email, String password, String updatedPassword) {

        for(FlipFitUser customer: customers)
        {
            if(Objects.equals(customer.getEmail(), email) && Objects.equals(customer.getPassword(), password))
            {
                customer.setPassword(updatedPassword);
                break;
            }
        }
    }

}