package ru.autoqa.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.autoqa.addressbook.model.ContactData;
import ru.autoqa.addressbook.model.Contacts;
import ru.autoqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getTestFirstName());
        type(By.name("lastname"), contactData.getTestLastName());
        type(By.name("middlename"), contactData.getTestMiddleName());
        type(By.name("address"), contactData.getTestAddressString());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        if (!isSelected(By.xpath("//div[@id='content']/form/select[1]//option[3]"))) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        }
        if (!isSelected(By.xpath("//div[@id='content']/form/select[2]//option[2]"))) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
        }
        type(By.name("byear"), contactData.getYear());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact(int k) {
        wd.findElements(By.name("selected[]")).get(k).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.xpath("//input[@value = '"+id+"']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value = 'Delete']"));
    }

    public void acceptDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void editContact(int id) {
        wd.findElement(By.xpath("//a[@href ='edit.php?id="+id+"'] ")).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(ContactData contactData) {
        fillContactForm(contactData, true);
        submitContactCreation();
    }
    public void modify(int id, ContactData contact) {
        editContact(id);
        fillContactForm(contact,false);
        submitContactModification();
    }
    public void delete(ContactData contast) {
       selectContactById(contast.getId());
        deleteSelectedContact();
        acceptDeleteContact();
    }
    public Contacts all() {
        Contacts contacts = new Contacts();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withId(id)
                    .withLastName(cells.get(1).getText())
                    .withFirstName(cells.get(2).getText());
            contacts.add(contact);
        }
        return contacts;
    }


    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withId(id)
                    .withLastName(cells.get(1).getText())
                    .withFirstName(cells.get(2).getText());
            contacts.add(contact);
        }
        return contacts;
    }
}


