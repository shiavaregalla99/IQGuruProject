package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\IQGURUAutomationBranch\\Guru99ShoppingSite\\src\\test\\resources\\Features\\Login.feature"
,glue="StepsDefinitions",
//dryRun=true,

tags=" @Smoke1",
plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class JunitRunner {

}
