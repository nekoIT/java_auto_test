package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToContactListPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToCreateContactPage();
        ContactData contact  = new ContactData("testEditFirstName", "testEditLastName", null, null, "79991099999", "Edit@Edit.ru", "1999", null);
        app.getContactHelper().fillContactForm(contact,true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToContactListPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToContactListPage();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);

        after.remove(after.size()-1);
        Assert.assertEquals(before, after);
    }


}
