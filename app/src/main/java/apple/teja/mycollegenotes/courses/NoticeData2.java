package apple.teja.mycollegenotes.courses;

public class NoticeData2 {
    String title, image,textlink;

    public NoticeData2() {

    }

    public NoticeData2(String title, String image,String textlink, String date, String time) {
        this.title = title;
        this.image = image;
        this.textlink=textlink;



    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextlink() {
        return textlink;
    }

    public void setTextlink(String textlink) {
        this.title = textlink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

