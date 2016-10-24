package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupsPage();
        if (app.group().all().size()==0){
            app.group().create(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }
}
