package com.greenlifesoftware.simple1;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)

public class SecondActivityTest
{

    private SecondActivity secondActivity;

    @Before
    public void setUp() throws Exception
    {
        secondActivity = Robolectric.buildActivity( SecondActivity.class )
                                                   .create()
                                                   .resume()
                                                   .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( secondActivity );
    }

    @Test
    public void shouldHaveSumFragment() throws Exception
    {
        assertNotNull(secondActivity.getFragmentManager().findFragmentById( R.id.sum_fragment ));

    }
}
