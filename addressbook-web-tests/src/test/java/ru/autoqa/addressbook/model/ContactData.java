package ru.autoqa.addressbook.model;

public final class ContactData {

    private int id;
    private final String testFirstName;
    private final String testLastName;
    private final String testMiddleName;
    private final String testAddressString;
    private final String mobilePhone;
    private final String email;
    private final String year;
    private  String group;

    public ContactData(String testFirstName, String testLastName, String testMiddleName, String testAddressString, String mobilePhone, String email, String year, String group) {
        this.id = 0;
        this.testFirstName = testFirstName;
        this.testLastName = testLastName;
        this.testMiddleName = testMiddleName;
        this.testAddressString = testAddressString;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.year = year;
        this.group = group;
    }

    public ContactData(int id, String testFirstName, String testLastName, String testMiddleName, String testAddressString, String mobilePhone, String email, String year, String group) {
        this.id = id;
        this.testFirstName = testFirstName;
        this.testLastName = testLastName;
        this.testMiddleName = testMiddleName;
        this.testAddressString = testAddressString;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.year = year;
        this.group = group;
    }
    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

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

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "ContactData{" +
                "testFirstName='" + testFirstName + '\'' +
                ", testLastName='" + testLastName + '\'' +
                ", testAddressString='" + testAddressString + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (testFirstName != null ? !testFirstName.equals(that.testFirstName) : that.testFirstName != null)
            return false;
        return testLastName != null ? testLastName.equals(that.testLastName) : that.testLastName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (testFirstName != null ? testFirstName.hashCode() : 0);
        result = 31 * result + (testLastName != null ? testLastName.hashCode() : 0);
        return result;
    }
}
