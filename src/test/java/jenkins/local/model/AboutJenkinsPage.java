package jenkins.local.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class AboutJenkinsPage extends BasePage<AboutJenkinsPage> {
    @FindBy(css = ".app-about-version")
    private WebElement jenkinsVersionText;

    @FindBy(xpath = "//div[@class='jenkins-tab-pane']")
    private List<WebElement> tabPanelElements;

    @FindBy(xpath = "//div[@class='tabBar']//div")
    private List<WebElement> tabBarElements;

    public AboutJenkinsPage(WebDriver driver) {
        super(driver);
    }

    public String getJenkinsVersion() {
        return jenkinsVersionText.getText();
    }

    public List<String> getTabBarText() {
        return tabBarElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getTabBarElements() {
        return tabBarElements;
    }

    public List<WebElement> getTabPaneElements() {
        return tabPanelElements;
    }
}
