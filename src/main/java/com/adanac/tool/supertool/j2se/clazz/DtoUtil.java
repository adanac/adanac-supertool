package com.adanac.tool.supertool.j2se.clazz;

import com.adanac.framework.web.controller.BaseDto;

/**
 * DTO工具类
 * 
 * @author jwang
 * @date 2016年1月29日
 */
public final class DtoUtil {

	private DtoUtil() {
	}

	/**
	 * 实例化BaseDto对象
	 * 
	 * @param isSucessful
	 *            成功与否
	 * @param errorCode
	 *            错误代码
	 * @param errorMsg
	 *            错误描述
	 * @return BaseDto对象
	 * @see BaseDto
	 */
	public static BaseDto instanceBaseDto(boolean isSuccessful, String errorCode, String errorMsg) {
		return instanceBaseDto(isSuccessful, errorCode, errorMsg, null);
	}

	/**
	 * 实例化BaseDto对象(包含返回值)
	 * 
	 * @param isSucessful
	 *            成功与否
	 * @param errorCode
	 *            错误代码
	 * @param errorMsg
	 *            错误描述 携带的返回值
	 * @return 返回BaseDto对象
	 * @see BaseDto
	 */
	public static BaseDto instanceBaseDto(boolean isSuccessful, String errorCode, String errorMsg, String retVal) {
		BaseDto baseDto = new BaseDto();
		if (isSuccessful) {
			baseDto.setStatus(BaseDto.SUCCESS);
		} else {
			baseDto.setStatus(BaseDto.ERROR);
			baseDto.setErrorCode(errorCode);
			baseDto.setErrorMsg(errorMsg);
		}
		return baseDto;
	}
}
