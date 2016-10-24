package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContractDeletionTest extends TestBase {

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
    public void testContractDeletion(){
        app.goTo().contactListPage();
        Set<ContactData> before = app.contact().all();
        ContactData deletedGroup = before.iterator().next();
        app.contact().delete(deletedGroup);
        app.goTo().contactListPage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }
}
