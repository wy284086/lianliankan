package com.tinygame.lianliankan.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class InternalDBCreateHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "integral.db";
    private static final int DATABASE_VERSION = 3;
    
    public InternalDBCreateHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseConfig.INTEGRAL_DATABASE_CREATE);
        db.execSQL(DataBaseConfig.ENDLESS_DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion <= 2) {
            db.execSQL("DROP TABLE IF EXISTS " + DataBaseConfig.INTEGRAL_DATABASE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + DataBaseConfig.ENDLESS_DATABASE_CREATE);
            onCreate(db);
        }
    }

    private boolean checkColomnIsExist(SQLiteDatabase db, String table, String checkColomn) {
        boolean isExist = true;
        String tableName = "sqlite_master";
        String[] columns = new String[]{"sql"};
        String selection = "tbl_name" + "=?" + " AND type" + "=?";
        String[] selectionArgs = new String[]{table, "table"};
        Cursor cursor = null;
        try {
            cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null);//("select sql from sqlite_master where tbl_name='chat_log' and type='table'");
            if(cursor != null){
                if(cursor.moveToNext()){
                    String sql = cursor.getString(0);
                    if(!sql.contains(checkColomn)){
                        isExist = false;
                    }else{
                        isExist = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(cursor != null){
                cursor.close();
            }
        }
        
        return isExist;
    }
}
