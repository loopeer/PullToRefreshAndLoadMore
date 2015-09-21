package com.loopeer.android.librarys.pullrefreshloadmore.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BasePullFragment extends Fragment {

    public BasePullFragment() {

    }

    protected abstract View createView(LayoutInflater var1, ViewGroup var2, Bundle var3);

}
