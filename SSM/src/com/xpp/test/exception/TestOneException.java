package com.xpp.test.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

/**
 * 自定义异常
 * @author xpp
 *
 */
public class TestOneException extends RuntimeException{

	private static final long serialVersionUID = -1722712263718079706L;
	
	private String errorCode;
	
	public TestOneException(){
		super();
	}
	
	public TestOneException(String message){
		super(message);
	}

	public TestOneException(Throwable cause){
		super(cause);
	}

	public TestOneException(String errorCode, String message){
		super(message);
		this.errorCode = errorCode;
	}
	
	
	public TestOneException(String errorCode, String message, Throwable cause){
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	//捕获e.printStrackTrace()输出， 使用e.printStackTrace(PrintStream)方法，
//	将异常栈信息先输出到ByteOutputStream ，然后再将ByteOutputStream 转换为字符串，就获得了异常的完整输出
//	获取异常信息statckTrace
	public String getErrorStack(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bos);
		printStackTrace(ps);
		String errorStack = new String(bos.toByteArray(), Charset.defaultCharset());
		return errorStack;
	}
	
}
