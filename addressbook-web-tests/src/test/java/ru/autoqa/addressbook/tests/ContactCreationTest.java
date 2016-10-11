package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToContactListPage();
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().goToCreateContactPage();
        app.getContactHelper().fillContactForm(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "tests@tests.ru", "1999", "test1"),true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToContactListPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }


}
