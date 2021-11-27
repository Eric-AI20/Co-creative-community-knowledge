package com.cardiff.entity;

import javax.persistence.*;


public class CaseStudy {

    @Column(nullable = false, length = 64)
    private String Title;

    @Column(nullable = false, length = 64)
    private String Synopsis;

    @Column(nullable = false, length = 64)
    private String Findings;

    @Column(nullable = false, length = 64)
    private String Discussion;

    @Column(nullable = false, length = 64)
    private String Conclusion;

    @Column(nullable = false, length = 64)
    private String Recommendations;

    @Column(nullable = false, length = 64)
    private String Implementation;

    @Column(nullable = false, length = 64)
    private String References;

    @Column(nullable = false, length = 64)
    private String Appendices;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public String getFindings() {
        return Findings;
    }

    public void setFindings(String findings) {
        Findings = findings;
    }

    public String getDiscussion() {
        return Discussion;
    }

    public void setDiscussion(String discussion) {
        Discussion = discussion;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }

    public String getRecommendations() {
        return Recommendations;
    }

    public void setRecommendations(String recommendations) {
        Recommendations = recommendations;
    }

    public String getImplementation() {
        return Implementation;
    }

    public void setImplementation(String implementation) {
        Implementation = implementation;
    }

    public String getReferences() {
        return References;
    }

    public void setReferences(String references) {
        References = references;
    }

    public String getAppendices() {
        return Appendices;
    }

    public void setAppendices(String appendices) {
        Appendices = appendices;
    }
}
