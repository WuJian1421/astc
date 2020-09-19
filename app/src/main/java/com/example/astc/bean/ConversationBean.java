package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 会话适配器
 * 2020-01-11
 *
 * @author
 */
public class ConversationBean implements Parcelable {
    private String icon;
    private String nickName;
    private String content;
    private String time;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.icon);
        dest.writeString(this.nickName);
        dest.writeString(this.content);
        dest.writeString(this.time);
    }

    public ConversationBean() {
    }

    protected ConversationBean(Parcel in) {
        this.icon = in.readString();
        this.nickName = in.readString();
        this.content = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<ConversationBean> CREATOR = new Parcelable.Creator<ConversationBean>() {
        @Override
        public ConversationBean createFromParcel(Parcel source) {
            return new ConversationBean(source);
        }

        @Override
        public ConversationBean[] newArray(int size) {
            return new ConversationBean[size];
        }
    };

    @Override
    public String toString() {
        return "ConversationBean{" +
                "icon='" + icon + '\'' +
                ", nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
