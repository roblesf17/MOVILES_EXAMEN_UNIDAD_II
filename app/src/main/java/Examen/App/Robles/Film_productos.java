package Examen.App.Robles;

import java.io.Serializable;

public class Film_productos implements Serializable {

    private int mId;
    private String mTitle;
    private String mDesc;
    private int mImage;

    public Film_productos(int id, String title, int image, String desc) {
        mTitle = title;
        mDesc = desc;
        mImage = image;
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDescription() {
        return mDesc;
    }

    public void setDescription(String desc) {
        this.mDesc = desc;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = mImage;
    }



}
