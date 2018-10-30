package com.example.document_sample.models;

import java.util.Date;

public class Receipt {

    private String data;
    private Date createdOn;
    private Date lastModified;

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "{" + " data='" + getData() + "'" + ", createdOn='" + getCreatedOn() + "'" + ", lastModified='"
                + getLastModified() + "'" + "}";
    }
}