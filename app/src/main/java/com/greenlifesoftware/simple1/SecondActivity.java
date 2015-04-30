package com.greenlifesoftware.simple1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class SecondActivity extends Activity
{
    public static Intent createIntent( Context context )
    {
        return new Intent(context, SecondActivity.class);
    }
}
