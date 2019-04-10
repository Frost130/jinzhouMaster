/**
 * ErrorMsg.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2016-3-19 下午1:53:14
 */
package com.cp.utils;

/**错误信息，即jsonresult中的errcode与errmsg的定义
 */
public enum ErrorDefine
{
    //int errcode;//0--成功,100--用户未登录，101--"用户名或密码不正确"，102--余额不足，103--积分不足
    //1000-1999--用户管理错误，2000-2999--crm错误，3000-3999--商品错误，4000-4999订单错误 5000-5999提现错误 6000-6999人员操作错误
    //String errmsg;//当errcode=0时，该值为ok或空,当errcode=其它值，具体的错误信息
	OK(1,"ok"),
	UNKNOWN_ERR(1,"未知错误"),
	SYSTEM_ERR(2,"系统错误"),
	TOO_BUSY_ERR(3,"系统太忙"),
	
	NETWORD_ERR(4,"网络错误"),
	PARAM_ERR(5,"参数错误"),
	MERCHANT_ERR(9,"商户不存在"),
	SIGN_ERR(10,"签名错误"),
	NOT_LOGIN_ERR(100,"未登录"),
	LOGIN_NAME_OR_PASSWORD_ERR(101,"用户名或密码不正确"),
	UNSUFFICIENT_FUNDS_ERR(102,"余额不足"),
	INVALID_VALUE_FOR_RECHARGE_ERR(103,"无效的充值额度"),
	THE_CONFIG_OF_TUNNEL_ERR(104,"支付通道配置错误"),
	RIGHT_LESS_ERR(110,"权限不足"),
	ALREADY_SIGNED_IN_ERR(120,"已签到"),//无需重复签到	
    DUPLICATE_PAY_ERR(101,"重复支付"),
    
    LOGIN_NAME_IS_EMPTY_ERR(1000,"登录名不能为空"),
    LOGIN_NAME_IS_EXISTED_ERR(1001,"登录名已存在"),
    PASSWORD_IS_EMPTY_ERR(1002,"密码不能为空"),
    NAME_IS_EMPTY_ERR(1003,"名称不能为空"),
    USER_TYPE_IS_EMPTY_ERR(1004,"用户类型不能为空"),
    OLD_PASSWORD_IS_EMPTY_ERR(1005,"原密码不能为空"),
    OLD_PASSWORD_IS_ERROR_ERR(1006,"原密码错误"),
	USER_TYPE_IS_NOT_MERCHANT_ERR(1007, "非代理商"),
	USER_STATE_IS_ERR(1008, "用户状态不正常"),
	USER_TYPE_IS_NOT_FINANCE_ERR(1009,"非财务人员"),
	USER_TYPE_IS_NOT_TREASURER_ERR(1010,"非财务主管"),
	USER_TYPE_IS_NOT_OPERATE_ERR(1011,"非运营人员"),
	USER_TYPE_IS_NOT_OPERATETION_MANAGER_ERR(1012,"非运营主管"),
	USER_TYPE_IS_NOT_ADMIN_ERR(1090,"非管理人员"),
    
    INVALID_ORDER_ERR(4000,"订单无效（可能订单不存在，也可能支付金额和实际要支付的金额不符）"),
    GEN_ORDER_FAIL(4001,"生成订单失败"),
    DUPLICATE_ORDER_ERR(4002,"重复生成订单"),
    ORDER_IS_PAYED(4003,"订单已支付，无需再次支付"),
    ORDER_ISNOT_WAITINGPAY_(4004,"订单不是待支付状态，无法支付"),
    
    WITHDRAW_MONEY_IS_EMPTY_ERR(5000,"提现金额不能为空"),
    BANK_NAME_IS_ERROR_ERR(5001,"银行名称错误"),
    CARD_ID_IS_ERROR_ERR(5002,"银行卡号错误"),
    RECEIVER_IS_EMPTY_ERR(5003,"收款人不能为空"),
    WITHDRAW_IP_IS_ERROR_ERR(5004,"IP地址异常"),
    MAX_TIMES_IS_FULL_ERR(5005,"今日提现次数已满"),
    WITHDRAW_LOVER_LIMIT_IS_SMALL_ERR(5006,"提现金额过小"),
    WITHDRAW_UPPER_LIMIT_IS_BIG_ERR(5007,"提现金额过大"),
    WITHDRAW_PASSWORD_IS_ERROR_ERR(5008,"提现密码错误"),
    WITHDRAW_BANLANCE_IS_ERROR_ERR(5009,"提现失败"),
    WITHDRAW_TUNNELID_IS_ERROR_ERR(5010,"提现通道号错误"),
    
