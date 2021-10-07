package nintendo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
here is just an example of page classes for UI testing
 */

public class BasePage {
    public BasePage() {
     //   PageFactory.initElements(Driver.get(), this); => i use Page Factory to initialize @FindBy annotations
    }

    @FindBy(id = "month")
    public WebElement month;

}
