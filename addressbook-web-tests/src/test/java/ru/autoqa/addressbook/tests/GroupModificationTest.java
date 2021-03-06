package ru.autoqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;
import ru.autoqa.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupsPage();
            app.group().create(new GroupData().withName("test3"));
        }
    }
    @Test
    public void testGroupModification(){

        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("test3")
                .withHeader("test2")
                .withFooter("test3");
        app.goTo().groupsPage();
        app.group().modify(group);
        Assert.assertEquals(app.group().count(), before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));

        verifyGroupListInUI();


    }

}
