package com.tuobuxie.response;
public enum ResultCode {

    SUCCESS_STATUS(100, "成功!"),
    NO_DATA_STATUS(200, "无数据!"),
    INTERFACE_BUSINESS_STATUS(300 , "调用接口业务错误!"),
    INTERFACE_ERROR_STATUS(400, "调用接口异常!"),
    TOKEN_ERROR(500,"token错误!"),
    TOKEN_OVERDUE(600,"token过期!");

    private int code;
    private String message;

    // 构造方法
    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

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

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    public static String getMessage(int code) {
        for (ResultCode c : ResultCode.values()) {
            if (c.getCode() == code) {
                return c.getMessage();
            }
        }
        return null;
    }

}