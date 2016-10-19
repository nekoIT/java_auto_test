package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().contactListPage();
        List<ContactData> before = app.contact().list();
        app.goTo().createContactPage();
        ContactData contact  =  new ContactData()
                .withFirstName("testNewFirstName")
                .withLastName("testNewLastName")
                .withMiddleName("79991088888")
                .withEmail("New@New.ru")
                .withYear("1888")
                .withGroup("test1");
        app.contact().create(contact);
        app.goTo().contactListPage();
        List<ContactData> after = app.contact().list();
        app.goTo().contactListPage();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
