package jenkins.local.model.nodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class NodesListPage extends BasePage<NodesListPage> {

    @FindBy(xpath = "//a[@href='new']")
    private WebElement newNodeButton;

    @FindBy(xpath = "//th[@initialsortdir='down']")
    private WebElement sortByNameButton;

    @FindBy(xpath = "//tr/td/a")
    private List<WebElement> nodesList;

    public NodesListPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNodeList() {
        return nodesList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public NodeCreatePage clickNewNodeButton() {
        newNodeButton.click();

        return new NodeCreatePage(getDriver());
    }

    public NodeDetailsPage clickNodeByName(String nodeName) {
        getDriver().findElement(By.xpath("//tr[@id='node_" + nodeName + "']/td/a")).click();

        return new NodeDetailsPage(getDriver());
    }

    public boolean elementIsNotPresent(String xpath) {
        return getDriver().findElements(By.xpath(xpath)).isEmpty();
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public NodesListPage clickSortByNameButton() {
        sortByNameButton.click();

        return this;
    }
}
