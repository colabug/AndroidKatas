package com.greenlifesoftware.simple1;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static com.greenlifesoftware.support.Assert.assertViewIsVisible;
import static com.greenlifesoftware.support.ResourceLocator.*;
import static com.greenlifesoftware.support.ViewFetcher.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)

public class WelcomeFragmentTest
{
    private WelcomeFragment welcomeFragment;
    private Button startActivityButton;

    @Before
    public void setUp() throws Exception
    {
        welcomeFragment = WelcomeFragment.createInstance();
        startFragment( welcomeFragment );

        startActivityButton = getButton( welcomeFragment, R.id.start_activity_button );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( welcomeFragment );
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception
    {
        TextView welcomeText = getTextView( welcomeFragment, R.id.welcome_text );
        assertViewIsVisible( welcomeText );
        assertThat( welcomeText.getText().toString(),
                    equalTo( getString( R.string.welcome ) ) );
    }

    @Test
    public void shouldHaveStartActivityButton() throws Exception
    {
        assertViewIsVisible( startActivityButton );
        assertThat( startActivityButton.getText().toString(),
                    equalTo( getString( R.string.start_activity_button_text ) ) );
    }

    @Test
    public void shouldStartActivityOnButtonClick() throws Exception
    {
        startActivityButton.performClick();
        ShadowActivity shadowActivity = Robolectric.shadowOf( welcomeFragment.getActivity() );
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf( startedIntent );
        assertEquals( SecondActivity.class.getName(),
                      shadowIntent.getComponent().getClassName() );
    }
}
