package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupsPage();
        if (! app.getGroupHelper().isExistAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
