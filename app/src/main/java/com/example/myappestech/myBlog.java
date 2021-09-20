package com.example.myappestech;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class myBlog implements Parcelable {
    private int title, image, firstText, secondText, thirdText, firstImage, secondImage, date;

    public myBlog(int title, int image, int firstText, int secondText, int thirdText, int firstImage, int secondImage, int date) {
        this.title = title;
        this.image = image;
        this.firstText = firstText;
        this.secondText = secondText;
        this.thirdText = thirdText;
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.date = date;
    }

    protected myBlog(Parcel in) {
        title = in.readInt();
        image = in.readInt();
        firstText = in.readInt();
        secondText = in.readInt();
        thirdText = in.readInt();
        firstImage = in.readInt();
        secondImage = in.readInt();
        date = in.readInt();
    }

    public static final Creator<myBlog> CREATOR = new Creator<myBlog>() {
        @Override
        public myBlog createFromParcel(Parcel in) {
            return new myBlog(in);
        }

        @Override
        public myBlog[] newArray(int size) {
            return new myBlog[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFirstText() {
        return firstText;
    }

    public void setFirstText(int firstText) {
        this.firstText = firstText;
    }

    public int getSecondText() {
        return secondText;
    }

    public void setSecondText(int secondText) {
        this.secondText = secondText;
    }

    public int getThirdText() {
        return thirdText;
    }

    public void setThirdText(int thirdText) {
        this.thirdText = thirdText;
    }

    public int getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(int firstImage) {
        this.firstImage = firstImage;
    }

    public int getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(int secondImage) {
        this.secondImage = secondImage;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(image);
        dest.writeInt(firstText);
        dest.writeInt(secondText);
        dest.writeInt(thirdText);
        dest.writeInt(firstImage);
        dest.writeInt(secondImage);
        dest.writeInt(date);

    }
}
