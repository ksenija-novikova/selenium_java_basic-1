package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task<expectedText, expectedValue> {
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
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("test")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);

        String expected = "This is also a button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected, actual);


    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String expected = "This is also a button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertTrue(actual.equalsIgnoreCase(expected));


//
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String expected = "This is also a button";
        String actual = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(actual.equalsIgnoreCase(expected));


    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        boolean condition = false;
        List<WebElement> allItemsClassTest = driver.findElements(By.className("test"));
        for (WebElement oneItemsClassTest : allItemsClassTest) {
        System.out.println(oneItemsClassTest.getText());
        if (oneItemsClassTest.getText() == "Test Text 1") {
            condition = true;
            assertFalse(condition);
        }

        }

    }
}

