package com.sunzn.emoji.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.util.Log;

public class EmojiCache {

    private static final int FACE_CACHE_SIZE = 32;

    private static LruCache<Integer, Bitmap> mCache;

    private static EmojiCache instance;

    public static EmojiCache getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static void createInstance() {
        if (instance == null) {
            instance = new EmojiCache(FACE_CACHE_SIZE);
        }
    }

    private EmojiCache(int cacheSize) {
        mCache = new LruCache<Integer, Bitmap>(cacheSize) {
            @Override
            public void resize(int maxSize) {
                super.resize(maxSize);
            }

            @Override
            public void trimToSize(int maxSize) {
                super.trimToSize(maxSize);
            }

            @Override
            protected void entryRemoved(boolean evicted, @NonNull Integer key, @NonNull Bitmap oldValue, @Nullable Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }

            @Nullable
            @Override
            protected Bitmap create(@NonNull Integer key) {
                return super.create(key);
            }

            @Override
            protected int sizeOf(@NonNull Integer key, @NonNull Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }

    public Bitmap getBitmap(Context context, int id, int size) {
        Log.e("Cache", "Cache = " + mCache.size());
        Bitmap bitmap = mCache.get(id);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), id);
            bitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
            mCache.put(id, bitmap);
        }
        return bitmap;
    }

}
