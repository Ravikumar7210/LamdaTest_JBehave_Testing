package com.lamdatest.jbehave.login;

import org.junit.Test;

public class RunLoginStoryTest {

    @Test
    public void runStory() throws Throwable {
        new LoginStoryRunner().run();
    }
}
