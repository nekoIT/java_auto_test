package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().goToGroupsPage();

        if (! app.getGroupHelper().isExistAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size()-1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);


    }
}
