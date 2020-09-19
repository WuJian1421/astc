package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 获取账户资产对象类
 * 2020-01-16
 *
 * @author
 */
public class GetBalanceBean implements Parcelable {

    /**
     * code : 200
     * message : success
     * page : null
     * data : {"mainBalance":0,"totalMoney":0,"langue":0,"balanceState":1,"userWallets":[{"lockBanlance":0,"id":1,"userId":1,"address":"axcf849ca30193e97271d087256a2ff33f3a51d238","date":1565768715000,"type":30,"state":1,"tradeState":1,"balance":0,"unbalance":0,"fakebalance":0,"totalBalance":0,"moneyRate":13.555041212039997,"coinName":"ASTC","coinType":0,"flag":"true","coinImg":"http://ecc-back2.oss-cn-beijing.aliyuncs.com/617f92f5-a509-4f4e-b919-9b1b483523ee_coinImg.jpg","version":6,"walletKey":"","walletAccount":"","tadeIndex":0}],"mainAddress":"axcf849ca30193e97271d087256a2ff33f3a51d238"}
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
         * mainBalance : 0
         * totalMoney : 0
         * langue : 0
         * balanceState : 1
         * userWallets : [{"lockBanlance":0,"id":1,"userId":1,"address":"axcf849ca30193e97271d087256a2ff33f3a51d238","date":1565768715000,"type":30,"state":1,"tradeState":1,"balance":0,"unbalance":0,"fakebalance":0,"totalBalance":0,"moneyRate":13.555041212039997,"coinName":"ASTC","coinType":0,"flag":"true","coinImg":"http://ecc-back2.oss-cn-beijing.aliyuncs.com/617f92f5-a509-4f4e-b919-9b1b483523ee_coinImg.jpg","version":6,"walletKey":"","walletAccount":"","tadeIndex":0}]
         * mainAddress : axcf849ca30193e97271d087256a2ff33f3a51d238
         */

        private int mainBalance;
        private int totalMoney;
        private int langue;
        private int balanceState;
        private String mainAddress;
        private List<UserWalletsBean> userWallets;

        public int getMainBalance() {
            return mainBalance;
        }

        public void setMainBalance(int mainBalance) {
            this.mainBalance = mainBalance;
        }

        public int getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(int totalMoney) {
            this.totalMoney = totalMoney;
        }

        public int getLangue() {
            return langue;
        }

        public void setLangue(int langue) {
            this.langue = langue;
        }

        public int getBalanceState() {
            return balanceState;
        }

        public void setBalanceState(int balanceState) {
            this.balanceState = balanceState;
        }

        public String getMainAddress() {
            return mainAddress;
        }

        public void setMainAddress(String mainAddress) {
            this.mainAddress = mainAddress;
        }

        public List<UserWalletsBean> getUserWallets() {
            return userWallets;
        }

        public void setUserWallets(List<UserWalletsBean> userWallets) {
            this.userWallets = userWallets;
        }

        public static class UserWalletsBean {
            /**
             * lockBanlance : 0
             * id : 1
             * userId : 1
             * address : axcf849ca30193e97271d087256a2ff33f3a51d238
             * date : 1565768715000
             * type : 30
             * state : 1
             * tradeState : 1
             * balance : 0
             * unbalance : 0
             * fakebalance : 0
             * totalBalance : 0
             * moneyRate : 13.555041212039997
             * coinName : ASTC
             * coinType : 0
             * flag : true
             * coinImg : http://ecc-back2.oss-cn-beijing.aliyuncs.com/617f92f5-a509-4f4e-b919-9b1b483523ee_coinImg.jpg
             * version : 6
             * walletKey :
             * walletAccount :
             * tadeIndex : 0
             */

