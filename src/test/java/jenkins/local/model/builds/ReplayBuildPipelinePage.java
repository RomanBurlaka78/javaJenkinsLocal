package jenkins.local.model.builds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BasePage;
import jenkins.local.model.jobs.details.PipelineDetailsPage;

public class ReplayBuildPipelinePage extends BasePage<ReplayBuildPipelinePage> {

    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement runButton;

    public ReplayBuildPipelinePage(WebDriver driver) {
        super(driver);
    }

    public PipelineDetailsPage clickRunButton() {
        runButton.click();

        return new PipelineDetailsPage(getDriver());
    }

}
