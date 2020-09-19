package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 查询认证状态
 * 2020-01-17
 *
 * @author
 */
public class GetIDCardBean implements Parcelable {

    /**
     * code : 200
     * message : success
     * page : null
     * data : {"type":1,"id":1346,"userId":21,"name":"测试","gender":null,"idCardNumber":"245335679999266","side":"back","frontUrl":"http://47.244.112.18:8181/image/30535a80-77aa-4ee4-b92e-74d6bee1c68c.jpg","backUrl":"http://47.244.112.18:8181/image/8a38b970-0f9c-4a4a-b6eb-7adb447b967b.jpg","frontFilePath":"/data/ecc/opt/ecc/pic/idpic/30535a80-77aa-4ee4-b92e-74d6bee1c68c.jpg","backFilePath":"/data/ecc/opt/ecc/pic/idpic/8a38b970-0f9c-4a4a-b6eb-7adb447b967b.jpg","handFilePath":"/data/ecc/opt/ecc/pic/idpic/c23ffe7a-9dca-448e-b8a7-b15a4096aa1c.jpg","handUrl":"http://47.244.112.18:8181/image/c23ffe7a-9dca-448e-b8a7-b15a4096aa1c.jpg","frontImg":"http://ecc-data.oss-cn-hongkong.aliyuncs.com/fe499b25-0a09-4125-bfac-e4a715967842_card.jpg","backImg":"http://ecc-data.oss-cn-hongkong.aliyuncs.com/eb13a0ba-fe26-4936-ad00-7d9b811a2c55_card.jpg","handImg":"http://ecc-data.oss-cn-hongkong.aliyuncs.com/1e65ad84-ecc1-4534-b2cc-b4e1ffd6f93b_card.jpg","state":0,"limitNum":null,"orderByCondition":null}
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

    public static class DataBean {
        /**
         * type : 1
         * id : 1346
         * userId : 21
         * name : 测试
         * gender : null
         * idCardNumber : 245335679999266
         * side : back
         * frontUrl : http://47.244.112.18:8181/image/30535a80-77aa-4ee4-b92e-74d6bee1c68c.jpg
         * backUrl : http://47.244.112.18:8181/image/8a38b970-0f9c-4a4a-b6eb-7adb447b967b.jpg
         * frontFilePath : /data/ecc/opt/ecc/pic/idpic/30535a80-77aa-4ee4-b92e-74d6bee1c68c.jpg
         * backFilePath : /data/ecc/opt/ecc/pic/idpic/8a38b970-0f9c-4a4a-b6eb-7adb447b967b.jpg
         * handFilePath : /data/ecc/opt/ecc/pic/idpic/c23ffe7a-9dca-448e-b8a7-b15a4096aa1c.jpg
         * handUrl : http://47.244.112.18:8181/image/c23ffe7a-9dca-448e-b8a7-b15a4096aa1c.jpg
         * frontImg : http://ecc-data.oss-cn-hongkong.aliyuncs.com/fe499b25-0a09-4125-bfac-e4a715967842_card.jpg
         * backImg : http://ecc-data.oss-cn-hongkong.aliyuncs.com/eb13a0ba-fe26-4936-ad00-7d9b811a2c55_card.jpg
         * handImg : http://ecc-data.oss-cn-hongkong.aliyuncs.com/1e65ad84-ecc1-4534-b2cc-b4e1ffd6f93b_card.jpg
         * state : 0
         * limitNum : null
         * orderByCondition : null
         */

        private int type;
        private int id;
        private int userId;
        private String name;
        private Object gender;
        private String idCardNumber;
        private String side;
        private String frontUrl;
        private String backUrl;
        private String frontFilePath;
        private String backFilePath;
        private String handFilePath;
        private String handUrl;
        private String frontImg;
        private String backImg;
        private String handImg;
        private String state;
        private Object limitNum;
        private Object orderByCondition;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getIdCardNumber() {
            return idCardNumber;
        }

        public void setIdCardNumber(String idCardNumber) {
            this.idCardNumber = idCardNumber;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public String getFrontUrl() {
            return frontUrl;
        }

        public void setFrontUrl(String frontUrl) {
            this.frontUrl = frontUrl;
        }

        public String getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
        }

        public String getFrontFilePath() {
            return frontFilePath;
        }

        public void setFrontFilePath(String frontFilePath) {
            this.frontFilePath = frontFilePath;
        }

        public String getBackFilePath() {
            return backFilePath;
        }

        public void setBackFilePath(String backFilePath) {
            this.backFilePath = backFilePath;
        }

        public String getHandFilePath() {
            return handFilePath;
        }

        public void setHandFilePath(String handFilePath) {
            this.handFilePath = handFilePath;
        }

        public String getHandUrl() {
            return handUrl;
        }

        public void setHandUrl(String handUrl) {
            this.handUrl = handUrl;
        }

        public String getFrontImg() {
            return frontImg;
        }

        public void setFrontImg(String frontImg) {
            this.frontImg = frontImg;
        }

        public String getBackImg() {
            return backImg;
        }

        public void setBackImg(String backImg) {
            this.backImg = backImg;
        }

        public String getHandImg() {
            return handImg;
        }

        public void setHandImg(String handImg) {
            this.handImg = handImg;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getLimitNum() {
            return limitNum;
        }

        public void setLimitNum(Object limitNum) {
            this.limitNum = limitNum;
        }

        public Object getOrderByCondition() {
            return orderByCondition;
        }

        public void setOrderByCondition(Object orderByCondition) {
            this.orderByCondition = orderByCondition;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", userId=" + userId +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", idCardNumber='" + idCardNumber + '\'' +
                    ", side='" + side + '\'' +
                    ", frontUrl='" + frontUrl + '\'' +
                    ", backUrl='" + backUrl + '\'' +
                    ", frontFilePath='" + frontFilePath + '\'' +
                    ", backFilePath='" + backFilePath + '\'' +
                    ", handFilePath='" + handFilePath + '\'' +
                    ", handUrl='" + handUrl + '\'' +
                    ", frontImg='" + frontImg + '\'' +
                    ", backImg='" + backImg + '\'' +
                    ", handImg='" + handImg + '\'' +
                    ", state=" + state +
                    ", limitNum=" + limitNum +
                    ", orderByCondition=" + orderByCondition +
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
        dest.writeParcelable((Parcelable) this.data, flags);
    }

    public GetIDCardBean() {
    }

    protected GetIDCardBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetIDCardBean> CREATOR = new Parcelable.Creator<GetIDCardBean>() {
        @Override
        public GetIDCardBean createFromParcel(Parcel source) {
            return new GetIDCardBean(source);
        }

        @Override
        public GetIDCardBean[] newArray(int size) {
            return new GetIDCardBean[size];
        }
    };

    @Override
    public String toString() {
        return "GetIDCardBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
