package com.greenlifesoftware.support;

import android.view.View;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class Assert {
    public static void assertViewVisible(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.VISIBLE));
    }

    public static void assertViewInvisible(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.INVISIBLE));
    }

    public static void assertViewGone(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.GONE));
    }
}
