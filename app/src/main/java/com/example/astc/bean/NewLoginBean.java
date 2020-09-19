package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 登录
 * 2019-12-19
 *
 * @author
 */
public class NewLoginBean implements Parcelable {

    /**
     * code : 200
     * message : success
     * page : null
     * data : {"date":"2019-08-22 15:33:21","apayUrl":"","address":"","weChatUrl":"","signStatus":2,"photo":"","tradePassword":"","tradePasswordState":1,"apay":"","certificationStatus":0,"timeout":"2019-08-22 15:37:03","token":"9de9e8f8c4914469ae483bd470eb5da4","password":"","phone":"","ptnaddress":"axdb186012fc2b71e75a0ec82420cb2c636ba671b4","nickname":"zhangsan123","weChat":"","id":15,"state":1,"isExist":true,"invitationCode":"GNHLCC","username":"zhangsan123"}
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
         * date : 2019-08-22 15:33:21
         * apayUrl :
         * address :
         * weChatUrl :
         * signStatus : 2
         * photo :
         * tradePassword :
         * tradePasswordState : 1
         * apay :
         * certificationStatus : 0
         * timeout : 2019-08-22 15:37:03
         * token : 9de9e8f8c4914469ae483bd470eb5da4
         * password :
         * phone :
         * ptnaddress : axdb186012fc2b71e75a0ec82420cb2c636ba671b4
         * nickname : zhangsan123
         * weChat :
         * id : 15
         * state : 1
         * isExist : true
         * invitationCode : GNHLCC
         * username : zhangsan123
         */

        private String date;
        private String apayUrl;
        private String address;
        private String weChatUrl;
        private int signStatus;
        private String photo;
        private String tradePassword;
        private int tradePasswordState;
        private String apay;
        private int certificationStatus;
        private String timeout;
        private String token;
        private String password;
        private String phone;
        private String ptnaddress;
        private String nickname;
        private String weChat;
        private int id;
        private int state;
        private boolean isExist;
        private String invitationCode;
        private String username;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getApayUrl() {
            return apayUrl;
        }

        public void setApayUrl(String apayUrl) {
            this.apayUrl = apayUrl;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWeChatUrl() {
            return weChatUrl;
        }

        public void setWeChatUrl(String weChatUrl) {
            this.weChatUrl = weChatUrl;
        }

        public int getSignStatus() {
            return signStatus;
        }

        public void setSignStatus(int signStatus) {
            this.signStatus = signStatus;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTradePassword() {
            return tradePassword;
        }

        public void setTradePassword(String tradePassword) {
            this.tradePassword = tradePassword;
        }

        public int getTradePasswordState() {
            return tradePasswordState;
        }

        public void setTradePasswordState(int tradePasswordState) {
            this.tradePasswordState = tradePasswordState;
        }

        public String getApay() {
            return apay;
        }

        public void setApay(String apay) {
            this.apay = apay;
        }

        public int getCertificationStatus() {
            return certificationStatus;
        }

        public void setCertificationStatus(int certificationStatus) {
            this.certificationStatus = certificationStatus;
        }

        public String getTimeout() {
            return timeout;
        }

        public void setTimeout(String timeout) {
            this.timeout = timeout;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPtnaddress() {
            return ptnaddress;
        }

        public void setPtnaddress(String ptnaddress) {
            this.ptnaddress = ptnaddress;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getWeChat() {
            return weChat;
        }

        public void setWeChat(String weChat) {
            this.weChat = weChat;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public boolean isIsExist() {
            return isExist;
        }

        public void setIsExist(boolean isExist) {
            this.isExist = isExist;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.date);
            dest.writeString(this.apayUrl);
            dest.writeString(this.address);
            dest.writeString(this.weChatUrl);
            dest.writeInt(this.signStatus);
            dest.writeString(this.photo);
            dest.writeString(this.tradePassword);
            dest.writeInt(this.tradePasswordState);
            dest.writeString(this.apay);
            dest.writeInt(this.certificationStatus);
            dest.writeString(this.timeout);
            dest.writeString(this.token);
            dest.writeString(this.password);
            dest.writeString(this.phone);
            dest.writeString(this.ptnaddress);
            dest.writeString(this.nickname);
            dest.writeString(this.weChat);
            dest.writeInt(this.id);
            dest.writeInt(this.state);
            dest.writeByte(this.isExist ? (byte) 1 : (byte) 0);
            dest.writeString(this.invitationCode);
            dest.writeString(this.username);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.date = in.readString();
            this.apayUrl = in.readString();
            this.address = in.readString();
            this.weChatUrl = in.readString();
            this.signStatus = in.readInt();
            this.photo = in.readString();
            this.tradePassword = in.readString();
            this.tradePasswordState = in.readInt();
            this.apay = in.readString();
            this.certificationStatus = in.readInt();
            this.timeout = in.readString();
            this.token = in.readString();
            this.password = in.readString();
            this.phone = in.readString();
            this.ptnaddress = in.readString();
            this.nickname = in.readString();
            this.weChat = in.readString();
            this.id = in.readInt();
            this.state = in.readInt();
            this.isExist = in.readByte() != 0;
            this.invitationCode = in.readString();
            this.username = in.readString();
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
                    "date='" + date + '\'' +
                    ", apayUrl='" + apayUrl + '\'' +
                    ", address='" + address + '\'' +
                    ", weChatUrl='" + weChatUrl + '\'' +
                    ", signStatus=" + signStatus +
                    ", photo='" + photo + '\'' +
                    ", tradePassword='" + tradePassword + '\'' +
                    ", tradePasswordState=" + tradePasswordState +
                    ", apay='" + apay + '\'' +
                    ", certificationStatus=" + certificationStatus +
                    ", timeout='" + timeout + '\'' +
                    ", token='" + token + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", ptnaddress='" + ptnaddress + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", weChat='" + weChat + '\'' +
                    ", id=" + id +
                    ", state=" + state +
                    ", isExist=" + isExist +
                    ", invitationCode='" + invitationCode + '\'' +
                    ", username='" + username + '\'' +
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

    public NewLoginBean() {
    }

    protected NewLoginBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewLoginBean> CREATOR = new Parcelable.Creator<NewLoginBean>() {
        @Override
        public NewLoginBean createFromParcel(Parcel source) {
            return new NewLoginBean(source);
        }

        @Override
        public NewLoginBean[] newArray(int size) {
            return new NewLoginBean[size];
        }
    };

    @Override
    public String toString() {
        return "NewLoginBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
