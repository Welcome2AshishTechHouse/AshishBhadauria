package stepDefinitions;

import commonUtils.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import projectManager.ScenarioManager;

public class Hooks {

    @Before
    public void beforeEachScenario(Scenario scenario){
        ScenarioManager.getInstance().setScenario(scenario);
    }

    @After
    public void afterEachScenario(){
        WebDriverUtil.quitDriver();
    }
}
