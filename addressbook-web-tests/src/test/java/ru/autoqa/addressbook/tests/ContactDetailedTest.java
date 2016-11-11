package ru.autoqa.addressbook.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailedTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactListPage();
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
    public void testContactDetailed() {
        app.goTo().contactListPage();
        ContactData contact = app.contact().all().iterator().next();
        String contactInfoFromDetailedForm = app.contact().infoFromDetailsForm(contact);

        Pattern p = Pattern.compile(contact.getFirstName()+"\\s.+\\s" +
                contact.getLastName()+"\\s+"+contact.getAddress()+"\\s+H: "+contact.getHomePhone()+"\\s+" +
                "M: "+contact.getMobilePhone()+"\\s+W: "+contact.getWorkPhone()+"\\s+"+contact.getEmail()+"\\s.+\\s+" +
                contact.getEmail2()+"\\s+"+contact.getEmail3()+"\\s[\\s*\\S+]*");


        Assert.assertTrue(p.matcher(contactInfoFromDetailedForm).matches());
    }
}



