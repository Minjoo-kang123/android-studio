package ddwu.mobile.finalproject.ma01_20180937;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DiaryDBManager {
    DiaryDBHelper DIARYDBHelper = null;
    Cursor cursor = null;

    public DiaryDBManager(Context context) {
        DIARYDBHelper = new DiaryDBHelper(context);
    }

    //    DB의 모든 다이어리를 반환
    public ArrayList<Diary> getAllDiary() {
        ArrayList diarylist = new ArrayList();
        SQLiteDatabase db = DIARYDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DIARYDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(DIARYDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_TITLE));
            String date = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_DATE));
            String weather = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_WEATHER));
            String feeling = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_FEELING));
            String place = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_PLACE));
            String pic = cursor.getString(cursor.getColumnIndex(DIARYDBHelper.COL_PIC));
            diarylist.add(new Diary(id, title, date, weather, feeling, place, pic));
        }

        cursor.close();
        DIARYDBHelper.close();
        return diarylist;
    }

    //    DB 에 새로운 food 추가
    public boolean addNewDiary(Diary newDiary) {
        SQLiteDatabase db = DIARYDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(DIARYDBHelper.COL_TITLE, newDiary.getTitle());
        value.put(DIARYDBHelper.COL_DATE, newDiary.getDate());
        value.put(DIARYDBHelper.COL_WEATHER, newDiary.getWeather());
        value.put(DIARYDBHelper.COL_FEELING, newDiary.getFeeling());
        value.put(DIARYDBHelper.COL_PLACE, newDiary.getPlace());
        value.put(DIARYDBHelper.COL_PIC, newDiary.getPic());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(DIARYDBHelper.TABLE_NAME, null, value);
        DIARYDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    //    _id 를 기준으로 food 의 이름과 nation 변경
    public boolean modifyDiary(Diary diary) {
        SQLiteDatabase sqLiteDatabase = DIARYDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(DIARYDBHelper.COL_TITLE, diary.getTitle());
        row.put(DIARYDBHelper.COL_DATE, diary.getDate());
        row.put(DIARYDBHelper.COL_WEATHER, diary.getWeather());
        row.put(DIARYDBHelper.COL_FEELING, diary.getFeeling());
        row.put(DIARYDBHelper.COL_PLACE, diary.getPlace());
        row.put(DIARYDBHelper.COL_PIC, diary.getPic());
        String whereClause = DIARYDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(diary.get_id()) };
        int result = sqLiteDatabase.update(DIARYDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        DIARYDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 DB에서 food 삭제
    public boolean removeDiary(long id) {
        SQLiteDatabase sqLiteDatabase = DIARYDBHelper.getWritableDatabase();
        String whereClause = DIARYDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(DIARYDBHelper.TABLE_NAME, whereClause,whereArgs);
        DIARYDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    나라 이름으로 DB 검색
    public ArrayList<Diary> getFoodsByNation(String nation) {

        return null;
    }

    //    음식 이름으로 DB 검색
    public ArrayList<Diary> getFoodByName(String foodName) {
        return null;
    }

    //    id 로 DB 검색
    public Diary getFoodById(long id) {

        return  null;
    }

    //    close 수행
    public void close() {
        if (DIARYDBHelper != null) DIARYDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
