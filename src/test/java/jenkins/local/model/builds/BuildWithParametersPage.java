package jenkins.local.model.builds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class BuildWithParametersPage extends BasePage<BuildWithParametersPage> {

    @FindBy(xpath = "//select[@name='value']/option")
    private List<WebElement> choiceParameterOptions;

    @FindBy(name = "value")
    private WebElement stringParameterValueField;

    @FindBy(xpath = "//button[@class='jenkins-button jenkins-button--primary jenkins-!-build-color']")
    private WebElement buildButton;

    public BuildWithParametersPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getChoiceParameterOptions() {
        return choiceParameterOptions
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public BuildWithParametersPage setStringParameterValue(String value) {
        stringParameterValueField.sendKeys(value);

        return this;
    }

    public <T> T clickBuildButton(T page) {
        buildButton.click();

        return page;
    }
}
