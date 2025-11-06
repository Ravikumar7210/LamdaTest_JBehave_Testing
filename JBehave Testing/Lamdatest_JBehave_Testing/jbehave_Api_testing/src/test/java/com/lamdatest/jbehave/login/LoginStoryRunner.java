package com.lamdatest.jbehave.login;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class LoginStoryRunner extends JUnitStories {

    public LoginStoryRunner() {
        System.out.println("Runner initialized...");

        Configuration config = new org.jbehave.core.configuration.MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(this.getClass()))
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withFormats(Format.CONSOLE, Format.HTML, Format.STATS)
                .withViewResources(viewResources())
                .withRelativeDirectory("jbehave")
                .withDefaultFormats());

        useConfiguration(config);
        useStepsFactory(new InstanceStepsFactory(config, new LoginSteps()));
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("stories/login.story");
    }

    private Properties viewResources() {
        Properties props = new Properties();
        props.setProperty("reports", "ftl/jbehave-reports.ftl");
        props.setProperty("nonDecorated", "ftl/jbehave-report-non-decorated.ftl");
        props.setProperty("maps", "ftl/jbehave-maps.ftl");
        props.setProperty("views", "ftl/jbehave-views.ftl");
        props.setProperty("decorated", "ftl/jbehave-report-decorated.ftl");
        return props;
    }
}