package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().goToGroupsPage();

        if (! app.getGroupHelper().isExistAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(before-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after  = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before -1);

    }
}
