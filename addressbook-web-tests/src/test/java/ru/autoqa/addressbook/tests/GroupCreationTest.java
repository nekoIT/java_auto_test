package ru.autoqa.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().groupsPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData()
                .withName("test3")
                .withHeader("test2")
                .withFooter("test3");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);


        Assert.assertEquals(before, after);
    }
}
