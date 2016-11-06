package ru.autoqa.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.Contacts;
import ru.autoqa.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  //
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
      List<Object[]> list = new ArrayList<Object[]>();
      BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
      String xml = "";
      String line = reader.readLine();
      while (line != null){
          xml += line;
          line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

  }

         @Test(description = "validContacts")
        public void testContactCreation(ContactData contact) {
            app.goTo().contactListPage();
            Contacts before = app.contact().all();
            app.goTo().createContactPage();
            app.contact().create(contact);
            app.goTo().contactListPage();
            Contacts after = app.contact().all();
             Assert.assertEquals(app.group().count(), before.size()+1);
            app.goTo().contactListPage();
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }

}
