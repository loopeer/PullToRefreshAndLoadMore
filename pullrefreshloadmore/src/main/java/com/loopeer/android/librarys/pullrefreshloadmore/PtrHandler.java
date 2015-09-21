package com.loopeer.android.librarys.pullrefreshloadmore;

import android.view.View;

import com.loopeer.android.librarys.pullrefreshloadmore.ui.view.PtrFrameLayout;

public interface PtrHandler {

    /**
     * Check can do refresh or not. For example the content is empty or the first child is in view.
     * <p/>
     */
    public boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    /**
     * When refresh begin
     *
     * @param frame
     */
    public void onRefreshBegin(final PtrFrameLayout frame);
}