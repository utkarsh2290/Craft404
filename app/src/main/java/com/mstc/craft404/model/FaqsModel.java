package com.mstc.craft404.model;

public class FaqsModel {
    String faqQuestion;
    String faqAnswer;

    public FaqsModel(String faqQuestion, String faqAnswer) {
        this.faqQuestion = faqQuestion;
        this.faqAnswer = faqAnswer;
    }

    public String getFaqQuestion() {
        return faqQuestion;
    }

    public String getFaqAnswer() {
        return faqAnswer;
    }

    public void setFaqQuestion(String faqQuestion) {
        this.faqQuestion = faqQuestion;
    }

    public void setFaqAnswer(String faqAnswer) {
        this.faqAnswer = faqAnswer;
    }
}
