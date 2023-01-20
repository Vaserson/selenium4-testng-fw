package framework.pages.amazon;

import driver.DriverManager;
import enums.WaitStrategy;
import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {

    @FindBy(xpath = "//div[text()='Computers']/parent::a")
    private WebElement linkComputers;

    private String linkSubMenu = "//a[text()='%replaceable%']";

    //todo Will be optimized for different pages
    public AmazonComputerComponents clickSubMenuItem(String menutext) {
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
        click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
        if (menutext.contains("Computer Components")) {
            return new AmazonComputerComponents();
        } else {
            return null;
        }
    }

    public AmazonHamburgerMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public AmazonHamburgerMenuPage clickComputers() {
        linkComputers.click();
        return this;
    }
}
