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
package com.grayson.catchsmart.controller;

import com.grayson.catchsmart.enums.CodeAndMsg;
import com.grayson.catchsmart.exception.BusinessException;
import com.grayson.catchsmart.handler.GlobalExceptionHandler;
import com.grayson.catchsmart.vo.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 *
 * @Description:
 * @Author: grayson
 * @Version 1.0
 * @Date: 2021-03-24 16:54
 **/
public class UserController {

    @GetMapping("/doTestObject")
    public CommonResponse testObjectReturn(){
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return new GlobalExceptionHandler<Map>().sendSuccessResponse(map);
    }


    @GetMapping("/doTestException/{x}")
    public int testExceptionResturn(@PathVariable int x){
        if (0 < x && x < 10){
            throw new BusinessException(CodeAndMsg.METHODFAIL);
        } else {
            return  1/0;
        }
    }

}
