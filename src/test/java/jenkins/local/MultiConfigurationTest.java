package jenkins.local;

import jenkins.local.model.HomePage;
import jenkins.local.model.jobs.configs.MultiConfigurationConfigurePage;
import jenkins.local.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MultiConfigurationTest extends BaseTest {
    private  final  String NAME_OF_PROJECT = "MC project";

    @Test
    public void testCreateProject() {
        List<String> project = new HomePage(getDriver())
                .clickNewItem()
                .typeItemName(NAME_OF_PROJECT)
                .selectMultiConfigurationProject()
                .clickOk(new MultiConfigurationConfigurePage(getDriver()))
                .goHomePage()
                .getJobList();

        Assert.assertTrue(project.contains(NAME_OF_PROJECT));

    }
}
