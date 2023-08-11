package com.newsvalidator.pojo;

public class SearchResult {
    private String domain;
    private String domainNews;
    private double similarity;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainNews() {
        return domainNews;
    }

    public void setDomainNews(String domainNews) {
        this.domainNews = domainNews;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
}
