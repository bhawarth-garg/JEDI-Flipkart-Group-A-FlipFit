package com.flipkart.bean;
import java.util.List;

public class FlipFitGymOwner {
    private int ownerId;
    private String ownerEmail;
    private String password;
    private String phoneNo;
    private String nationalId;
    private List<FlipFitGym> flipFitGyms;
    private String PAN;

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }



    public List<FlipFitGym> getFlipFitGyms() {
        return flipFitGyms;
    }

    public void setFlipFitGyms(List<FlipFitGym> flipFitGyms) {
        this.flipFitGyms = flipFitGyms;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    private String ownerName;
    private String status;
    private String verificationStatus;

}
