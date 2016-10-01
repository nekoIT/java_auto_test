package ru.autoqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupsPage() {

        click(By.linkText("groups"));
    }

    public void goToCreateContactPage() {

        click(By.linkText("add new"));
    }

    public void goToContactListPage() {

        click(By.linkText("home"));
    }
}
