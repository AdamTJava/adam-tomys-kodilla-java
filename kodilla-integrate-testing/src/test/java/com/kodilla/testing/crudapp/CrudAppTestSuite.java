package com.kodilla.testing.crudapp;

import com.kodilla.testing.config.WebDriverConfig;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://adamtomys.github.io";
    private static WebDriver webDriver;
    private Random generator = new Random();

    @BeforeAll
    public static void initTests() {
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);
    }

    @AfterAll
    public static void cleanUp() {
//        webDriver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "/html/body/main/section[1]/form/fieldset[3]/button";
        int taskNumber = generator.nextInt(100);
        String taskName = "New task " + taskNumber;
        String taskContent = "New content " + taskNumber;

        WebElement name = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = webDriver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        webDriver.navigate().refresh();

        while(!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
        webDriver.switchTo().alert().accept();
    }

    private void deleteTask(String taskName) throws InterruptedException {
        webDriver.navigate().refresh();

        while(!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(
                By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDeleteCard =
                            theForm.findElement(By.xpath(".//button[4]"));
                    buttonDeleteCard.click();
                });
        Thread.sleep(2000);
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteTask(taskName);
    }
}
