package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 注册
 * 2019-12-17
 *
 * @author
 */
public class AddUsersBean implements Parcelable {

    /**
     * code : 200
     * message : 成功
     * page : null
     * data : {"memo":["buddy","run","system","kind","episode","globe","point","lumber","prepare","riot","north","social"]}
     */

    private int code;
    private String message;
    private Object page;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private List<String> memo;

        public List<String> getMemo() {
            return memo;
        }

        public void setMemo(List<String> memo) {
            this.memo = memo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeStringList(this.memo);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.memo = in.createStringArrayList();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        @Override
        public String toString() {
            return "DataBean{" +
                    "memo=" + memo +
                    '}';
        }
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
        dest.writeParcelable(this.data, flags);
    }

    public AddUsersBean() {
    }

    protected AddUsersBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<AddUsersBean> CREATOR = new Parcelable.Creator<AddUsersBean>() {
        @Override
        public AddUsersBean createFromParcel(Parcel source) {
            return new AddUsersBean(source);
        }

        @Override
        public AddUsersBean[] newArray(int size) {
            return new AddUsersBean[size];
        }
    };

    @Override
    public String toString() {
        return "AddUsersBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
