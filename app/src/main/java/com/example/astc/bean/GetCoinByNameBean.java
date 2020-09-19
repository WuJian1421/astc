package com.example.astc.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索币种对象类
 * 2020-01-14
 *
 * @author
 */
public class GetCoinByNameBean implements Parcelable {

    /**
     * code : 200
     * message : success
     * page : null
     * data : [{"date":"2019-08-30 13:00:00","changeMinNum":0,"feeCore":"","unlockRatio":0.5,"marketPrice":14.18,"fee":0.08,"walletState":0,"contractAddress":"","klineState":0,"changeFee":0,"maxFee":0.002,"coinNo":30,"unlockDay":1,"contractAddressWei":0,"unlockState":1,"quota":1000,"tradeMinPrice":0.1,"id":3,"state":1,"coinImg":"http://ecc-back2.oss-cn-beijing.aliyuncs.com/617f92f5-a509-4f4e-b919-9b1b483523ee_coinImg.jpg","coinPrice":0,"pntRatio":0.01,"coinPriceBySys":0,"freePrice":0.5,"coinBlock":0,"minFee":0.001,"changeState":0,"maximum":8,"coinName":"ASTC","apiType":"ASTCAPI"}]
     */

    private int code;
    private String message;
    private Object page;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * date : 2019-08-30 13:00:00
         * changeMinNum : 0
         * feeCore :
         * unlockRatio : 0.5
         * marketPrice : 14.18
         * fee : 0.08
         * walletState : 0
         * contractAddress :
         * klineState : 0
         * changeFee : 0
         * maxFee : 0.002
         * coinNo : 30
         * unlockDay : 1
         * contractAddressWei : 0
         * unlockState : 1
         * quota : 1000
         * tradeMinPrice : 0.1
         * id : 3
         * state : 1
         * coinImg : http://ecc-back2.oss-cn-beijing.aliyuncs.com/617f92f5-a509-4f4e-b919-9b1b483523ee_coinImg.jpg
         * coinPrice : 0
         * pntRatio : 0.01
         * coinPriceBySys : 0
         * freePrice : 0.5
         * coinBlock : 0
         * minFee : 0.001
         * changeState : 0
         * maximum : 8
         * coinName : ASTC
         * apiType : ASTCAPI
         */

        private String date;
        private int changeMinNum;
        private String feeCore;
        private double unlockRatio;
        private double marketPrice;
        private double fee;
        private int walletState;
        private String contractAddress;
        private int klineState;
        private int changeFee;
        private double maxFee;
        private int coinNo;
        private int unlockDay;
        private int contractAddressWei;
        private int unlockState;
        private int quota;
        private double tradeMinPrice;
        private int id;
        private int state;
        private String coinImg;
        private int coinPrice;
        private double pntRatio;
        private int coinPriceBySys;
        private double freePrice;
        private int coinBlock;
        private double minFee;
        private int changeState;
        private int maximum;
        private String coinName;
        private String apiType;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getChangeMinNum() {
            return changeMinNum;
        }

        public void setChangeMinNum(int changeMinNum) {
            this.changeMinNum = changeMinNum;
        }

        public String getFeeCore() {
            return feeCore;
        }

        public void setFeeCore(String feeCore) {
            this.feeCore = feeCore;
        }

        public double getUnlockRatio() {
            return unlockRatio;
        }

        public void setUnlockRatio(double unlockRatio) {
            this.unlockRatio = unlockRatio;
        }

