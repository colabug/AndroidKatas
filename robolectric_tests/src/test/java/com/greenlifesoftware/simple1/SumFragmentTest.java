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

public class SumFragmentTest
{
    public static final String SUM_TOTAL = "5";
    private SumFragment fragment;
    private Button addButton;
    private TextView display;

    @Before
    public void setUp() throws Exception
    {
        fragment = SumFragment.newInstance();
        startFragment( fragment );
        addButton = (Button) getViewById( R.id.add_button );
        display = (TextView) getViewById( R.id.sum_display );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( fragment );
    }

    @Test
    public void shouldHaveAddButton() throws Exception
    {
        assertNotNull( addButton );
        assertThat( addButton.getText().toString(),
                    equalTo( getString( R.string.ADD_BUTTON_TEXT ) ) );
    }

    @Test
    public void shouldHaveSumDisplay() throws Exception
    {
        assertNotNull( display );
        assertThat( display.getText().toString(),
                    equalTo( getString( R.string.DEFAULT_SUM_DISPLAY ) ) );
    }

    @Test
    public void shouldAddOnClick() throws Exception
    {
        addButton.performClick();
        assertThat( display.getText().toString(), equalTo( SUM_TOTAL ) );
    }

    private View getViewById( int id )
    {
        return fragment.getView().findViewById( id );
    }
}
