package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 聊天对象类
 * 2020-01-11
 *
 * @author
 */
public class DialogueBean implements Parcelable {
    private int type;
    private String message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DialogueBean(int type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.message);
    }

    protected DialogueBean(Parcel in) {
        this.type = in.readInt();
        this.message = in.readString();
    }

    public static final Parcelable.Creator<DialogueBean> CREATOR = new Parcelable.Creator<DialogueBean>() {
        @Override
        public DialogueBean createFromParcel(Parcel source) {
            return new DialogueBean(source);
        }

        @Override
        public DialogueBean[] newArray(int size) {
            return new DialogueBean[size];
        }
    };
}
