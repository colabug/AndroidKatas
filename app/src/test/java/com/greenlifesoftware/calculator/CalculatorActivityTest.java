package com.greenlifesoftware.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class CalculatorActivityTest
{
    private CalculatorActivity calculatorActivity;

    @Before
    public void setUp() throws Exception
    {
        calculatorActivity = Robolectric.buildActivity( CalculatorActivity.class )
                                        .create()
                                        .resume()
                                        .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( calculatorActivity );
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception
    {
        assertNotNull( calculatorActivity.findViewById( R.id.welcome_text ) );
    }
}
