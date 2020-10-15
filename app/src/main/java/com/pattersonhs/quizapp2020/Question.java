package com.pattersonhs.quizapp2020;

public class Question {

    // instance variables
    private String qWords;
    private boolean qAnswer;

    // constructor(s)
    public Question(String newWords, boolean newAnswer)
    {
        qWords = newWords;
        qAnswer = newAnswer;
    }

    // methods (getters and setters and more!)
    public String getQWords()
    {
        return qWords;
    }
    public boolean getQAnswer()
    {
        return qAnswer;
    }
    public void setQWords(String newWords)
    {
        qWords = newWords;
    }
    public void setQAnswer(boolean newAnswer)
    {
        qAnswer = newAnswer;
    }

}
