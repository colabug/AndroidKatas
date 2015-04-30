package com.greenlifesoftware.simple1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.greenlifesoftware.support.ResourceLocator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
public class WelcomeFragmentTest
{
    private WelcomeFragment fragment;

    @Before
    public void setUp() throws Exception
    {
        fragment = WelcomeFragment.newInstance();
        startFragment( fragment );
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
        Button startActivityButton = (Button) getViewById( R.id.start_activity_button );
        assertNotNull( startActivityButton );
        assertThat( startActivityButton.getText().toString(),
                    equalTo( getString( R.string.START_ACTIVITY_BUTTON_TEXT ) ) );
    }

    private View getViewById( int id )
    {
        return fragment.getView().findViewById( id );
    }
}
