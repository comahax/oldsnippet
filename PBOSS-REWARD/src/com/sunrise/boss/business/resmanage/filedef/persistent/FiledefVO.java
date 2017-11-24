package com.sunrise.boss.business.resmanage.filedef.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FiledefVO implements Serializable {

    /** identifier field */
    private String filecode;

    /** nullable persistent field */
    private String filename;

    /** persistent field */
    private String subsystem;

    /** nullable persistent field */
    private Integer linelimit;

    /** nullable persistent field */
    private String menulink;

    /** full constructor */
    public FiledefVO(java.lang.String filecode, java.lang.String filename, java.lang.String subsystem, java.lang.Integer linelimit, java.lang.String menulink) {
        this.filecode = filecode;
        this.filename = filename;
        this.subsystem = subsystem;
        this.linelimit = linelimit;
        this.menulink = menulink;
    }

    /** default constructor */
    public FiledefVO() {
    }

    /** minimal constructor */
    public FiledefVO(java.lang.String filecode, java.lang.String subsystem) {
        this.filecode = filecode;
        this.subsystem = subsystem;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getSubsystem() {
        return this.subsystem;
    }

    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }

    public java.lang.Integer getLinelimit() {
        return this.linelimit;
    }

    public void setLinelimit(java.lang.Integer linelimit) {
        this.linelimit = linelimit;
    }

    public java.lang.String getMenulink() {
        return this.menulink;
    }

    public void setMenulink(java.lang.String menulink) {
        this.menulink = menulink;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("filecode", getFilecode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FiledefVO) ) return false;
        FiledefVO castOther = (FiledefVO) other;
        return new EqualsBuilder()
            .append(this.getFilecode(), castOther.getFilecode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFilecode())
            .toHashCode();
    }

}
