import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // Uncomment for local run
//        tags = "@Smoke or @DragDrop",           //указав тег, можем тут же запускать ЛОКАЛЬНО через RunnerTest
//        features = "src/test/resources/features", // Можно указать несколько папок, например: features = {«src/test/features», «src/test/feat»}
        // Uncomment for selenium grid run
        features = "classpath:features",

        glue = "cucumber_step_defs",  // Можно указать несколько пакетов, например, так: glue = {«ru.savkk.test», «ru.savkk.hooks»}
        plugin = {"pretty", "html:target/cucumber-reports/html_reports",
                "json:target/cucumber-reports/CucumberTestReport.json"
        }
)

public class RunnerTest extends AbstractTestNGCucumberTests {    //обязательно название класа заканчивается на Test

}