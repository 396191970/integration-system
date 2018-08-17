package com.tuobuxie.response;
public class ResponseMessage<T> {

	private int code;
	private boolean state;
	private T data;
	private String message;

	public ResponseMessage() {

	}

	public ResponseMessage(boolean state) {
		this.state = state;
		this.code = getCodeByResult(state);
	}

	public ResponseMessage(boolean state, String message) {
		this.state = state;
		this.code = getCodeByResult(state);
		this.message = message;
	}

	public ResponseMessage(int code, boolean state, String message) {
		this.code = code;
		this.state = state;
		this.message = message;
	}

	public ResponseMessage<T> error(String message) {
		return new ResponseMessage<T>(false, message);
	}

	public ResponseMessage<T> success(String message) {
		return new ResponseMessage<T>(true, message);
	}

	public ResponseMessage<T> success(String message, T data) {
		ResponseMessage<T> responseMessage = new ResponseMessage<T>(true, message);
		responseMessage.setData(data);
		return responseMessage;
	}

	public ResponseMessage<T> success(T data) {
		ResponseMessage<T> responseMessage = new ResponseMessage<T>(true);
		responseMessage.setData(data);
		return responseMessage;
	}

	private int getCodeByResult(boolean state) {
		return state ? ResultCode.SUCCESS_STATUS.getCode() : ResultCode.NO_DATA_STATUS.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}