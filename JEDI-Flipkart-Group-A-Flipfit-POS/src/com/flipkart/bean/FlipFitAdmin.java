
package com.flipkart.bean;

/* This class represents a FlipFit admin with adminId and password attributes. */
public class FlipFitAdmin {
    private String adminId; /* Stores the unique identifier for the admin. */
    private String password; /* Stores the password associated with the admin account. */

    /* Getter method for retrieving the adminId. */
    public String getAdminId() {
        return adminId;
    }

    /* Setter method for setting the adminId. */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /* Getter method for retrieving the password. */
    public String getPassword() {
        return password;
    }

    /* Setter method for setting the password. */
    public void setPassword(String password) {
        this.password = password;
    }
}