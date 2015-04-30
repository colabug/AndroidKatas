package com.greenlifesoftware.simple1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SumFragment extends Fragment
{
    @Nullable @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        View layout = inflater.inflate( R.layout.fragment_sum, container );
        final TextView display = (TextView) layout.findViewById( R.id.sum_display );

        layout.findViewById( R.id.add_button ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                int sum = 2 + 3;
                display.setText("" + sum);
            }
        } );

        return layout;
    }

    public static SumFragment newInstance()
    {
        return new SumFragment();
    }
}
