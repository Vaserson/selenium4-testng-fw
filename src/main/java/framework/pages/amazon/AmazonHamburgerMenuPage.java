package framework.pages.amazon;

import driver.DriverManager;
import framework.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHamburgerMenuPage extends BasePage {

    @FindBy(xpath = "//div[text()='Computers']/parent::a")
    private WebElement linkComputers;

    @FindBy(xpath = "//a[text()='Computer Components']")
    private WebElement linkComputerComponents;

    @FindBy(xpath = "//a[text()='Computers & Tablets']")
    private WebElement linkComputersAndTablets;


    public AmazonHamburgerMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public AmazonHamburgerMenuPage clickComputers() {
        linkComputers.click();
        return this;
    }


    public AmazonComputerComponents clickComputerComponents() {
        linkComputerComponents.click();
        return new AmazonComputerComponents();
    }


    public AmazonComputersAndTablets clickComputersAndTablets() {
        linkComputersAndTablets.click();
        return new AmazonComputersAndTablets();
    }


}
