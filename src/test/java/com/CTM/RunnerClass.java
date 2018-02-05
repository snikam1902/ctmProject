package com.CTM;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Created by shweta on 01/02/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        format = "html:target/CucumberReports",
        tags = "@test1,@test2,@test3")

public class RunnerClass {


}
