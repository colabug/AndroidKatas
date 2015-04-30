package com.greenlifesoftware.simple1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WelcomeFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        View layout = inflater.inflate( R.layout.fragment_welcome, container );

        layout.findViewById( R.id.start_activity_button ).setOnClickListener( new View.OnClickListener()

        {
            @Override
            public void onClick( View v )
            {
                startActivity( SecondActivity.createIntent( getActivity() ) );
            }
        } );

        return layout;
    }

    public static WelcomeFragment newInstance()
    {
        return new WelcomeFragment();
    }
}
