package com.greenlifesoftware.simple1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class WelcomeActivityTest
{
    @Test
    public void shouldNotBeNull() throws Exception
    {
        WelcomeActivity activity = Robolectric.buildActivity( WelcomeActivity.class )
                                              .create()
                                              .resume()
                                              .get();
        assertNotNull( activity );
    }
}
