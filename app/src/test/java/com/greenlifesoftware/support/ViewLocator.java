package com.greenlifesoftware.support;

import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewLocator
{
    public static View getView( Fragment fragment, int viewId )
    {
        return fragment.getView().findViewById( viewId );
    }

    public static TextView getTextView( Fragment fragment, int viewId )
    {
        return (TextView) getView( fragment, viewId );
    }

    public static Button getButton( Fragment fragment, int viewId )
    {
        return (Button) getView( fragment, viewId );
    }
}
