package com.ecomoderservice.entity;

public class Customer {
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerGender;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String country;
    private Long mobileNumber;

    public Customer() {
    }

    public Customer(Long customerId, String customerFirstName, String customerLastName, String customerEmail, Long customerMobileNumber) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.mobileNumber = customerMobileNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Long getCustomerMobileNumber() {
        return mobileNumber;
    }

    public void setCustomerMobileNumber(Long customerMobileNumber) {
        this.mobileNumber = customerMobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerMobileNumber=" + mobileNumber +
                '}';
    }
}
