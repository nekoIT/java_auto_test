package ru.autoqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd=wd;
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void goToCreateContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }
}
