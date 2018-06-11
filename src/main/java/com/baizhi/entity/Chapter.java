package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Chapter implements Serializable {
    private String id;

    private String tittle;

    private String size;

    private String duration;

    private String downpath;

    private Date uploaddate;

    private String audioid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath == null ? null : downpath.trim();
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getAudioid() {
        return audioid;
    }

    public void setAudioid(String audioid) {
        this.audioid = audioid == null ? null : audioid.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Chapter other = (Chapter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTittle() == null ? other.getTittle() == null : this.getTittle().equals(other.getTittle()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getDownpath() == null ? other.getDownpath() == null : this.getDownpath().equals(other.getDownpath()))
            && (this.getUploaddate() == null ? other.getUploaddate() == null : this.getUploaddate().equals(other.getUploaddate()))
            && (this.getAudioid() == null ? other.getAudioid() == null : this.getAudioid().equals(other.getAudioid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTittle() == null) ? 0 : getTittle().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getDownpath() == null) ? 0 : getDownpath().hashCode());
        result = prime * result + ((getUploaddate() == null) ? 0 : getUploaddate().hashCode());
        result = prime * result + ((getAudioid() == null) ? 0 : getAudioid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tittle=").append(tittle);
        sb.append(", size=").append(size);
        sb.append(", duration=").append(duration);
        sb.append(", downpath=").append(downpath);
        sb.append(", uploaddate=").append(uploaddate);
        sb.append(", audioid=").append(audioid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}