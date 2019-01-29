package com.sunzn.emoji.library;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;

public class EmojiManager {

    public static SpannableString getEmoji(Context context, EmojiBean face, int size) {
        if (context == null || face == null || TextUtils.isEmpty(face.getName())) {
            return null;
        }
        ImageSpan imageSpan = new ImageSpan(context, EmojiCache.getInstance().getBitmap(context, face.getRes(), size));
        SpannableString spannable = new SpannableString(face.getName());
        spannable.setSpan(imageSpan, 0, face.getName().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

}
