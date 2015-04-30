package com.greenlifesoftware.simple1;

import android.app.Fragment;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
public class SecondActivityTest
{

    private SecondActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( SecondActivity.class )
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
    public void shouldHaveSumFragment() throws Exception
    {
        Fragment fragment = getFragmentById( R.id.sum_fragment );
        assertNotNull( fragment );
    }

    @Test
    public void shouldHaveCardFragment() throws Exception
    {
        Fragment fragment = getFragmentById( R.id.card_fragment );
        assertNotNull( fragment );
    }

    private Fragment getFragmentById( int id )
    {
        return activity.getFragmentManager().findFragmentById( id );
    }
}