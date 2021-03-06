package com.tinygame.lianliankan.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.PorterDuff.Mode;
import android.util.Log;

import com.tinygame.lianliankan.config.Config;

class ImageSplitUtils {

    private static final String TAG = "ImageSplitUtils";
    
    public static class BitmapSiplited {
        public Bitmap bitmap;
        public int id;
    }
    
    private static ImageSplitUtils gImageSplitUtils = new ImageSplitUtils();
    private Context mContext;
    private ArrayList<BitmapSiplited> mCurrentRes;
    private ArrayList<Bitmap> mNumberList;
    private ArrayList<Bitmap> mLevelNumberList;
    private ArrayList<Bitmap> mBoomList;
    private ArrayList<Bitmap> mContinueClickList;
    private int mCurrentImageWidth;
    
    public static ImageSplitUtils getInstance() {
        if (gImageSplitUtils == null) {
            gImageSplitUtils = new ImageSplitUtils();
        }
        
        return gImageSplitUtils;
    }

    public void init(Context context) {
        mContext = context;
    }
    
    public void clearCurrentRes() {
        if (mCurrentRes != null) {
            for (BitmapSiplited bt : mCurrentRes) {
                if (bt != null && !bt.bitmap.isRecycled()) {
                    bt.bitmap.recycle();
                }
            }
            mCurrentRes.clear();
        }
    }
    
    public int getCurrentImageWidth() {
        return mCurrentImageWidth;
    }
    
