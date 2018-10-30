package com.example.document_sample.models;

import java.util.Date;

public class Document {

    private String name;
    private String reference;
    private Date lastModified;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    private Date createdOn;

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", reference='" + getReference() + "'" + ", lastModified='"
                + getLastModified() + "'" + ", createdOn='" + getCreatedOn() + "'" + "}";
    }
}