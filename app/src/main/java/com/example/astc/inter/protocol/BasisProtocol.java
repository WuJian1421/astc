package com.example.astc.inter.protocol;

import com.example.astc.bean.AddMemoBean;
import com.example.astc.bean.AddUsersBean;
import com.example.astc.bean.AllCoinListBean;
import com.example.astc.bean.BaseBean;
import com.example.astc.bean.GetBalanceBean;
import com.example.astc.bean.GetCoinByNameBean;
import com.example.astc.bean.GetIDCardBean;
import com.example.astc.bean.GetMemoByUserNameBean;
import com.example.astc.bean.NewLoginBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * App基础请求
 * 2019-12-11
 *
 * @author
 */
public interface BasisProtocol {

    /**
     * 注册
     *
     * @param body
     * @return
     */
    @POST("addUsers")
    Call<AddUsersBean> addUsers(@Body RequestBody body);

    /**
     * 账号密码登录
     *
     * @param body
     * @return
     */
    @POST("newlogin")
    Call<NewLoginBean> newlogin(@Body RequestBody body);

    /**
     * 获取助记词
     *
     * @param data
     * @return
     */
    @POST("getMemoByUserName")
    Call<GetMemoByUserNameBean> getMemoByUserName(@Query("data") String data);

    /**
     * 助记词登录
     *
     * @param body
     * @return
     */
    @POST("memoLogin")
    Call<NewLoginBean> memoLogin(@Body RequestBody body);

    /**
     * 设置/修改交易密码
     *
     * @param data
     * @return
     */
    @POST("editDealPwd")
    Call<BaseBean> editDealPwd(@Query("data") String data);

    /**
     * 创建助记词
     *
     * @param body
     * @return
     */
    @POST("addMemo")
    Call<AddMemoBean> addMemo(@Body RequestBody body);

    /**
     * 退出钱包
     *
     * @param data
     * @return
     */
    @POST("logout")
    Call<BaseBean> logout(@Query("data") String data);

    /**
     * 查询个人认证
     *
     * @param data
     * @return
     */
    @POST("getIDCard")
    Call<GetIDCardBean> getIDCard(@Query("data") String data);

    /**
     * 修改登录密码
     *
     * @param data
     * @return
     */
    @POST("editPwd")
    Call<BaseBean> editPwd(@Query("data") String data);

    /**
     * 获取行情列表
     *
     * @param data
     * @return
     */
    @GET("allCoinList")
    Call<AllCoinListBean> allCoinList(@Query("data") String data);

    /**
     * 获取账户资产
     *
     * @param data
     * @return
     */
    @POST("getBalance")
    Call<GetBalanceBean> getBalance(@Query("data") String data);

    /**
     * 搜索币种
     *
     * @param coinName
     * @return
     */
    @GET("getCoinByName")
    Call<GetCoinByNameBean> getCoinByName(@Query("coinName") String coinName);

    /**
     * 绑定支付宝
     *
     * @param data
     * @param file
     * @return
     */
    @POST("bindApay")
    Call<BaseBean> bindApay(@Query("data") String data, @Query("apayPhoto") String file);

    /**
     * 绑定微信
     *
     * @param data
     * @param file
     * @return
     */
    @POST("bindWeChat")
    Call<BaseBean> bindWeChat(@Query("data") String data, @Query("weChatPhoto") String file);
}