    public static Bitmap rotateBitmap(Bitmap bmp, int orientataion) {
        if (orientataion != 0 && bmp != null) {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) orientataion);
            Bitmap tmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
            if (tmp != null) {
//                bmp.recycle();
//                bmp = null;
                bmp = tmp;
            }
            return bmp;
        }
        
        return bmp;
    }
    
    public ArrayList<Bitmap> getTimeNumberBtList() {
        mNumberList = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/time_number.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtWidth = width / 10;
        Bitmap bt = null;
        for (int i = 0; i < 10; ++i) {
            bt = Bitmap.createBitmap(src
                                    , i * retBtWidth 
                                    , 0
                                    , retBtWidth
                                    , height);
            if (bt != null) {
                bt.setDensity(160);
                mNumberList.add(bt);
            }
        }
        
        return mNumberList;
    }
    
    public ArrayList<Bitmap> getLightVerticalBtList() {
        ArrayList<Bitmap> ret = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/light_vertical.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtHeight = height / 5;
        Bitmap bt = null;
        for (int i = 0; i < 5; ++i) {
            bt = Bitmap.createBitmap(src
                                        , 0
                                        , i * retBtHeight
                                        , width
                                        , retBtHeight);
            if (bt != null) {
                bt.setDensity(160);
                ret.add(bt);
            }
        }
       
        return ret;
    }
    
    public ArrayList<Bitmap> getLevelNumberBtList() {
        mLevelNumberList = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/number.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtWidth = width / 10;
        Bitmap bt = null;
        for (int i = 0; i < 10; ++i) {
            bt = Bitmap.createBitmap(src
                                    , i * retBtWidth 
                                    , 0
                                    , retBtWidth
                                    , height);
            if (bt != null) {
                bt.setDensity(160);
                mLevelNumberList.add(bt);
            }
        }
        
        return mLevelNumberList;
    }
    
    public ArrayList<Bitmap> getBoomBtList() {
        mBoomList = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/boom.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtWidth = width / 6;
        Bitmap bt = null;
        for (int i = 0; i < 6; ++i) {
            bt = Bitmap.createBitmap(src
                                    , i * retBtWidth 
                                    , 0
                                    , retBtWidth
                                    , height);
            if (bt != null) {
                bt.setDensity(160);
                mBoomList.add(bt);
            }
        }
        
        return mBoomList;
    }
    
    public ArrayList<Bitmap> getBoomList1() {
        mBoomList = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "boom/boom0.png");
        mBoomList.add(src);
        src = loadBitmapFromAsset(mContext, "boom/boom1.png");
        src = loadBitmapFromAsset(mContext, "boom/boom2.png");
        mBoomList.add(src);
        src = loadBitmapFromAsset(mContext, "boom/boom3.png");
        mBoomList.add(src);
        src = loadBitmapFromAsset(mContext, "boom/boom4.png");
        mBoomList.add(src);
        src = loadBitmapFromAsset(mContext, "boom/boom5.png");
        mBoomList.add(src);
        
        return mBoomList;
    }
    
    public ArrayList<Bitmap> getContinueClickBtList() {
        mContinueClickList = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/beat.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtWidth = width / 11;
        Bitmap bt = null;
        for (int i = 0; i < 11; ++i) {
            bt = Bitmap.createBitmap(src
                                    , i * retBtWidth 
                                    , 0
                                    , retBtWidth
                                    , height);
            if (bt != null) {
                bt.setDensity(160);
                mContinueClickList.add(bt);
            }
        }
        
        return mContinueClickList;
    }
    
    public ArrayList<Bitmap> getTimeProgressBtList() {
        ArrayList<Bitmap> ret = new ArrayList<Bitmap>();
        Bitmap src = loadBitmapFromAsset(mContext, "image/time_progress.png");
        int height = src.getHeight();
        int width = src.getWidth();
        int retBtWidth = width / 3;
        Bitmap bt = null;
        for (int i = 0; i < 3; ++i) {
            bt = Bitmap.createBitmap(src
                                    , i * retBtWidth 
                                    , 0
                                    , retBtWidth
                                    , height);
            if (bt != null) {
                bt.setDensity(160);
                ret.add(bt);
            }
        }
        
        return ret;
    }
    
    public ArrayList<BitmapSiplited> splitBitmapInAssests(String path) {
        mCurrentRes = new ArrayList<BitmapSiplited>();
        Bitmap src = loadBitmapFromAsset(mContext, path);
        if (path.endsWith(".png")) {
            path = path.substring(0, path.length() - 4);
        }
        int pos = path.lastIndexOf("_");
        if (pos != -1) {
            mCurrentImageWidth = 0;
            int icon_width = Integer.valueOf(path.substring(pos + 1));
            mCurrentImageWidth = icon_width;
            int src_width = src.getWidth();
            int src_height = src.getHeight();
            
            BitmapSiplited bts = null;
            int x_length  = src_width / icon_width;
            int y_length  = src_height / icon_width;
            int index = 0;
            Canvas canvas = new Canvas();
            Paint paint = new Paint();
            for (int x = 0; x < x_length; ++x) {
                for (int y = 0; y < y_length; ++y) {
                    try {
                        bts = new BitmapSiplited();
                        bts.bitmap = Bitmap.createBitmap(src
                                                , x * icon_width 
                                                , y * icon_width
                                                , icon_width
                                                , icon_width);
                        bts.bitmap.setDensity(160);
                        
                        Bitmap image = Utils.getRoundedCornerBitmap(bts.bitmap, 10.0f, 1, mCurrentImageWidth);
                        image.setDensity(160);
                        bts.bitmap = image;
                        bts.id = index;
                        index++;
                        mCurrentRes.add(bts);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            mCurrentImageWidth += 2;
        }
        
        return mCurrentRes;
    }
    
    private Bitmap loadBitmapFromAsset (Context context, String resName) {
        if (resName == null) {
            throw new RuntimeException("resName MUST not be NULL");
        }
        
        if (!resName.endsWith(".png")) {
            resName = resName + ".png";
        }
            
        InputStream is = null;
        try {
            is = context.getAssets().open(resName);
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inDensity = 160;
            Rect rect = new Rect();
            Bitmap bitmap = BitmapFactory.decodeStream(is, rect, opt);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    private void LOGD(String msg) {
        if (Config.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
