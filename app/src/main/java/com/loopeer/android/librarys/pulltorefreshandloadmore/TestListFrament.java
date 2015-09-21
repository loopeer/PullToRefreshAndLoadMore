package com.loopeer.android.librarys.pulltorefreshandloadmore;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.loopeer.android.librarys.pullrefreshloadmore.PtrDefaultHandler;
import com.loopeer.android.librarys.pullrefreshloadmore.PtrHandler;
import com.loopeer.android.librarys.pullrefreshloadmore.ui.view.PtrClassicFrameLayout;
import com.loopeer.android.librarys.pullrefreshloadmore.ui.view.PtrFrameLayout;
import java.util.ArrayList;
import java.util.List;

public class TestListFrament extends Fragment{

    private ArrayAdapter<String> mAdapter;
    private PtrClassicFrameLayout mPtrFrame;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View contentView = inflater.inflate(R.layout.fragment_classic_header_with_list_view, container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ListView listView = (ListView) view.findViewById(R.id.rotate_header_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                }
            }
        });

        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, getList());
        listView.setAdapter(mAdapter);

        mPtrFrame = (PtrClassicFrameLayout) view.findViewById(R.id.rotate_header_list_view_frame);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                updateData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
        // the following are default settings
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        // default is false
        mPtrFrame.setPullToRefresh(false);
        // default is true
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);

    }

    private List<String> getList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            result.add("This is the position: " + i);
        }
        return result;
    }

    protected void updateData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.refreshComplete();
            }
        }, 4000);

    }


}
