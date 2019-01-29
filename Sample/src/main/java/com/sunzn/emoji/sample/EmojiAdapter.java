package com.sunzn.emoji.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.sunzn.emoji.library.EmojiBean;

import java.util.List;


public class EmojiAdapter extends ArrayAdapter<EmojiBean> {

    public EmojiAdapter(Context context, List<EmojiBean> data) {
        super(context, R.layout.emoji_item, data);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.emoji_item, null);
            ViewHolder holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }

        EmojiBean item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.icon.setImageResource(item.getRes());
        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
    }

}
