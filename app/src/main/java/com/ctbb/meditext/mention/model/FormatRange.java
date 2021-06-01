package com.ctbb.meditext.mention.model;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public class FormatRange extends Range {

    private FormatData convert;

    public FormatRange(int from, int to) {
        super(from, to);
    }

    public FormatData getConvert() {
        return convert;
    }

    public interface FormatData {

        CharSequence formatCharSequence();
    }

    private CharSequence rangeCharSequence;

    public void setConvert(FormatData convert) {
        this.convert = convert;
    }

    public CharSequence getRangeCharSequence() {
        return rangeCharSequence;
    }

    public void setRangeCharSequence(CharSequence rangeCharSequence) {
        this.rangeCharSequence = rangeCharSequence;
    }
}
