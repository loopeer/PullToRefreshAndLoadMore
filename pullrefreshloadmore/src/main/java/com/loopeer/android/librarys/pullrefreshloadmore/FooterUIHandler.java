package com.loopeer.android.librarys.pullrefreshloadmore;


import com.loopeer.android.librarys.pullrefreshloadmore.indicator.PtrIndicator;
import com.loopeer.android.librarys.pullrefreshloadmore.ui.view.PtrFrameLayout;

/**
 *
 */
public interface FooterUIHandler {

    /**
     * When the content view has reached top and refresh has been completed, view will be reset.
     *
     * @param frame
     */
    public void onUIReset(PtrFrameLayout frame);

    /**
     * prepare for loading
     *
     * @param frame
     */
    public void onUILoadPrepare(PtrFrameLayout frame);

    /**
     * perform refreshing UI
     */
    public void onUILoadBegin(PtrFrameLayout frame);

    /**
     * perform UI after refresh
     */
    public void onUILoadComplete(PtrFrameLayout frame);

    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator);
}
