package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.GroupData;

import java.util.Comparator;
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
        int index = before.size() -2;
        app.getContactHelper().editContact(index);
        ContactData contact  = new ContactData(before.get(index).getId(),"testEditFirstName1", "testEditLastName11", null, null, "79991099999", "Edit@Edit.ru", "1999", null);
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToContactListPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) ->Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals( before, after);

    }
}
