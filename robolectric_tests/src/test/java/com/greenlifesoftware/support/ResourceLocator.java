package com.greenlifesoftware.support;

import android.graphics.drawable.Drawable;

import org.robolectric.Robolectric;

public class ResourceLocator
{
    public static String getString( int stringId )
    {
        return Robolectric.application
                .getString( stringId );
    }

    public static Drawable getDrawable( int drawableId )
    {
        return Robolectric.application
                .getResources()
                .getDrawable( drawableId );
    }
}