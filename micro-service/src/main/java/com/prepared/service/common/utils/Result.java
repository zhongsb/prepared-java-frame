/**
 * 
 */
package com.prepared.service.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微服务的返回结果对象
 *
 * @author z
 * @date 2019年12月03日
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Result", description = "返回结果对象")
public class Result<T> {

	/**
	 * 微服务结果状态码:0为成功,9为失败
	 */
	@ApiModelProperty(value = "微服务结果状态码:0为成功,9为失败", dataType = "int")
	private int code;

	/**
	 * 返回值信息：
	 * <p>
	 * code为0时，message为空；<br>
	 * code为9时，message为返回错误码和错误描述信息 ,格式:errorCode+”:”+ error,示例:10002:服务暂停
	 * <p>
	 * message定义<br>
	 * 错误代码 5位:<br>
	 * 第一位 表示错误级别 ; 1：系统级错误 ;2：服务级错误<br>
	 * 第二、三位 表示模块代码 00：共用模块; 10：数据统一管理; 20：数据血缘管理; 30：数据治理; 40：数据共享开放;*
	 * 50：数据服务;60：数据生命周期管理; 70：用户中心; <br>
	 * 第四、五位 表示具体功能代码 各模块自己定义，默认为25000<br>
	 */
	@ApiModelProperty(value = "code为0时,message为空; code为9时,message为返回错误码和错误描述信息", dataType = "String")
	private String message;

	/**
	 * 数据对象或集合， 单个对象为json对象，多个对象为json对象数组
	 */
	@ApiModelProperty(value = "返回数据对象", dataType = "T")
	private T data;

	/**
	 * 获取状态信息
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 配置状态信息
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 获取日志信息
	 * @return
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * 获取日志信息
	 * @return
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 获取返回数据对象
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * 设置返回数据对象
	 * @return
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 构造函数
	 */
	public Result(){
		super();
	}

	/**
	 * 构造函数，一般为正确信息返回
	 *
	 * @param code
	 * @param message
	 * @param data
	 *            void
	 * @author houxg
	 * @date 2019年4月22日
	 */
	public Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 构造函数，一般为正确信息返回
	 *
	 * @param code
	 * @param message
	 *            void
	 * @author houxg
	 * @date 2019年4月22日
	 */
	public Result(int code, String message) {
		this.code = code;
		this.message = message;
		this.data = null;
	}

	/**
	 * 返回成功信息
	 *
	 * @param data
	 *            成功信息对象
	 * @return Result
	 * @author houxg
	 * @date 2019年4月22日
	 */
	public static <T> Result<T> getSuccessResult(T data) {
		return new Result<>(0, "success", data);
	}

	/**
	 * 返回失败信息
	 *
	 * @param message
	 *            识别数据的描述
	 * @return Result
	 * @author houxg
	 * @date 2019年4月22日
	 */
	public static <T> Result<T> getErrorResult(String message) {
		return new Result<>(9, message);
	}

}
