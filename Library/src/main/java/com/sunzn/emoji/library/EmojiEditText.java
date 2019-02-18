package com.sunzn.emoji.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.SpannableString;
import android.util.AttributeSet;

public class EmojiEditText extends AppCompatEditText {

    private int size;

    public EmojiEditText(Context context) {
        super(context);
    }

    public EmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public EmojiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray attribute = getContext().obtainStyledAttributes(attrs, R.styleable.EmojiEditText);
        size = attribute.getInteger(R.styleable.EmojiEditText_etv_icon_size, (int) getTextSize());
        attribute.recycle();
    }

    public void insert(EmojiBean bean) {
        if (EmojiHelper.isValid(bean)) {
            SpannableString spannable = EmojiManager.getEmoji(getContext(), bean, size);
            Editable editable = getEditableText();
            editable.insert(getSelectionStart(), spannable);
        }
    }

}
