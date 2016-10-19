package ru.autoqa.addressbook.model;

public final class ContactData {

    private int id = Integer.MAX_VALUE;;
    private String testFirstName;
    private String testLastName;
    private String testMiddleName;
    private String testAddressString;
    private String mobilePhone;
    private String email;
    private String year;
    private String group;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String testFirstName) {
        this.testFirstName = testFirstName;
        return this;
    }

    public ContactData withLastName(String testLastName) {
        this.testLastName = testLastName;
        return this;
    }

    public ContactData withMiddleName(String testMiddleName) {
        this.testMiddleName = testMiddleName;
        return this;
    }

    public ContactData withAddressString(String testAddressString) {
        this.testAddressString = testAddressString;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withYear(String year) {
        this.year = year;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

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
                "id=" + id +
                ", testFirstName='" + testFirstName + '\'' +
                ", testLastName='" + testLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != Integer.MAX_VALUE) {
            if (id != that.id) return false;
        }
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
