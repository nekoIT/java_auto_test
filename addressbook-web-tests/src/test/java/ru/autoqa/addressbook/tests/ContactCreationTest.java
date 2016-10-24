package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().contactListPage();
        Set<ContactData> before = app.contact().all();
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
        Set<ContactData> after = app.contact().all();
        app.goTo().contactListPage();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