        public double getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(double marketPrice) {
            this.marketPrice = marketPrice;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public int getWalletState() {
            return walletState;
        }

        public void setWalletState(int walletState) {
            this.walletState = walletState;
        }

        public String getContractAddress() {
            return contractAddress;
        }

        public void setContractAddress(String contractAddress) {
            this.contractAddress = contractAddress;
        }

        public int getKlineState() {
            return klineState;
        }

        public void setKlineState(int klineState) {
            this.klineState = klineState;
        }

        public int getChangeFee() {
            return changeFee;
        }

        public void setChangeFee(int changeFee) {
            this.changeFee = changeFee;
        }

        public double getMaxFee() {
            return maxFee;
        }

        public void setMaxFee(double maxFee) {
            this.maxFee = maxFee;
        }

        public int getCoinNo() {
            return coinNo;
        }

        public void setCoinNo(int coinNo) {
            this.coinNo = coinNo;
        }

        public int getUnlockDay() {
            return unlockDay;
        }

        public void setUnlockDay(int unlockDay) {
            this.unlockDay = unlockDay;
        }

        public int getContractAddressWei() {
            return contractAddressWei;
        }

        public void setContractAddressWei(int contractAddressWei) {
            this.contractAddressWei = contractAddressWei;
        }

        public int getUnlockState() {
            return unlockState;
        }

        public void setUnlockState(int unlockState) {
            this.unlockState = unlockState;
        }

        public int getQuota() {
            return quota;
        }

        public void setQuota(int quota) {
            this.quota = quota;
        }

        public double getTradeMinPrice() {
            return tradeMinPrice;
        }

        public void setTradeMinPrice(double tradeMinPrice) {
            this.tradeMinPrice = tradeMinPrice;
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

        public String getCoinImg() {
            return coinImg;
        }

        public void setCoinImg(String coinImg) {
            this.coinImg = coinImg;
        }

        public int getCoinPrice() {
            return coinPrice;
        }

        public void setCoinPrice(int coinPrice) {
            this.coinPrice = coinPrice;
        }

        public double getPntRatio() {
            return pntRatio;
        }

        public void setPntRatio(double pntRatio) {
            this.pntRatio = pntRatio;
        }

        public int getCoinPriceBySys() {
            return coinPriceBySys;
        }

        public void setCoinPriceBySys(int coinPriceBySys) {
            this.coinPriceBySys = coinPriceBySys;
        }

        public double getFreePrice() {
            return freePrice;
        }

        public void setFreePrice(double freePrice) {
            this.freePrice = freePrice;
        }

        public int getCoinBlock() {
            return coinBlock;
        }

        public void setCoinBlock(int coinBlock) {
            this.coinBlock = coinBlock;
        }

        public double getMinFee() {
            return minFee;
        }

        public void setMinFee(double minFee) {
            this.minFee = minFee;
        }

        public int getChangeState() {
            return changeState;
        }

        public void setChangeState(int changeState) {
            this.changeState = changeState;
        }

        public int getMaximum() {
            return maximum;
        }

        public void setMaximum(int maximum) {
            this.maximum = maximum;
        }

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public String getApiType() {
            return apiType;
        }

        public void setApiType(String apiType) {
            this.apiType = apiType;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.date);
            dest.writeInt(this.changeMinNum);
            dest.writeString(this.feeCore);
            dest.writeDouble(this.unlockRatio);
            dest.writeDouble(this.marketPrice);
            dest.writeDouble(this.fee);
            dest.writeInt(this.walletState);
            dest.writeString(this.contractAddress);
            dest.writeInt(this.klineState);
            dest.writeInt(this.changeFee);
            dest.writeDouble(this.maxFee);
            dest.writeInt(this.coinNo);
            dest.writeInt(this.unlockDay);
            dest.writeInt(this.contractAddressWei);
            dest.writeInt(this.unlockState);
            dest.writeInt(this.quota);
            dest.writeDouble(this.tradeMinPrice);
            dest.writeInt(this.id);
            dest.writeInt(this.state);
            dest.writeString(this.coinImg);
            dest.writeInt(this.coinPrice);
            dest.writeDouble(this.pntRatio);
            dest.writeInt(this.coinPriceBySys);
            dest.writeDouble(this.freePrice);
            dest.writeInt(this.coinBlock);
            dest.writeDouble(this.minFee);
            dest.writeInt(this.changeState);
            dest.writeInt(this.maximum);
            dest.writeString(this.coinName);
            dest.writeString(this.apiType);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.date = in.readString();
            this.changeMinNum = in.readInt();
            this.feeCore = in.readString();
            this.unlockRatio = in.readDouble();
            this.marketPrice = in.readDouble();
            this.fee = in.readDouble();
            this.walletState = in.readInt();
            this.contractAddress = in.readString();
            this.klineState = in.readInt();
            this.changeFee = in.readInt();
            this.maxFee = in.readDouble();
            this.coinNo = in.readInt();
            this.unlockDay = in.readInt();
            this.contractAddressWei = in.readInt();
            this.unlockState = in.readInt();
            this.quota = in.readInt();
            this.tradeMinPrice = in.readDouble();
            this.id = in.readInt();
            this.state = in.readInt();
            this.coinImg = in.readString();
            this.coinPrice = in.readInt();
            this.pntRatio = in.readDouble();
            this.coinPriceBySys = in.readInt();
            this.freePrice = in.readDouble();
            this.coinBlock = in.readInt();
            this.minFee = in.readDouble();
            this.changeState = in.readInt();
            this.maximum = in.readInt();
            this.coinName = in.readString();
            this.apiType = in.readString();
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
                    ", changeMinNum=" + changeMinNum +
                    ", feeCore='" + feeCore + '\'' +
                    ", unlockRatio=" + unlockRatio +
                    ", marketPrice=" + marketPrice +
                    ", fee=" + fee +
                    ", walletState=" + walletState +
                    ", contractAddress='" + contractAddress + '\'' +
                    ", klineState=" + klineState +
                    ", changeFee=" + changeFee +
                    ", maxFee=" + maxFee +
                    ", coinNo=" + coinNo +
                    ", unlockDay=" + unlockDay +
                    ", contractAddressWei=" + contractAddressWei +
                    ", unlockState=" + unlockState +
                    ", quota=" + quota +
                    ", tradeMinPrice=" + tradeMinPrice +
                    ", id=" + id +
                    ", state=" + state +
                    ", coinImg='" + coinImg + '\'' +
                    ", coinPrice=" + coinPrice +
                    ", pntRatio=" + pntRatio +
                    ", coinPriceBySys=" + coinPriceBySys +
                    ", freePrice=" + freePrice +
                    ", coinBlock=" + coinBlock +
                    ", minFee=" + minFee +
                    ", changeState=" + changeState +
                    ", maximum=" + maximum +
                    ", coinName='" + coinName + '\'' +
                    ", apiType='" + apiType + '\'' +
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
        dest.writeList(this.data);
    }

    public GetCoinByNameBean() {
    }

    protected GetCoinByNameBean(Parcel in) {
        this.code = in.readInt();
        this.message = in.readString();
        this.page = in.readParcelable(Object.class.getClassLoader());
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<GetCoinByNameBean> CREATOR = new Parcelable.Creator<GetCoinByNameBean>() {
        @Override
        public GetCoinByNameBean createFromParcel(Parcel source) {
            return new GetCoinByNameBean(source);
        }

        @Override
        public GetCoinByNameBean[] newArray(int size) {
            return new GetCoinByNameBean[size];
        }
    };
}
