package com.lamdatest.jbehave.login;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class LoginStoryRunner extends JUnitStories {

    public LoginStoryRunner() {
    	System.out.println("Runner initialized...");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JbehaveLoginTestApplication.class);

    	Configuration config = new MostUsefulConfiguration()
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withFormats(Format.CONSOLE, Format.HTML)
                .withDefaultFormats());

        useConfiguration(config);
        useStepsFactory(new SpringStepsFactory(config, context));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(
            CodeLocations.codeLocationFromClass(this.getClass()),
            List.of("**/*.story"),
            null
        );
    }
}