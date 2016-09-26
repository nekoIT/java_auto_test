package ru.autoqa.addressbook.model;

public class ContactData {
    private final String testFirstName;
    private final String testLastName;
    private final String testMiddleName;
    private final String testAddressString;
    private final String mobilePhone;
    private final String email;
    private final String year;

    public ContactData(String testFirstName, String testLastName, String testMiddleName, String testAddressString, String mobilePhone, String email, String year) {
        this.testFirstName = testFirstName;
        this.testLastName = testLastName;
        this.testMiddleName = testMiddleName;
        this.testAddressString = testAddressString;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.year = year;
    }

    public String getTestFirstName() {
        return testFirstName;
    }

    public String getTestLastName() {
        return testLastName;
    }

    public String getTestMiddleName() {
        return testMiddleName;
    }

    public String getTestAddressString() {
        return testAddressString;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getYear() {
        return year;
    }
}
