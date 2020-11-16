package com.larryhsiao.oilprice.view.cpc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larryhsiao.oilprice.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fragment that shows current CPC product prices
 */
public class CPCPriceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
        @NotNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle saved
    ) { return inflater.inflate(R.layout.page_cpc_price, container, false); }


}
