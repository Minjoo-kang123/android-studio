package ddwu.mobile.finalproject.ma01_20180937;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DiaryDBHelper extends SQLiteOpenHelper {
    final static String TAG = "DiaryDBHelper";

    final static String DB_NAME = "Diary.db";
    public final static String TABLE_NAME = "diary_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DATE = "date";
    public final static String COL_WEATHER = "weather";
    public final static String COL_FEELING = "feeling";
    public final static String COL_PLACE = "place";
    public final static String COL_PIC = "pic";

    public DiaryDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_DATE + " TEXT, " + COL_WEATHER + " TEXT, " + COL_FEELING + " TEXT, "
                + COL_PLACE + " TEXT, " + COL_PIC + " TEXT );";
        Log.d(TAG, sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}