package ru.autoqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;
import ru.autoqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupsPage();
            app.group().create(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groups();
        app.goTo().groupsPage();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Assert.assertEquals(app.group().count(), before.size() - 1);
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }
}
