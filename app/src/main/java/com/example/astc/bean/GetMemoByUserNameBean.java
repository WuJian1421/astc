package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 获取助记词
 * 2019-12-23
 *
 * @author
 */
public class GetMemoByUserNameBean implements Parcelable {

    /**
     * code : 200
     * message : 成功
     * page : null
     * data : {"memo":["sense","arm","torch","dilemma","trigger","label","enhance","truth","runway","assault","master","capable"],"userId":3}
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
        /**
         * memo : ["sense","arm","torch","dilemma","trigger","label","enhance","truth","runway","assault","master","capable"]
         * userId : 3
         */

        private int userId;
        private List<String> memo;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

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
            dest.writeInt(this.userId);
            dest.writeStringList(this.memo);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.userId = in.readInt();
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
                    "userId=" + userId +
                    ", memo=" + memo +
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

    public GetMemoByUserNameBean() {
    }

    protected GetMemoByUserNameBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetMemoByUserNameBean> CREATOR = new Parcelable.Creator<GetMemoByUserNameBean>() {
        @Override
        public GetMemoByUserNameBean createFromParcel(Parcel source) {
            return new GetMemoByUserNameBean(source);
        }

        @Override
        public GetMemoByUserNameBean[] newArray(int size) {
            return new GetMemoByUserNameBean[size];
        }
    };

    @Override
    public String toString() {
        return "GetMemoByUserNameBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
