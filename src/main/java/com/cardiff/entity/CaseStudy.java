package com.cardiff.entity;

import javax.persistence.*;

@Entity
@Table(name = "casestudies")
public class CaseStudy extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String title;

    @Column(length = 1000)
    private String caseIntroduction;

    @Column(length = 1000)
    private String caseEvaluation;

    @Column(length = 1000)
    private String caseSolutions;

    @Column(length = 1000)
    private String implementations;

    @Column(length = 1000)
    private String conclusion;

    @Transient
    private Long communityId;

   /* @Column(length = 1000)
    private String username;*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "community_id", nullable = false, referencedColumnName = "id")
    private Community community;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaseIntroduction() {
        return caseIntroduction;
    }

    public void setCaseIntroduction(String caseIntroduction) {
        this.caseIntroduction = caseIntroduction;
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

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    /*public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    */
    @Override
    public String toString() {
        return "CaseStudy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", introduction='" + caseIntroduction + '\'' +
                ", caseEvaluation='" + caseEvaluation + '\'' +
                ", caseSolutions='" + caseSolutions + '\'' +
                ", implementations='" + implementations + '\'' +
                ", conclusion='" + conclusion + '\'' +
//                ", username='" + username + '\'' +
                '}';
    }
}
