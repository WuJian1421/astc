package com.example.astc.bean;

import java.util.List;

/**
 * 获取行情列表
 * 2020-01-04
 *
 * @author
 */
public class AllCoinListBean {

    /**
     * code : 200
     * message : success
     * page : null
     * data : [{"date":"2019-04-08 00:00:00","changeMinNum":0,"feeCore":"","unlockRatio":0.5,"marketPrice":64800.99,"fee":0,"walletState":0,"contractAddress":"","klineState":0,"changeFee":0,"maxFee":0,"coinNo":10,"unlockDay":2,"contractAddressWei":0,"unlockState":1,"quota":1000,"tradeMinPrice":30000,"id":1,"state":0,"coinImg":"http://ecc-back2.oss-cn-beijing.aliyuncs.com/ebcc2074-2e28-474c-8bf4-72df3feab0f5_coinImg.jpg","coinPrice":9203.3785,"pntRatio":0.01,"coinPriceBySys":64800.988088909995,"freePrice":0.5,"coinBlock":0,"minFee":1.0E-4,"changeState":0,"maximum":5,"coinName":"BTC","apiType":"BTCAPI"},{"date":"2018-12-14 00:00:00","changeMinNum":0,"feeCore":"","unlockRatio":0.5,"marketPrice":1286.92,"fee":1.0E-4,"walletState":0,"contractAddress":"","klineState":0,"changeFee":0,"maxFee":0.002,"coinNo":20,"unlockDay":1,"contractAddressWei":0,"unlockState":1,"quota":1000,"tradeMinPrice":2000,"id":2,"state":0,"coinImg":"http://ecc-back2.oss-cn-beijing.aliyuncs.com/d5c15341-b9ad-4cac-8f37-2c907028331c_coinImg.jpg","coinPrice":182.7756,"pntRatio":0.01,"coinPriceBySys":1286.92292919,"freePrice":0.5,"coinBlock":0,"minFee":0.001,"changeState":0,"maximum":5,"coinName":"ETH","apiType":"ETHAPI"}]
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

    public static class DataBean {
        /**
         * date : 2019-04-08 00:00:00
         * changeMinNum : 0
         * feeCore :
         * unlockRatio : 0.5
         * marketPrice : 64800.99
         * fee : 0
         * walletState : 0
         * contractAddress :
         * klineState : 0
         * changeFee : 0
         * maxFee : 0
         * coinNo : 10
         * unlockDay : 2
         * contractAddressWei : 0
         * unlockState : 1
         * quota : 1000
         * tradeMinPrice : 30000
         * id : 1
         * state : 0
         * coinImg : http://ecc-back2.oss-cn-beijing.aliyuncs.com/ebcc2074-2e28-474c-8bf4-72df3feab0f5_coinImg.jpg
         * coinPrice : 9203.3785
         * pntRatio : 0.01
         * coinPriceBySys : 64800.988088909995
         * freePrice : 0.5
         * coinBlock : 0
         * minFee : 1.0E-4
         * changeState : 0
         * maximum : 5
         * coinName : BTC
         * apiType : BTCAPI
         */

        private String date;
        private int changeMinNum;
        private String feeCore;
        private double unlockRatio;
        private double marketPrice;
        private int fee;
        private int walletState;
        private String contractAddress;
        private int klineState;
        private int changeFee;
        private int maxFee;
        private int coinNo;
        private int unlockDay;
        private int contractAddressWei;
        private int unlockState;
        private int quota;
        private int tradeMinPrice;
        private int id;
        private int state;
        private String coinImg;
        private double coinPrice;
        private double pntRatio;
        private double coinPriceBySys;
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

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
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

        public int getMaxFee() {
            return maxFee;
        }

        public void setMaxFee(int maxFee) {
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

        public int getTradeMinPrice() {
            return tradeMinPrice;
        }

        public void setTradeMinPrice(int tradeMinPrice) {
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

        public double getCoinPrice() {
            return coinPrice;
        }

        public void setCoinPrice(double coinPrice) {
            this.coinPrice = coinPrice;
        }

        public double getPntRatio() {
            return pntRatio;
        }

        public void setPntRatio(double pntRatio) {
            this.pntRatio = pntRatio;
        }

        public double getCoinPriceBySys() {
            return coinPriceBySys;
        }

        public void setCoinPriceBySys(double coinPriceBySys) {
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
    }
}
