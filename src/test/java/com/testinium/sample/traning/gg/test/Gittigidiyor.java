
package com.testinium.sample.traning.gg.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gittigidiyor {

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    Actions action;

    @Test
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);

        //driver.get("https://www.gittigidiyor.com");
        //driver.findElement(By.xpath("//*[@title = 'Giriş Yap']")).click();
        driver.get("https://www.gittigidiyor.com/uye-girisi");

        sendById("L-UserNameField", "sm.fenerbahce@gmail.com");
        sendById("L-PasswordField", "paSa454t");

        clickButton("gg-login-enter");

        driver.get("https://www.gittigidiyor.com");

        findByName("header-search-input", "iphone");
        clickFindButton("search-find-button");

        clickToProduct("Apple iPhone 6S 16GB (Yenilenmiş)");

        addToBasket("add-to-basket");

     //   clickToBasket("Sepet");
    }
/*
    private void clickToBasket(String sepet) {
        element = wait.until(ExpectedConditions.elementToBeClickable(By.name(sepet)));
        element.click();
    }
*/
    private void addToBasket(String productID) throws InterruptedException {
        element = driver.findElement(By.id(productID));
        Thread.sleep(3000);
        action.moveToElement(element).click().perform();
        System.out.println("Basıldı");
       // Thread.sleep(10000);
        //driver.get("https://www.gittigidiyor.com");
    }

    private void clickToProduct(String name) {

        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='"+name+"']")));
        driver.get(element.getAttribute("href"));
        //driver.findElement(By.xpath("//li[@id='product_id_560118427']")).click();
    }

    private void clickFindButton(String searchButton) {
        driver.findElement(By.xpath("//*[@data-cy='"+searchButton+"']")).click();
    }

    private void findByName(String searchInput, String value) {
        driver.findElement(By.xpath("//*[@data-cy='"+searchInput+"']")).click();
        driver.findElement(By.xpath("//*[@data-cy='"+searchInput+"']")).clear();
        driver.findElement(By.xpath("//*[@data-cy='"+searchInput+"']")).sendKeys(value);
    }

    private void sendById(String id, String information) {
        driver.findElement(By.id(id)).sendKeys(information);
    }

    private void clickButton(String buttonId) {
        element = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonId)));
        element.click();
    }








}
