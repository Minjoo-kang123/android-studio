package ddwu.mobile.finalproject.ma01_20180937;

import java.io.Serializable;

public class Diary implements Serializable {

    long _id;
    String title;
    String date;
    String feeling;
    String weather;
    String place;
    String pic;

    public Diary(String title, String date,String weather, String feeling, String place, String pic) {
        this.title = title;
        this.date = date;
        this.weather = weather;
        this.feeling = feeling;
        this.place = place;
        this.pic = pic;
    }

    public Diary(long _id, String title, String date, String weather, String feeling, String place, String pic) {
        this._id = _id;
        this.title = title;
        this.date = date;
        this.weather = weather;
        this.feeling = feeling;
        this.place = place;
        this.pic = pic;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String date) {
        this.title = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather(){
        return weather;
    }

    public void setWeather(String weather){
        this.weather = weather;
    }

    public String getFeeling(){
        return feeling;
    }

    public void setFeeling(String feeling){
        this.feeling = feeling;
    }

    public String getPlace() { return place; }

    public void setPlace(String place) { this.place = place; }

    public String getPic() { return pic; }

    public void setPic(String pic) { this.pic = pic; }
}
