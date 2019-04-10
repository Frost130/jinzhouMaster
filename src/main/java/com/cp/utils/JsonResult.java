/**
 * JsonResult.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2016-3-18 下午5:31:53
 */
package com.cp.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Description: api响应的json数据结构格式，它由错误代码、错误描述、实际的数据内容三部分组成
 */
public class JsonResult
{
    /**
     * errcode ：0--成功,其它值由错误文件定义 
     */
    int errcode;
    /**
     * 当errcode=0时，该值为ok或空,当errcode=其它值，具体的错误信息由错误文件定义
     */
    String errmsg;
    /**
     * 需返回前端的数据
     */
    Object data;
    /**
     * 需返回前端的总数据条数
     */
    int totalNum;
    public JsonResult(int errcode, String errmsg)
    {
        super();
        this.errcode = errcode;
        this.errmsg = errmsg;
    }
   public JsonResult(int errcode, String errmsg, Object data)
    {
        super();
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }
   public JsonResult(ErrorDefine errDefine)
   {
       super();
       this.errcode = errDefine.getErrCode();
       this.errmsg = errDefine.getErrMsg();
   }
  public JsonResult(ErrorDefine errDefine, Object data)
   {
       super();
       this.errcode = errDefine.getErrCode();
       this.errmsg = errDefine.getErrMsg();
       this.data = data;
   }
    public JsonResult(Object data)
    {
        super();
        errcode=0;
        this.data = data;
    }
    public JsonResult(Object data,int totalNum)
    {
        super();
        errcode=0;
        this.data = data;
        this.totalNum = totalNum;
    }
    public JsonResult()
    {
        super();
        errcode=0;
        this.data = null;
    }
   public int getErrcode()
    {
        return errcode;
    }
    public void setErrcode(int errcode)
    {
        this.errcode = errcode;
    }
    public String getErrmsg()
    {
        return errmsg;
    }
    public void setErrmsg(String errmsg)
    {
        this.errmsg = errmsg;
    }
    public Object getData()
    {
        return data;
    }
    public void setData(Object data)
    {
        this.data = data;
    }
    
    public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	static public JsonResult from(String strJson) throws JsonParseException, JsonMappingException, IOException
    {
        ObjectMapper mapp=new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapp.readValue(strJson, JsonResult.class);                    
    }
    static public String toJSonStr(Object data)
    {
        ObjectMapper mapp=new ObjectMapper().setSerializationInclusion(Include.NON_NULL);;
        try {
			return mapp.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        return null;
   	
    }
    
    @Override
	public String toString() {
		return "JsonResult [errcode=" + errcode + ", errmsg=" + errmsg + ", data=" + data + ", totalNum=" + totalNum
				+ "]";
	}
}
