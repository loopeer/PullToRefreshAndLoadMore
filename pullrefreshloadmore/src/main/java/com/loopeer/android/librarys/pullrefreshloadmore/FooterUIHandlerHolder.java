package com.loopeer.android.librarys.pullrefreshloadmore;


import com.loopeer.android.librarys.pullrefreshloadmore.indicator.PtrIndicator;
import com.loopeer.android.librarys.pullrefreshloadmore.ui.view.PtrFrameLayout;

/**
 * A single linked list to wrap PtrUIHandler
 */
public class FooterUIHandlerHolder implements FooterUIHandler {

    private FooterUIHandler mHandler;
    private FooterUIHandlerHolder mNext;

    private boolean contains(FooterUIHandler handler) {
        return mHandler != null && mHandler == handler;
    }

    private FooterUIHandlerHolder() {

    }

    public boolean hasHandler() {
        return mHandler != null;
    }

    private FooterUIHandler getHandler() {
        return mHandler;
    }

    public static void addHandler(FooterUIHandlerHolder head, FooterUIHandler handler) {

        if (null == handler) {
            return;
        }
        if (head == null) {
            return;
        }
        if (null == head.mHandler) {
            head.mHandler = handler;
            return;
        }

        FooterUIHandlerHolder current = head;
        for (; ; current = current.mNext) {

            // duplicated
            if (current.contains(handler)) {
                return;
            }
            if (current.mNext == null) {
                break;
            }
        }

        FooterUIHandlerHolder newHolder = new FooterUIHandlerHolder();
        newHolder.mHandler = handler;
        current.mNext = newHolder;
    }

    public static FooterUIHandlerHolder create() {
        return new FooterUIHandlerHolder();
    }

    public static FooterUIHandlerHolder removeHandler(FooterUIHandlerHolder head, FooterUIHandler handler) {
        if (head == null || handler == null || null == head.mHandler) {
            return head;
        }

        FooterUIHandlerHolder current = head;
        FooterUIHandlerHolder pre = null;
        do {

            // delete current: link pre to next, unlink next from current;
            // pre will no change, current move to next element;
            if (current.contains(handler)) {

                // current is head
                if (pre == null) {

                    head = current.mNext;
                    current.mNext = null;

                    current = head;
                } else {

                    pre.mNext = current.mNext;
                    current.mNext = null;
                    current = pre.mNext;
                }
            } else {
                pre = current;
                current = current.mNext;
            }

        } while (current != null);

        if (head == null) {
            head = new FooterUIHandlerHolder();
        }
        return head;
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        FooterUIHandlerHolder current = this;
        do {
            final FooterUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUIReset(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadPrepare(PtrFrameLayout frame) {
        if (!hasHandler()) {
            return;
        }
        FooterUIHandlerHolder current = this;
        do {
            final FooterUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadPrepare(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadBegin(PtrFrameLayout frame) {
        FooterUIHandlerHolder current = this;
        do {
            final FooterUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadBegin(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUILoadComplete(PtrFrameLayout frame) {
        FooterUIHandlerHolder current = this;
        do {
            final FooterUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUILoadComplete(frame);
            }
        } while ((current = current.mNext) != null);
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        FooterUIHandlerHolder current = this;
        do {
            final FooterUIHandler handler = current.getHandler();
            if (null != handler) {
                handler.onUIPositionChange(frame, isUnderTouch, status, ptrIndicator);
            }
        } while ((current = current.mNext) != null);
    }
}
