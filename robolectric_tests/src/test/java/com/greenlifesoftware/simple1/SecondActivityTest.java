package com.greenlifesoftware.simple1;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
public class SecondActivityTest
{
    @Test
    public void shouldNotBeNull() throws Exception
    {
        SecondActivity activity = Robolectric.buildActivity( SecondActivity.class )
                                             .create()
                                             .resume()
                                             .get();
        assertNotNull( activity );
    }
}