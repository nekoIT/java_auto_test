package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;

public class ContractDeletionTest extends TestBase {

    @Test
    public void testContractDeletion(){

        app.getNavigationHelper().goToContactListPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeleteContact();

    }
}
