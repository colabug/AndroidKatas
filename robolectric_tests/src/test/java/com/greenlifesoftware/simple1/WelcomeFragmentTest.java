package com.greenlifesoftware.simple1;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
public class WelcomeFragmentTest
{
    @Test
    public void shouldNotBeNull() throws Exception
    {
        WelcomeFragment fragment = WelcomeFragment.newInstance();
        assertNotNull( fragment );
    }
}
