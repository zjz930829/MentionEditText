package com.ctbb.meditext.mention.text.listener;

import android.text.Spanned;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public interface ParserConverter {
    Spanned convert(CharSequence source);
}
