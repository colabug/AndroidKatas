package com.greenlifesoftware.simple1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SumFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        View layout = inflater.inflate( R.layout.fragment_sum, container );
        return layout;
    }

    public static SumFragment newInstance()
    {
        return new SumFragment();
    }
}
