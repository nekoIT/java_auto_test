package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactListPage();
        if (app.contact().all().size()==0){
            app.goTo().createContactPage();
            app.contact().create(new ContactData().withFirstName("testFirstName")
                    .withLastName("testLastName")
                    .withMiddleName("testMiddleName")
                    .withAddress("testAddressString")
                    .withMiddleName("79991001010")
                    .withEmail1("tests@tests.ru")
                    .withYear("1999")
                    .withGroup("test1"));
        }
    }
    @Test
    public void testContactModification() {
        app.goTo().contactListPage();
        Contacts before = app.contact().all();
        ContactData modifiedcontact = before.iterator().next();

        ContactData contact =
        new ContactData()
                .withId(modifiedcontact.getId())
                .withFirstName("testEditFirstName1")
                .withLastName("testEditLastName11")
                .withMiddleName("Name")
                .withMobilePhone("78900007676")
                .withEmail1("Edit@Edit.ru")
                .withYear("1999");
        app.contact().modify(modifiedcontact.getId(), contact);
        app.goTo().contactListPage();
        Assert.assertEquals(app.group().count(), before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifiedcontact).withAdded(contact)));


    }


}
