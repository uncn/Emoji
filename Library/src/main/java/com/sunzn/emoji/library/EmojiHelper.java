package com.sunzn.emoji.library;

import android.text.TextUtils;

public class EmojiHelper {

    public static boolean isValid(EmojiBean bean) {
        return bean != null && !TextUtils.isEmpty(bean.getName()) && EmojiPool.sFaceMap.containsKey(bean.getName());
    }

}
