package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contact().list();
        int index = before.size() -2;
        ContactData contact =
        new ContactData()
                .withId(before.get(index).getId())
                .withFirstName("testEditFirstName1")
                .withLastName("testEditLastName11")
                .withMiddleName("79991099999")
                .withEmail("Edit@Edit.ru")
                .withYear("1999");
        app.contact().modify(index, contact);
        app.goTo().contactListPage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) ->Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals( before, after);

    }


}
