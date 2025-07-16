package com.example.demo.model;

import lombok.Getter;

public class Constants {

  class ErrorMsgs {
      public static final String POST_NOT_FOUND = "post not found";
      public static final String USER_NOT_FOUND = "user not found";

  }
    enum ErrormsgsTwo {
     POST_NOT_FOUND("post not found"),
     USER_NOT_FOUND("user not found");

     ErrormsgsTwo(String s) {
         this.msg = s;
     }

     @Getter
        private String msg;
    }

    public static void printErrorMsg(String msg) {
        System.out.println(msg);
    }

    public static void printErrorMsgV2(ErrormsgsTwo msg) {
        System.out.println(msg.getMsg());
    }

    public static void main(String[] args) {
        printErrorMsg(ErrorMsgs.POST_NOT_FOUND);
        printErrorMsg("ay string");
        printErrorMsgV2(ErrormsgsTwo.POST_NOT_FOUND);
        printErrorMsgV2(ErrormsgsTwo.USER_NOT_FOUND);

    }
}
