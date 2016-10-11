package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactListPage();
        if (! app.getContactHelper().isExistAContact()){
            app.getNavigationHelper().goToCreateContactPage();
            app.getContactHelper().createContact(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "tests@tests.ru", "1999", "test1"));
        }
        app.getNavigationHelper().goToContactListPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before -1);
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("testEditFirstName", "testEditLastName", null, null, "79991099999", "Edit@Edit.ru", "1999", null),false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToContactListPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }
}
