package ru.autoqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.autoqa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void fillContactForm(ContactData contactData) {
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
            click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        }
        type(By.name("byear"), contactData.getYear());
        if (!isSelected(By.xpath("//div[@id='content']/form/select[5]//option[4]"))) {
            click(By.xpath("//div[@id='content']/form/select[5]//option[4]"));
        }

    }
    
    public void submitContactCreation() {
        click(By.name("submit"));
    }

}
