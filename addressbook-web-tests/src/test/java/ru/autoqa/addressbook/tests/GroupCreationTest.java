package ru.autoqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.GroupData;
import ru.autoqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().groupsPage();
        Groups before = app.group().all();
        GroupData group = new GroupData()
                .withName("test3")
                .withHeader("test2")
                .withFooter("test3");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(app.group().count(), equalTo(before.size()+1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
    @Test
    public void testBadGroupCreation() {

        app.goTo().groupsPage();
        Groups before = app.group().all();
        GroupData group = new GroupData()
                .withName("test3'")
                .withHeader("test2")
                .withFooter("test3");
        app.group().create(group);

        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
