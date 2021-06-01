package com.ctbb.meditext.mention.edit.util;

import com.ctbb.meditext.mention.model.FormatRange;
import com.ctbb.meditext.mention.model.Range;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Description: .
 * Created by ZJZ on 2021/6/1.
 */
public class FormatRangeManager extends RangeManager {

    public CharSequence getFormatCharSequence(String text) {
        if (isEmpty()) {
            return text;
        }

        int lastRangeTo = 0;
        ArrayList<? extends Range> ranges = get();
        Collections.sort(ranges);

        StringBuilder builder = new StringBuilder("");
        CharSequence newChar;
        for (Range range : ranges) {
            if (range instanceof FormatRange) {
                FormatRange formatRange = (FormatRange) range;
                FormatRange.FormatData convert = formatRange.getConvert();
                newChar = convert.formatCharSequence();
                builder.append(text.substring(lastRangeTo, range.getFrom()));
                builder.append(newChar);
                lastRangeTo = range.getTo();
            }
        }

        builder.append(text.substring(lastRangeTo));
        return builder.toString();
    }
}
