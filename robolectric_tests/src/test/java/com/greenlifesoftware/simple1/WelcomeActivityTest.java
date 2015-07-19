package com.greenlifesoftware.simple1;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)

public class WelcomeActivityTest
{
    private WelcomeActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( WelcomeActivity.class )
                              .create()
                              .resume()
                              .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveWelcomeFragment() throws Exception
    {
        assertNotNull( activity.getFragmentManager().findFragmentById( R.id.welcome_fragment ) );
    }
}
