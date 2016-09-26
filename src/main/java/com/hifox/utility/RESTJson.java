package com.hifox.utility;

import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lihao on 2016/6/21.
 */
public class RESTJson implements Serializable {

    private Object data;
    private String message;
    private int status;
    private Date timestamp = new Date();

    public RESTJson(Object data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Object getData() {
    	if(0 != this.status)
    		return null;
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int error) {
        this.status = error;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public static RESTJson done(){
        return new RESTJson(null,"",ResponseStatus.OK);
    }

    public static RESTJson done(Object data,String message){
        return new RESTJson(data,message,ResponseStatus.OK);
    }

    public static RESTJson done(String message){
        return new RESTJson(null,message,ResponseStatus.OK);
    }

    public static RESTJson fail(int error,String message){
        return new RESTJson(null,message,error);
    }

    public static RESTJson fieldErrorFail(String message){
        return new RESTJson(null,message, ResponseStatus.FIELD_ERROR);
    }

    public static RESTJson fieldErrorFail(FieldError fieldError){
        return new RESTJson(null,String.format("%s : %s",fieldError.getField(),fieldError.getDefaultMessage()), ResponseStatus.FIELD_ERROR);
    }

    @Override
    public String toString() {
        return "RESTJson{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
