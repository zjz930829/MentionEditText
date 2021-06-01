package com.ctbb.meditext.mention.edit.listener;

import com.ctbb.meditext.mention.model.FormatRange;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public interface InsertData {
    CharSequence charSequence();

    FormatRange.FormatData formatData();

    int color();
}
