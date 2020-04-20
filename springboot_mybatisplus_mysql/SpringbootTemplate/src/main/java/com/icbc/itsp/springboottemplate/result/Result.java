package com.icbc.itsp.springboottemplate.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int retCode = CodeConstant.RETCODE_200;
    private String status = CodeConstant.STATUS_SUCCESS;
    private String msg = "";
    private T results;
    private long total = 0;
    private String countDate;

    public Result(){}

    public void setFailedMsg(String msg){
        this.msg = msg;
        this.status = CodeConstant.STATUS_FAILED;
        this.retCode = CodeConstant.RETCODE_500;
    }

    public void setSuccessMsg(String msg){
        this.msg = msg;
        this.status = CodeConstant.STATUS_SUCCESS;
        this.retCode = CodeConstant.RETCODE_200;
    }

    public void setErrorMsg(String msg){
        this.msg = msg;
        this.status = CodeConstant.STATUS_ERROR;
        this.retCode = CodeConstant.RETCODE_500;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode=" + retCode +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", results=" + results +
                ", total=" + total +
                ", countDate='" + countDate + '\'' +
                '}';
    }
}
