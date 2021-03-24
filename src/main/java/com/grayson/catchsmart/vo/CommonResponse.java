/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grayson.catchsmart.vo;

import com.grayson.catchsmart.enums.CodeAndMsg;
import lombok.Data;

/**
 * AjaxResult
 *
 * @Description:
 * @Author: grayson
 * @Version 1.0
 * @Date: 2021-03-23 17:24
 **/
@Data
public class CommonResponse<T> {
    private boolean result;
    private int code;
    private String message;
    private T data;

    public CommonResponse(boolean result, CodeAndMsg codeMsg, T data){
        this.result = result;
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMsg();
        this.data = data;
    }

    public CommonResponse(boolean result, CodeAndMsg codeMsg, String message, T data){
        this.result = result;
        this.code = codeMsg.getCode();
        this.message = message;
        this.data = data;
    }
}
