package co.com.sofka.runner.practiceform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/feature/practiceform/practiceForm.feature"},
        glue = {"co/com/sofka/stepdefinition/practiceform"},
        tags = "@Regresion"
)

public class PracticeFormTestCucumber {
}
