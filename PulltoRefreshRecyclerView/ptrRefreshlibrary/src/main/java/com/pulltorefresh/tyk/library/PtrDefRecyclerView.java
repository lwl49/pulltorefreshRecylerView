package com.pulltorefresh.tyk.library;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;

import com.pulltorefresh.tyk.library.footer.PtrDefaultFooter;
import com.pulltorefresh.tyk.library.ptrlib.PtrClassicDefaultHeader;


/**
 * 默认底部空布局实现
 * Created by tyk on 2016/12/1 0001.
 */

public class PtrDefRecyclerView extends PtrRecyclerView {


    private PtrClassicDefaultHeader mPtrClassicHeader;

    public PtrDefRecyclerView(Context context) {
        this(context, null);
    }

    public PtrDefRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PtrDefRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setHeaderView(mPtrClassicHeader = new PtrClassicDefaultHeader(context));
        setFooterView(new PtrDefaultFooter(context));
        setLayoutManager(new LinearLayoutManager(getContext()));
        setOnEmptyViewClick(new OnClickListener() {
            @Override
            public void onClick(View v) {
                autoRefresh();
            }
        });
    }

    public void setLastUpdateTimeKey(String key) {
        if (mPtrClassicHeader != null) {
            mPtrClassicHeader.setLastUpdateTimeKey(key);
        }
    }

    public void setLastUpdateTimeRelateObject(Object object) {
        if (mPtrClassicHeader != null) {
            mPtrClassicHeader.setLastUpdateTimeRelateObject(object);
        }
    }

}
