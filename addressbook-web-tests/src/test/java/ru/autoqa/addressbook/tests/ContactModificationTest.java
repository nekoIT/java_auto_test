package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactListPage();
        if (! app.getContactHelper().isExistAContact()){
            app.getNavigationHelper().goToCreateContactPage();
            app.getContactHelper().createContact(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "tests@tests.ru", "1999", "test1"));
        }
        app.getNavigationHelper().goToContactListPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() -1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().editContact();
        ContactData contact  = new ContactData(before.get(index).getId(),"testEditFirstName", "testEditLastName", null, null, "79991099999", "Edit@Edit.ru", "1999", null);
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToContactListPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }
}
