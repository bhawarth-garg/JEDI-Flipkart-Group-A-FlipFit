package com.flipkart.client;


import java.util.*;
import com.flipkart.bean.*;
import java.util.Scanner;

/*
 * This class represents the customer menu for the GymFlipFit application
 * It provides various functions for customer actions such as viewing gyms, booking slots, and managing bookings.
 */
public class GymFlipFitCustomerMenu {
    static Scanner obj = new Scanner(System.in);
//    FlipFitUserServiceOperations userServiceOperation = new FlipFitUserServiceOperations();
    FlipFitUser flipFitUser = new FlipFitUser();



    public boolean userLogin(String username, String pass) {
        if (validateUser(username, pass)) {
            boolean flag = true;
            System.out.println("Login Successful\n");

            while (flag) {
                System.out.println("*********CUSTOMER MENU*********\n");
                System.out.println("Press 1 to Book your slot");
                System.out.println("Press 2 to View all available gyms with slots");
                System.out.println("Press 3 to View all your bookings");
                System.out.println("Press 4 to Cancel your slot");
                System.out.println("Press 5 to Logout");
                int choice = Integer.parseInt(obj.nextLine());
                switch (choice) {

                    case 1:
                        List<FlipFitGym> gyms1 = viewAllGymswithSlots();
                        printGyms(gyms1);
                        System.out.println("Enter the following:");
                        System.out.println("Gym ID");
                        int gymId = Integer.parseInt(obj.nextLine());
                        System.out.println("Slot Time");
                        int time = Integer.parseInt(obj.nextLine());

                        if (bookSlot(gymId, time, username)) {
                            System.out.println("Booked Successfully");
                        } else {
                            System.out.println("Booking Unsuccessful");
                        }
                        break;

                    case 2:
                        List<FlipFitGym> flipFitGyms = viewAllGymswithSlots();
                        printGyms(flipFitGyms);
                        break;
                    case 3:
                        System.out.println("My Bookings");
                        List<FlipFitBookings> flipFitBookings = viewAllBookings(username);
                        for (FlipFitBookings booking : flipFitBookings) {
                            System.out.println("Booking ID: " + booking.getBookingId() + " Booking Status: " + booking.getStatus() + " Time: " + booking.getTime() + " GymID: " + booking.getGymId());
                        }
                        break;

                    case 4:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("My Bookings");
                        System.out.println(viewAllBookings(username));
                        System.out.println("Enter Booking ID");
                        int bookingId = sc.nextInt();
                        cancelSlot(bookingId);
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong Choice");
                }
            }

        } else return false;
        return true;
    }

    /*
     *Print the lists of gym
     */
    private void printGyms(List<FlipFitGym> y) {
        for (FlipFitGym flipFitGym : y) {
            System.out.println("====================");
            System.out.println("Gym name: " + flipFitGym.getGymName() + " Gym ID: " + flipFitGym.getGymId() + " Gym Location: " + flipFitGym.getLocation() + " Gym Address: " + flipFitGym.getGymAddress());
            System.out.println("Slot List");
            String leftAlignFormat = "| %-15d | %-15d | %-20d |%n";
            System.out.format("+-----------------+-----------------+----------------------+\n");
            System.out.format("| Start Time      |   End Time      | Remaining Seats      |\n");
            System.out.format("+-----------------+-----------------+----------------------+\n");

            for (FlipFitSlots slot : flipFitGym.getSlots()) {
                System.out.format(leftAlignFormat,slot.getStartTime(),(slot.getStartTime() + 1),slot.getSeatCount());
            }
            System.out.format("+-----------------+-----------------+----------------------+\n");

        }
    }


    public boolean validateUser(String username, String pass) {
        return true;
    }

    List<FlipFitGym> viewAllGymswithSlots() {
        System.out.println("List of Gyms");
        List<FlipFitGym> gymList = Collections.<FlipFitGym>emptyList();
        return gymList;
    }


    public boolean bookSlot(int gymId, int time, String email) {
//        return userServiceOperation.bookSlots(gymId, time, email);
        return true;
    }


    public void cancelSlot(int bookingId) {
        System.out.println("Slot Cancelled");
    }


    public List<FlipFitBookings> viewAllBookings(String userid) {
        List<FlipFitBookings> myBookings=  Collections.<FlipFitBookings>emptyList();
        return myBookings;
    }

    /*/
     * Create a new customer user.
     */
    public void createCustomer() {
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nEnter Address ");
        String nationalId = obj.nextLine();
        System.out.println("\nLocation: ");
        String GST = obj.nextLine();

        FlipFitUser flipFitUser = new FlipFitUser();
        flipFitUser.setEmail(ownerEmail);
        flipFitUser.setAddress(nationalId);
        flipFitUser.setLocation(GST);
        flipFitUser.setPassword(password);
        flipFitUser.setUserName(ownerName);
        flipFitUser.setPhoneNumber(phoneNo);

//        userServiceOperation.createUser(flipFitUser);
    }
}