package apple.teja.mycollegenotes.home;

import apple.teja.mycollegenotes.courses.NoticeData2;

public class NoticeData1 extends NoticeData2 {


    String title, image, date, time;

    public NoticeData1() {

    }

    public NoticeData1(String title, String image, String date, String time) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

