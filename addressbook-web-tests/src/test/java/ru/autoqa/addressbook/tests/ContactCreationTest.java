package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().contactListPage();
        Contacts before = app.contact().all();
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
        Contacts after = app.contact().all();
        app.goTo().contactListPage();
        Assert.assertEquals(after.size(), before.size() + 1);
              assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }
}
