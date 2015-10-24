package test;

import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.InjectableStepsFactory;

public class WebTest extends SerenityStories {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage("test.selenium.steps", configuration()).andClassLoader(getClassLoader());
    }

    public WebTest() {
//        runSerenity().inASingleSession();
    }

}
