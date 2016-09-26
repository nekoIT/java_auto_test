package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {

        app.getNavigationHelper().goToCreateContactPage();
        app.getContactHelper().fillContactForm(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "tests@tests.ru", "1999"));
        app.getContactHelper().submitContactCreation();
    }


}
