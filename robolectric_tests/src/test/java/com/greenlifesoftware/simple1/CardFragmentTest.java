package com.greenlifesoftware.simple1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.greenlifesoftware.support.ResourceLocator;
import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.greenlifesoftware.support.ResourceLocator.getString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.shadows.ShadowToast.getTextOfLatestToast;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricGradleTestRunner.class)
public class CardFragmentTest
{
    private CardFragment fragment;
    private Button toastButton;

    @Before
    public void setUp() throws Exception
    {
        fragment = CardFragment.newInstance();
        startFragment( fragment );
        toastButton = (Button) getViewById( R.id.toast_button );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( fragment );
    }

    @Test
    public void shouldHaveCardImage() throws Exception
    {
        ImageView card = (ImageView) getViewById( R.id.card_image );
        assertNotNull( card );
        assertThat( card.getDrawable(),
                    equalTo( ResourceLocator.getDrawable( R.drawable.ace ) ) );
    }

    @Test
    public void shouldHaveToastButton() throws Exception
    {
        assertNotNull( toastButton );
    }

    @Test
    public void toastButtonShouldToast() throws Exception
    {
        toastButton.performClick();
        assertThat( getTextOfLatestToast(),
                    equalTo( getString( R.string.CARD_TOAST ) ) );
    }

    private View getViewById( int id )
    {
        return fragment.getView().findViewById( id );
    }
}
