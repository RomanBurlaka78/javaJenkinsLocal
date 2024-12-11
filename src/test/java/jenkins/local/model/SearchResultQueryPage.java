package jenkins.local.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import jenkins.local.model.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultQueryPage extends BasePage<SearchResultQueryPage> {
    public SearchResultQueryPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSearchResultQueryText() {

        return getDriver().findElements(By.cssSelector("li[id]")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public <T> T clickSearchResultQuery(String nameResult, T page) {
        getDriver().findElement(By.linkText(nameResult)).click();

        return page;
    }
}
