package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"

        //        2 ways to find text: "Heading 2 text":
        System.out.println("\t First way how to find text with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t Second way how to find text with text 'Heading 2 text' is '" +
                driver.findElement(By.xpath("//*[(text()='Heading 2 text')]")).getText() + "'");



         //         1-2 ways to find text: "Test Text 1"
        System.out.println("\t First way how to find text with id 'test1' is '" +
                driver.findElement(By.xpath("//div[@id='test1']")).getText() + "'");
        System.out.println("\t Second way how to find text with text 'Test Text 1' is '" +
                driver.findElement(By.xpath("//*[(text()='Test Text 1')]")).getText() + "'");

       //         1-2 ways to find text: "Test Text 2"
        System.out.println("\t First way how to find text with class 'twoTest' is '" +
                driver.findElement(By.xpath("//p[@class='twoTest']")).getText() + "'");


        //        1-2 ways to find text: "Test Text 3"
        System.out.println("\t First way how to find text with id 'test3' is '" +
                driver.findElement(By.xpath("//div[@id='test3']")).getText() + "'");
        System.out.println("\t Second way how to find text with text 'Test Text 3' is '" +
                driver.findElement(By.xpath("//*[(text()='Test Text 3')]")).getText() + "'");

        //       1-2 ways to find text: "Test Text 4"
        System.out.println("\t First way how to find text with text 'Test Text 4' is '" +
                driver.findElement(By.xpath("//*[(text()='Test Text 4')]")).getText() + "'");

        //        1-2 ways to find text: "Test Text 5"
        System.out.println("\t First way how to find text with id 'test2' is '" +
                driver.findElement(By.xpath("//div[@id='test2']")).getText() + "'");
        System.out.println("\t Second way how to find text with text 'Test Text 5' is '" +
                driver.findElement(By.xpath("//*[(text()='Test Text 5')]")).getText() + "'");

        //      1-2 ways to find text: "This is also a button"
        System.out.println("\t First way how to find text with id 'buttonId' is '" +
                driver.findElement(By.xpath("//*[@id='buttonId']")).getText() + "'");
        System.out.println("\t Second way how to find text with name 'randomButton2' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getText() + "'");
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"

        //1-2 ways to find text: "Heading 2 text"
        System.out.println("\t First way how to find text with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
        System.out.println("\t Second way how to find text of 2-nd element with tag name 'h2' is '" +
                driver.findElement(By.xpath("//h2[2]")).getText() + "'");
        //1-2 ways to find text: "Test Text 1"
        System.out.println("\t First way how to find text with id 'test1' is '" +
                driver.findElement(By.cssSelector("#test1")).getText() + "'");
        System.out.println("\t Second way how to find text with class 'test' is '" +
                driver.findElement(By.xpath("//*[contains(@class, 'test')]")).getText() + "'");
        //1-2 ways to find text: "Test Text 2"
        System.out.println("\t First way how to find text with class 'twoTest' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");
        //1-2 ways to find text: "Test Text 3"
        System.out.println("\t First way how to find text with id 'test3' is '" +
                driver.findElement(By.cssSelector("#test3")).getText() + "'");
        //1-2 ways to find text: "This is also a button"
        System.out.println("\t First way how to find text with id 'buttonID' is '" +
                driver.findElement(By.cssSelector("#buttonID")).getText() + "'");
        System.out.println("\t Second way how to find text with name 'randomButton2' is '" +
                driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value") + "'");
    }
}
