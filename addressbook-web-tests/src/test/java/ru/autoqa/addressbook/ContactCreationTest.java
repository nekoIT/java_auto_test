package ru.autoqa.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {

        goToCreateContactPage();
        fillContactForm(new ContactData("testFirstName", "testLastName", "testMiddleName", "testAddressString", "79991001010", "test@test.ru", "1999"));
        submitContactCreation();
    }


}
