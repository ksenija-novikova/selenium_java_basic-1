package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();
        assertTrue(option2.isSelected()); // "Option2" is ticked

            WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
            assertFalse(option1.isSelected()); // "Option1" are not ticked

        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        assertFalse(option3.isSelected()); // "Option3" are not ticked
            option3.click();
            assertTrue(option3.isSelected()); // "Option3" are ticked

        WebElement actShowResult = driver.findElement(By.id("result_button_checkbox"));
        actShowResult.click();
        assertTrue(actShowResult.isDisplayed());
    }

    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed

            List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

            for (WebElement radioButton : radioButtons) {
                assertFalse(radioButton.isSelected()); // radio are NOT selected

                WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
                option3.click();
                WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
                assertFalse(option1.isSelected()); // "Option 1" is not selected
                WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
                assertFalse(option2.isSelected()); // "Option 2" is not selected
                assertTrue(option3.isSelected());  // "Option 3" is selected
                option1.click();
                assertTrue(option1.isSelected()); // "Option 1" is selected
                assertFalse(option2.isSelected()); // "Option 2" is not selected
                assertFalse(option3.isSelected()); // "Option 3" is not selected
                WebElement actShowResult = driver.findElement(By.id("result_button_checkbox"));
                actShowResult.click();
                assertTrue(actShowResult.isDisplayed());


            }

    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("value3");
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("value2");
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());
        WebElement actShowResult = driver.findElement(By.id("result_button_checkbox"));
        actShowResult.click();
        assertTrue(actShowResult.isDisplayed());

    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
        Calendar cal = Calendar.getInstance();
        // go back 13 years and go back 3 month


        cal.add(Calendar.MONTH, -3);
        cal.add(Calendar.YEAR, -13);
        String result = new SimpleDateFormat("MM/04/YYYY").format(cal.getTime());
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
//
//    go back 3 month in calendar on page
        for (int i = 0; i < 3; i++) {
            dateWidget.findElement(By.className("ui-datepicker-month")).click();
        }


//    select date 04
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();
    }


    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added

        String dateToEnter = "02/05/1959";

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));
    }
}
