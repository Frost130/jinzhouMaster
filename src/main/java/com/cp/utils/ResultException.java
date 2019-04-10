/**
 * 
 */
package com.cp.utils;

/**返回异常
 * @author zheng
 *
 */
@SuppressWarnings("serial")
public class ResultException extends Exception {
	private ErrorDefine error;
    public ResultException(ErrorDefine errDefine)
    {
        super();
        error=errDefine;
    }
	public ErrorDefine getError() {
		return error;
	}
	@Override
	public String getMessage() {
		return "错误代码："+error.getErrCode()+" 错误信息："+error.getErrMsg();
		//return super.getMessage();
	}

}
