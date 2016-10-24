package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactListPage();
        if (app.contact().list().size()==0){
            app.goTo().createContactPage();
            app.contact().create(new ContactData().withFirstName("testFirstName")
                    .withLastName("testLastName")
                    .withMiddleName("testMiddleName")
                    .withAddressString("testAddressString")
                    .withMiddleName("79991001010")
                    .withEmail("tests@tests.ru")
                    .withYear("1999")
                    .withGroup("test1"));
        }
    }
    @Test
    public void testContactModification() {
        app.goTo().contactListPage();
        Set<ContactData> before = app.contact().all();
        ContactData modifiedcontact = before.iterator().next();

        ContactData contact =
        new ContactData()
                .withId(modifiedcontact.getId())
                .withFirstName("testEditFirstName1")
                .withLastName("testEditLastName11")
                .withMiddleName("79991099999")
                .withEmail("Edit@Edit.ru")
                .withYear("1999");
        app.contact().modify(modifiedcontact.getId(), contact);
        app.goTo().contactListPage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedcontact);
        before.add(contact);
        Assert.assertEquals( before, after);

    }


}
