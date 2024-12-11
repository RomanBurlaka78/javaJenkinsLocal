package jenkins.local;

import org.testng.Assert;
import org.testng.annotations.Test;
import jenkins.local.model.HomePage;
import jenkins.local.model.jobs.configs.FreestyleProjectConfigurePage;
import jenkins.local.model.jobs.details.FreestyleProjectDetailsPage;
import jenkins.local.runner.BaseTest;


public class FreestyleTest extends BaseTest {
    private static final String PROJECT_NAME = "ProjectName";
    private static final String NEW_PROJECT_NAME = "NewProjectName";

    @Test
    public void testCreate() {
        HomePage homePage = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(PROJECT_NAME)
                .selectFreestyleProject()
                .clickOk(new FreestyleProjectConfigurePage(getDriver()))
                .goHomePage();
        Assert.assertEquals(homePage.getJobList().contains(PROJECT_NAME), true);

    }

    @Test(dependsOnMethods = "testCreate")
    public void testCreateWithSameName() {
        String homePage = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(PROJECT_NAME)
                .getInvalidNameErrorMessage();

        Assert.assertEquals(homePage, "» A job already exists with the name ‘ProjectName’");
    }

    @Test(dependsOnMethods = "testCreate")
    public void testisExistFreestyleProject() {
        boolean homePage = new HomePage(getDriver())
                .goHomePage()
                .isProjectExist(PROJECT_NAME);

        Assert.assertEquals(homePage, true);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRenameFreestyleProject() {
        boolean homePage = new HomePage(getDriver())
                .goHomePage()
                .clickJobByName(PROJECT_NAME, new FreestyleProjectDetailsPage(getDriver()))
                .clickRename()
                .clearInputField()
                .enterNewName(NEW_PROJECT_NAME)
                .clickRenameButton()
                .goHomePage()
                .isProjectExist(NEW_PROJECT_NAME);

        Assert.assertEquals(homePage, true);

    }

    @Test
    public void testDeleteFreestyleProject() {
        boolean projectExist = new HomePage(getDriver())
                .clickNewItem()
                .createFreestyleProject("other" + PROJECT_NAME)
                .clickSaveButton()
                .goHomePage()
                .clickJobByName("other" + PROJECT_NAME, new FreestyleProjectDetailsPage(getDriver()))
                .deleteProject()
                .goHomePage()
                .isProjectExist("other" + PROJECT_NAME);

        Assert.assertEquals(projectExist, false);
    }

}
