package com.greenlifesoftware.simple1;

import android.app.Fragment;

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
        assertNotNull( findFragmentById( R.id.sum_fragment ) );
    }

    @Test
    public void shouldHaveCardFragment() throws Exception
    {
        assertNotNull( findFragmentById( R.id.card_fragment ) );
    }

    private Fragment findFragmentById( int id )
    {
        return secondActivity.getFragmentManager().findFragmentById( id );
    }
}
