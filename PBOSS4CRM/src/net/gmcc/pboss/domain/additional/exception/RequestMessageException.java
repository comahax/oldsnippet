package net.gmcc.pboss.domain.additional.exception;

/**
 * 这个类只是一个标识，标识请求报文格式校验不能通过
 * 对应错误类型：600 888001 参数完整性校验
 */
public class RequestMessageException extends Exception {
	public RequestMessageException(){
		super();
	}
	
	public RequestMessageException(String message){
		super(message);
	}
}
