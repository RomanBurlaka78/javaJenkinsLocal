package jenkins.local.model.builds;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jenkins.local.model.base.BaseDetailsPage;
import jenkins.local.model.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class BuildPage extends BasePage<BuildPage> {
    @FindBy(name = "Submit")
    private WebElement clickSubmitCancel;

    @FindBy(css = "a[href$='confirmDelete']")
    private WebElement deleteBuild;

    @FindBy(xpath = "//pre[@class='console-output']//span[@class='timestamp']")
    private List<WebElement> timestampsList;

    @FindBy(xpath = "//a[@class='task-link ' and contains(@href, 'replay')]")
    private WebElement replayButtonSideMenu;

    @FindBy(xpath = "//*[text()='Edit Build Information']/ancestor::a")
    private WebElement editBuildInformationSideMenu;

    @FindBy(xpath = "//span[text()='Previous Build']/..")
    private WebElement previousBuildButton;

    @FindBy(xpath = "//span[text()='Next Build']")
    private WebElement nextBuildButton;

    @FindBy(xpath = "//h1/span[2]")
    private WebElement buildTitle;

    @FindBy(className = "task")
    private List<WebElement>  sideMenuButtonsList;

    @FindBy(xpath = "//*[@id='description']/div[1]")
    private WebElement buildDescription;

    public BuildPage(WebDriver driver) {
        super(driver);
    }

    public BuildPage clickDeleteBuildSidePanel() {
        deleteBuild.click();

        return this;
    }

    public <ProjectDetailsPage extends BaseDetailsPage<?, ?>> ProjectDetailsPage clickButtonDeleteBuild(ProjectDetailsPage projectDetailsPage) {
        clickSubmitCancel.click();

        return projectDetailsPage;
    }

    public List<String> getTimestampsList() {
        return timestampsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ReplayBuildPipelinePage clickReplaySideMenu() {
        replayButtonSideMenu.click();

        return new ReplayBuildPipelinePage(getDriver());
    }

    public BuildEditInformationPage clickEditBuildInformationSideMenu(){
        editBuildInformationSideMenu.click();

        return new BuildEditInformationPage(getDriver());
    }

    public BuildPage clickPreviousBuild() {
        previousBuildButton.click();

        return new BuildPage(getDriver());
    }

    public BuildPage clickNextBuild() {
        nextBuildButton.click();

        return new BuildPage(getDriver());
    }

    public String getBuildTitle() {
        return buildTitle.getText();
    }

    public String getBuildDescription() {
        return buildDescription.getText();
    }

    public List<String> getSideMenuButtonsList() {
        return sideMenuButtonsList.stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }
}
