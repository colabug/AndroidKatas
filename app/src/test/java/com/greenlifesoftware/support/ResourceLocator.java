package com.greenlifesoftware.support;

import android.graphics.drawable.Drawable;

import org.robolectric.RuntimeEnvironment;

public class ResourceLocator
{
    public static String getString(int stringId)
    {
        return RuntimeEnvironment.application.getString(stringId);
    }

    public static String[] getStringArray(int arrayId)
    {
        return RuntimeEnvironment.application.getResources().getStringArray(arrayId);
    }

    public static Drawable getDrawable(int drawableId)
    {
        return RuntimeEnvironment.application.getResources().getDrawable(drawableId);
    }
}