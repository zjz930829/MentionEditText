package com.ctbb.meditext.mention.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ctbb.meditext.mention.text.listener.ParserConverter;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public class MentionTextView extends TextView {

    private CharSequence mOriginalText;

    public MentionTextView(Context context) {
        this(context, null);
    }

    public MentionTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MentionTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MentionTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        mOriginalText = text;
        if (!TextUtils.isEmpty(text) && null != mParserConverter) {
            text = mParserConverter.convert(text);
        }

        text = wrapper(text);
        super.setText(text, type);
    }

    public CharSequence wrapper(CharSequence text) {
        return text;
    }

    private ParserConverter mParserConverter;

    public void setParserConverter(ParserConverter parserConverter) {
        mParserConverter = parserConverter;
    }

    public CharSequence getOriginalText() {
        return mOriginalText;
    }

}
