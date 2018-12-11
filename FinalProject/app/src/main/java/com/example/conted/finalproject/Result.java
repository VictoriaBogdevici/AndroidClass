package com.example.conted.finalproject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Result implements Serializable {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private String operation;
    private String userAnswer;
    private String rightAnswer;
    String time;
    private boolean isRight;


    public Result(String operation, String userAnswer, String rightAnswer) {

        this.setOperation(operation);
        this.setUserAnswer(userAnswer);
        this.setRightAnswer(rightAnswer);
        this.time=sdf.format(timestamp);
    }

    @Override
    public String toString() {
       if(isRight) return String.format("%s - Right Answer\n %s=%s\n Answer submitted : %s",time,operation,rightAnswer,userAnswer);
       else
           return String.format("%s - Wrong answer\n %s=%s\n Answer submitted : %s",time,operation,rightAnswer,userAnswer);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
