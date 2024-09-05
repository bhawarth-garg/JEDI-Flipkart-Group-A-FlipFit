package com.flipkart.client;

import java.util.List;

public class GymFlipFitAdminMenu {

    public void viewGyms() {

    }

    public void viewUsers() {

    }

    public void viewGymOwners() {
    }

    public void verifyGym(int id) {

    }


    public void verifyGymOwner(int id) {

    }


    public void viewUnverifiedGyms() {

        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format("+-------+----------------------+-------+------------------------------------------+----------------------+------------------+\n");
        System.out.format("| Gym   |     Name             | Gym Id|           Address                        |   Location           |     Status       |\n");
        System.out.format("+-------+----------------------+-------+------------------------------------------+----------------------+------------------+\n");

        System.out.format("-------------------------------------------------------------------\n");

    }


    public void viewUnverifiedGymOwners() {
//
    }
}