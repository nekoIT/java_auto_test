package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.GroupData;

public class ContractDeletionTest extends TestBase {

    @Test
    public void testContractDeletion(){

        app.getNavigationHelper().goToContactListPage();
        if (! app.getContactHelper().isExistAContact()){
            app.getNavigationHelper().goToCreateContactPage();
            app.getContactHelper().createContact(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "tests@tests.ru", "1999", "test1"),true);
        }
        app.getNavigationHelper().goToContactListPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeleteContact();

    }
}
