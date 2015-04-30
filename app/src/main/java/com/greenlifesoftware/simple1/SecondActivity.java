package com.greenlifesoftware.simple1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );
    }

    public static Intent createIntent( Context context )
    {
        return new Intent(context, SecondActivity.class);
    }
}
