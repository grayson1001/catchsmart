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
package com.grayson.catchsmart.handler;

import com.grayson.catchsmart.enums.CodeAndMsg;
import com.grayson.catchsmart.exception.BusinessException;
import com.grayson.catchsmart.vo.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @Description:
 * @Author: grayson
 * @Version 1.0
 * @Date: 2021-03-23 17:28
 **/
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler<T> {
    @ResponseStatus(HttpStatus.OK)
    public CommonResponse sendSuccessResponse(){
        return new CommonResponse(true,  CodeAndMsg.SUCCESS, null);
    }

    @ResponseStatus(HttpStatus.OK)
    public CommonResponse sendSuccessResponse(T data){
        return new CommonResponse(true,  CodeAndMsg.SUCCESS, data);
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse sendErrorResponse_UserDefined(Exception exception){
        return new CommonResponse(false, ((BusinessException)exception).getException(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse sendErrorResponse_System(Exception exception){
        if (exception instanceof BusinessException) {
            return this.sendErrorResponse_UserDefined(exception);
        }

        return new CommonResponse(false, CodeAndMsg.UNKNOWEXCEPTION, null);
    }

}
