package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }

}