    WITHDRAW_TIME_IS_EMPTY_ERR(6000,"提现时间数据错误"),
    USER_ID_IS_EMPTY_ERR(6001,"ID数据错误"),
    PAYED_USER_ID_IS_EMPTY_ERR(6002,"打款人不能为空"),
    PAYED_TIME_IS_EMPTY_ERR(6003,"打款时间不能为空"),
    REMARK_IS_EMPTY_ERR(6004,"备注不能为空"),
    CASH_AUDIT_IS_ERROR_ERR(6005,"审核错误"),
    FROZEN_MONEY_IS_ERROR_ERR(6006,"冻结金额错误"),
    ADJUST_MONEY_IS_ERROR_ERR(6007,"调整金额错误"),
    ADJUST_MONEY_IS_BIG_ERR(6008,"调整金额过大"),
    PURPOSE_IS_EMPTY_ERR(6009,"结算类型为空"),
    ADJUST_IS_ERROR_ERR(6010,"调整错误"),
    TUNNEL_BIND_IS_ERROR_ERR(6011,"通道绑定错误"),
    TRADE_ORDERNO_IS_EMPTY_ERR(6012,"交易订单号为空"),
    ORDERNO_IS_EMPTY_ERR(6013,"订单号为空"),
    MERCHANT_ORDERNO_IS_EMPTY_ERR(6014,"商户订单号为空"),
    HAND_EXCEPTION_ORDER_IS_ERROR_ERR(6015,"异常订单处理错误"),
    SECRETKEY_IS_ERROR_ERROR_ERR(6016,"密钥长度不够32位"),
    
	TIME_FORMAT_IS_ERROR(7001, "时间格式错误"),
    
    ERR_HIGH(0xffff,"错误上限，无意义");
    
    
    /**
     * errcode ：0--成功,其它值由错误文件定义 
     */
    private int errCode;
    /**
     * 当errcode=0时，该值为ok或空,当errcode=其它值，具体的错误信息由错误文件定义
     */
    private String errMsg;
    
    private ErrorDefine(int errCode,String errMsg)
    {
    	this.errCode=errCode;
    	this.errMsg=errMsg;
    }

	public int getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}
    
    //int errcode;//0--成功,100--用户未登录，101--"用户名或密码不正确"，102--余额不足，103--积分不足
    //1000-1999--用户管理错误，2000-2999--crm错误，3000-3999--商品错误，4000-4999订单错误
    //String errmsg;//当errcode=0时，该值为ok或空,当errcode=其它值，具体的错误信息
    /*
    public final static String ok_0="ok";
    public final static String network_err_10="网络错误";
    public final static String param_err_11="参数错误";//一般参数错误
    
    public final static String not_login_100="未登录";
    public final static String loginName_or_password_incorrect_101="用户名或密码不正确";
    public final static String not_sufficient_funds_102="余额不足";
    public final static String invalid_value_for_recharge_103="无效的充值额度";
    public final static String the_config_of_gateway_is_error_104="支付网关配置错误";
    public final static String recharge_must_in_weixin_105="只能在微信中充值";
    public final static String right_less_110="无权限";
    public final static String already_sign_in_120="已签到";//无需重复签到
    public final static String cannot_find_weixin_account_200="找不到微信账号配置";//无需重复签到
    
    public final static String consignee_name_is_empty_1100="收件人为空";
    public final static String consignee_phone_is_empty_1101="收件人手机号码为空";
    public final static String consignee_address_is_empty_1102="收件地址为空";
    
    public final static String invalid_ball_3000="无效球赛";
    public final static String invalid_bet_option_3001="投注项无效";
    public final static String invalid_bet_money_3002="投注额无效";
    public final static String invalid_state_for_bet_3003="当前已不可投注";
    public final static String fail_for_unkown_reaason_3004="未知原因失败";
    public final static String odds_changed_3005="赔率已变化";
    
    public final static String invalid_order_4000="订单无效（可能订单不存在，也可能支付金额和实际要支付的金额不符）";
    public final static String gen_order_fail_4001="生成订单失败";
    public final static String duplicate_order_4002="重复生成订单";
    public final static String order_is_payed_4003="订单已支付，无需再次支付";
    public final static String order_isnot_waitingpay_4004="订单不是待支付状态，无法支付";
    */
}
