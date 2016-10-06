package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {


        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupHelper().isExistAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }
}
