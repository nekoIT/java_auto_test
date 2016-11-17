package ru.autoqa.addressbook.tests;

import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.Contacts;
import ru.autoqa.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends TestBase {
    private SessionFactory sessionFactory;

    @BeforeMethod

    // создаем контакт без группы
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupsPage();
            app.group().create(new GroupData().withName("test3"));
        }

        app.goTo().createContactPage();
        app.contact().createWithoutGroup(new ContactData().withFirstName("testFirstName")
                .withLastName("testLastName")
                .withMiddleName("testMiddleName")
                .withAddress("testAddressString")
                .withMiddleName("79991001010")
                .withEmail1("tests@tests.ru")
                .withYear("1999"));
    }

    @Test
    public void testGroupsAdd() {
        app.goTo().contactListPage();
        Contacts contacts = app.contact().all();
        int id = contacts.stream().mapToInt(ContactData::getId).max().getAsInt();
        app.contact().selectContactById(id);
        int idGroup = app.contact().selectContactToGroup();
        app.contact().addContactToGroup();
        ContactData contactData = app.db().loadContactById(id);
        assertThat(idGroup, equalTo(contactData.getGroups().iterator().next().getId()));
    }
}
