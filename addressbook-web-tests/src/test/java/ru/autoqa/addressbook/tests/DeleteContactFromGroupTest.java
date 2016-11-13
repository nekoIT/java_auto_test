package ru.autoqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.GroupData;
import ru.autoqa.addressbook.model.Groups;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTest extends TestBase {

    @BeforeMethod



    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupsPage();
            app.group().create(new GroupData().withName("test3"));
        }
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            app.goTo().createContactPage();
            app.contact().createWithoutGroup(new ContactData().withFirstName("testFirstName")
                    .withLastName("testLastName")
                    .withMiddleName("testMiddleName")
                    .withAddress("testAddressString")
                    .withMiddleName("79991001010")
                    .withEmail1("tests@tests.ru")
                    .withYear("1999")
                    .inGroups(groups.iterator().next()));
        }
    }

    @Test
    public void testDeleteContactFromGroup() {
        int groupId = app.db().groupsWithContacts().iterator().next().getId();
        app.goTo().contactListPage();
        app.contact().selectGroup(groupId);
        int contactId = app.contact().all().iterator().next().getId();
        app.contact().selectContactById(contactId);
        app.contact().removeFromGroup();

        Groups groups = app.db().loadContactById(contactId).getGroups();
        Optional<Integer> optionalGroupId = groups.stream().map(GroupData::getId).filter((id) -> id == groupId).findFirst();
        assertThat(false, equalTo(optionalGroupId.isPresent()));
    }
}
