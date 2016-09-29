package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
