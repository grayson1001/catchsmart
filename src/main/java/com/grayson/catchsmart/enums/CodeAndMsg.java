package com.grayson.catchsmart.enums;

import lombok.Getter;

public enum CodeAndMsg {
    SUCCESS(1000, "SUCCESS"),
    METHODFAIL(2000, "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWEXCEPTION(3000, "THIS IS AN UNKNOW EXCEPTION");

    @Getter
    private int code;
    @Getter
    private String msg;

    CodeAndMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CodeAndMsg getCodeEnum(int code){
        for (CodeAndMsg codeMsg: CodeAndMsg.values()) {
            if(codeMsg.code == code){
                return codeMsg;
            }
        }
        return null;
    }


}
