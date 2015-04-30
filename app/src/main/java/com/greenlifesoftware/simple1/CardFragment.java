package com.greenlifesoftware.simple1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CardFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        View layout = inflater.inflate( R.layout.fragment_card, container );
        layout.findViewById( R.id.toast_button ).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                Toast.makeText( getActivity(),
                                getString( R.string.CARD_TOAST ),
                                Toast.LENGTH_SHORT )
                     .show();
            }
        } );

        return layout;
    }

    public static CardFragment newInstance()
    {
        return new CardFragment();
    }
}
