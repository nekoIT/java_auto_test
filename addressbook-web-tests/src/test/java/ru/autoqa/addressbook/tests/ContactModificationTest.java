package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactListPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("testEditFirstName", "testEditLastName", "testEditMiddleName", "testEditAddressString", "79991099999", "Edit@Edit.ru", "1999"));
        app.getContactHelper().submitContactModification();
    }
}
