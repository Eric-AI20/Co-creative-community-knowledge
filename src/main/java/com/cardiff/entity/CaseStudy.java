package com.cardiff.entity;

import javax.persistence.*;

@Entity
@Table(name = "casestudies")
public class CaseStudy extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(nullable = false, unique = true, length = 45)
    private String title;

    @Column(length = 1000)
    private String introduction;

    @Column(length = 1000)
    private String caseEvaluation;

    @Column(length = 1000)
    private String caseSolutions;

    @Column(length = 1000)
    private String implementations;

    @Column(length = 1000)
    private String conclusion;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String title) {
        this.introduction = introduction;
    }

    public String getCaseEvaluation() {
        return caseEvaluation;
    }

    public void setCaseEvaluation(String caseEvaluation) {
        this.caseEvaluation = caseEvaluation;
    }

    public String getCaseSolutions() {
        return caseSolutions;
    }

    public void setCaseSolutions(String caseSolutions) {
        this.caseSolutions = caseSolutions;
    }

    public String getImplementations() {
        return implementations;
    }

    public void setImplementations(String implementations) {
        this.implementations = implementations;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

}
