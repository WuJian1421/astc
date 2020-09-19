package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 创建助记词
 * tips: 备份账户助记词，得到返回数据
 * 2019-12-25
 *
 * @author
 */
public class AddMemoBean implements Parcelable {

    /**
     * code : 200
     * message : 成功
     * page : null
     * data : null
     */

    private int code;
    private String message;
    private Object page;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.message);
        dest.writeParcelable((Parcelable) this.page, flags);
        dest.writeParcelable((Parcelable) this.data, flags);
    }

    public AddMemoBean() {
    }

    protected AddMemoBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<AddMemoBean> CREATOR = new Parcelable.Creator<AddMemoBean>() {
        @Override
        public AddMemoBean createFromParcel(Parcel source) {
            return new AddMemoBean(source);
        }

        @Override
        public AddMemoBean[] newArray(int size) {
            return new AddMemoBean[size];
        }
    };
}