            private int lockBanlance;
            private int id;
            private int userId;
            private String address;
            private long date;
            private int type;
            private int state;
            private int tradeState;
            private int balance;
            private int unbalance;
            private int fakebalance;
            private int totalBalance;
            private double moneyRate;
            private String coinName;
            private int coinType;
            private String flag;
            private String coinImg;
            private int version;
            private String walletKey;
            private String walletAccount;
            private int tadeIndex;

            public int getLockBanlance() {
                return lockBanlance;
            }

            public void setLockBanlance(int lockBanlance) {
                this.lockBanlance = lockBanlance;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getTradeState() {
                return tradeState;
            }

            public void setTradeState(int tradeState) {
                this.tradeState = tradeState;
            }

            public int getBalance() {
                return balance;
            }

            public void setBalance(int balance) {
                this.balance = balance;
            }

            public int getUnbalance() {
                return unbalance;
            }

            public void setUnbalance(int unbalance) {
                this.unbalance = unbalance;
            }

            public int getFakebalance() {
                return fakebalance;
            }

            public void setFakebalance(int fakebalance) {
                this.fakebalance = fakebalance;
            }

            public int getTotalBalance() {
                return totalBalance;
            }

            public void setTotalBalance(int totalBalance) {
                this.totalBalance = totalBalance;
            }

            public double getMoneyRate() {
                return moneyRate;
            }

            public void setMoneyRate(double moneyRate) {
                this.moneyRate = moneyRate;
            }

            public String getCoinName() {
                return coinName;
            }

            public void setCoinName(String coinName) {
                this.coinName = coinName;
            }

            public int getCoinType() {
                return coinType;
            }

            public void setCoinType(int coinType) {
                this.coinType = coinType;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getCoinImg() {
                return coinImg;
            }

            public void setCoinImg(String coinImg) {
                this.coinImg = coinImg;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getWalletKey() {
                return walletKey;
            }

            public void setWalletKey(String walletKey) {
                this.walletKey = walletKey;
            }

            public String getWalletAccount() {
                return walletAccount;
            }

            public void setWalletAccount(String walletAccount) {
                this.walletAccount = walletAccount;
            }

            public int getTadeIndex() {
                return tadeIndex;
            }

            public void setTadeIndex(int tadeIndex) {
                this.tadeIndex = tadeIndex;
            }

            @Override
            public String toString() {
                return "UserWalletsBean{" +
                        "lockBanlance=" + lockBanlance +
                        ", id=" + id +
                        ", userId=" + userId +
                        ", address='" + address + '\'' +
                        ", date=" + date +
                        ", type=" + type +
                        ", state=" + state +
                        ", tradeState=" + tradeState +
                        ", balance=" + balance +
                        ", unbalance=" + unbalance +
                        ", fakebalance=" + fakebalance +
                        ", totalBalance=" + totalBalance +
                        ", moneyRate=" + moneyRate +
                        ", coinName='" + coinName + '\'' +
                        ", coinType=" + coinType +
                        ", flag='" + flag + '\'' +
                        ", coinImg='" + coinImg + '\'' +
                        ", version=" + version +
                        ", walletKey='" + walletKey + '\'' +
                        ", walletAccount='" + walletAccount + '\'' +
                        ", tadeIndex=" + tadeIndex +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "mainBalance=" + mainBalance +
                    ", totalMoney=" + totalMoney +
                    ", langue=" + langue +
                    ", balanceState=" + balanceState +
                    ", mainAddress='" + mainAddress + '\'' +
                    ", userWallets=" + userWallets +
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

    public GetBalanceBean() {
    }

    protected GetBalanceBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetBalanceBean> CREATOR = new Parcelable.Creator<GetBalanceBean>() {
        @Override
        public GetBalanceBean createFromParcel(Parcel source) {
            return new GetBalanceBean(source);
        }

        @Override
        public GetBalanceBean[] newArray(int size) {
            return new GetBalanceBean[size];
        }
    };

    @Override
    public String toString() {
        return "GetBalanceBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", data=" + data +
                '}';
    }
}
