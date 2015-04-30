package com.greenlifesoftware.simple1;

import com.greenlifesoftware.support.RobolectricGradleTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)

public class SumFragmentTest
{
    @Test
    public void shouldNotBeNull() throws Exception
    {
        SumFragment fragment = SumFragment.newInstance();
        assertNotNull( fragment );
    }
}
