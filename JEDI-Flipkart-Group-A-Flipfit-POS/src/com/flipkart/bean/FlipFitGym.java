package com.flipkart.bean;
import java.util.List;

public class FlipFitGym {
    private int gymId;
    private String gymName;
    private String gymAddress;
    private String location;
    private List<FlipFitSlots> flipFitSlots;
    private String ownerId;
    private String status;

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<FlipFitSlots> getFlipFitSlots() {
        return flipFitSlots;
    }

    public void setFlipFitSlots(List<FlipFitSlots> flipFitSlots) {
        this.flipFitSlots = flipFitSlots;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
