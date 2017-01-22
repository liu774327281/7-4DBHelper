package org.mobiletrain.a7_4dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wangsong on 2016/6/17.
 */
public class DBHelper extends SQLiteOpenHelper {

    public final static String USERTABLE = "USER";
    public final static String PERSONTABLE = "PERSON";
    public final static String FOODTABLE = "FOOD";
    private final static String DBNAME = "qianfeng";
    //表示当前数据库版本号，每次升级时改变这个版本号
    private final static int CURRENTVERSION = 3;
    //表示数据库开始版本号，这个值不变
    private final static int STARTVERSION = 1;

    public DBHelper(Context context) {
        super(context, DBNAME, null, CURRENTVERSION);
    }

    //onCreate方法只会执行一次，在第一次安装时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + USERTABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME);");
        Log.d("google_lenve_fb", "onCreate: ");
        onUpgrade(db, STARTVERSION, CURRENTVERSION);
    }

    //第一个参数表示旧的版本号，第二个是新的版本号
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("google_lenve_fb", "onUpgrade: oldVersion:" + oldVersion + ";newVersion:" + newVersion);
        //注意这里的switch都没有分支只有最后一个有break
        switch (oldVersion) {
            //版本2升级的代码写在这里
            case 1:
                //添加Person表
                db.execSQL("CREATE TABLE IF NOT EXISTS " + PERSONTABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME);");
                //上个版本号为2，当前版本号为3
            case 2:
                db.execSQL("CREATE TABLE IF NOT EXISTS " + FOODTABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME);");
            case 3:
            case 4:
                break;

        }
//        switch (newVersion) {
//            case 2:
//                db.execSQL("CREATE TABLE IF NOT EXISTS " + PERSONTABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME);");
//                break;
//            case 3:
//                db.execSQL("CREATE TABLE IF NOT EXISTS " + FOODTABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME);");
//                break;
//        }
    }
}
