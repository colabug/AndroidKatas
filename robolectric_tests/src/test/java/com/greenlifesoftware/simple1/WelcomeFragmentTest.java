package com.greenlifesoftware.simple1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static com.greenlifesoftware.support.ResourceLocator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
public class WelcomeFragmentTest
{
    private WelcomeFragment fragment;
    private Button startActivityButton;

    @Before
    public void setUp() throws Exception
    {
        fragment = WelcomeFragment.newInstance();
        startFragment( fragment );
        startActivityButton = (Button) getViewById( R.id.start_activity_button );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( fragment );
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception
    {
        TextView welcome = (TextView) getViewById( R.id.welcome_string );
        assertNotNull( welcome );
        assertThat( welcome.getText().toString(),
                    equalTo( getString( R.string.hello_world ) ) );
    }

    @Test
    public void shouldHaveStartActivityButton() throws Exception
    {
        assertNotNull( startActivityButton );
        assertThat( startActivityButton.getText().toString(),
                    equalTo( getString( R.string.START_ACTIVITY_BUTTON_TEXT ) ) );
    }

    @Test
    public void startActivityButtonShouldStartActivity() throws Exception
    {
        startActivityButton.performClick();
        ShadowActivity shadowActivity = Robolectric.shadowOf( fragment.getActivity() );
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf( startedIntent );
        assertEquals( SecondActivity.class.getName(), shadowIntent.getComponent().getClassName() );
    }

    private View getViewById( int id )
    {
        return fragment.getView().findViewById( id );
    }
}
