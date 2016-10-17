package ru.autoqa.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.autoqa.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value = 'Delete']"));
    }

    public void acceptDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void editContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contactData) {
        fillContactForm(contactData, true);
        submitContactCreation();
    }

    public boolean isExistAContact() {
       return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, cells.get(2).getText(), cells.get(1).getText(), null, null, null, null, null, null );
            contacts.add(contact);
        }
        return contacts;
    }
}


