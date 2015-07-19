package com.greenlifesoftware.simple1;

import android.widget.TextView;

import com.greenlifesoftware.support.ResourceLocator;
import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.greenlifesoftware.support.Assert.assertViewIsVisible;
import static com.greenlifesoftware.support.ViewFetcher.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)

public class WelcomeFragmentTest
{
    private WelcomeFragment welcomeFragment;

    @Before
    public void setUp() throws Exception
    {
        welcomeFragment = WelcomeFragment.createInstance();
        startFragment( welcomeFragment );
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
        Assert.assertThat( welcomeText.getText().toString(),
                           equalTo( ResourceLocator.getString( R.string.welcome ) ) );
    }
}
