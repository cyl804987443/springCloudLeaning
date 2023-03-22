package com.alongchan.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alongchan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code ,String message){
        this.code=code;
        this.message = message;
        this.data=null;
    }

    public static CommonResult error(){
        return new CommonResult(500,"插入失败");
    }

    public static CommonResult success(){
        return new CommonResult(200,"插入成功");
    }

}
