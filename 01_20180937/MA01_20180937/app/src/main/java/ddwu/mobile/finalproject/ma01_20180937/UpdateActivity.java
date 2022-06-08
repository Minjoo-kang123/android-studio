package ddwu.mobile.finalproject.ma01_20180937;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class UpdateActivity extends AppCompatActivity {
    final static String TAG1 = "111";
    Diary diary;

    EditText etTitle;
    EditText etDate;
    EditText etWeather;
    EditText etFeeling;
    EditText etPlace;
    ImageView viewer;

    DiaryDBManager diaryDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        diary = (Diary) getIntent().getSerializableExtra("diary");

        etTitle = findViewById(R.id.et_parsing);
        etDate = findViewById(R.id.et_date);
        etWeather = findViewById(R.id.et_weather);
        etFeeling = findViewById(R.id.et_feeling);
        etPlace = findViewById(R.id.et_place);

        Uri url = Uri.parse(diary.getPic());
        ImageView imgView = (ImageView)findViewById(R.id.iv_view);


        try {
            Bitmap bm = MediaStore.Images.Media.getBitmap(getContentResolver(), url);
            imgView.setImageBitmap(bm);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        etTitle.setText(diary.getTitle());
        etDate.setText(diary.getDate());
        etWeather.setText(diary.getWeather());
        etFeeling.setText(diary.getFeeling());
        etPlace.setText(diary.getPlace());

        diaryDBManager = new DiaryDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                diary.setTitle(etTitle.getText().toString());
                diary.setDate(etDate.getText().toString());
                diary.setWeather(etWeather.getText().toString());
                diary.setFeeling(etFeeling.getText().toString());
                diary.setPlace(etPlace.getText().toString());

                if (diaryDBManager.modifyDiary(diary)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("diary", diary);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    setResult(RESULT_CANCELED);
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }

   private void setImage(Uri uri) {
        try{
            InputStream in = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            viewer.setImageBitmap(bitmap);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
