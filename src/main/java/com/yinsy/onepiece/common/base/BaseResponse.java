package com.yinsy.onepiece.common.base;

import com.yinsy.onepiece.common.constant.BaseConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class BaseResponse<T> {

    private Integer code;
    private String msg;
    private T data;

    public BaseResponse() {
        this.code = 200;
        this.msg = BaseConstant.SUCCESS;
    }

    public BaseResponse(T data) {
        this.code = 200;
        this.msg = BaseConstant.SUCCESS;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
