package com.flipkart.business;

import java.util.List;
import com.flipkart.bean.FlipFitBookings;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitUser;

/**
 * Interface for FlipFit user-related services.
 */
public interface FlipFitUserServices {


    boolean cancelSlots(int slotId);


    List<FlipFitBookings> getAllBookings(String userId);


    List<FlipFitGym> getAllGymsWithSlots();


    boolean bookSlots(int gymId, int time, String email);


    boolean validateUser(String username, String pass);


    void createUser(FlipFitUser flipFitUser);


    boolean verifyGymUserPassword(String email, String password, String updatedPassword);


    void updateGymUserPassword(String email, String password, String updatedPassword);
}