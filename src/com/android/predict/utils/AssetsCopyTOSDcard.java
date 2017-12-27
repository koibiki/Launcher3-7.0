package com.android.predict.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;

public class AssetsCopyTOSDcard {

    private static final int BUFFER_SIZE = 1024;

    private static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyAssets(Context context, String asset, String target) {
        File dest = new File(target);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(context.getResources().getAssets().open(asset));
            out = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(out);
            close(in);
        }

    }

}