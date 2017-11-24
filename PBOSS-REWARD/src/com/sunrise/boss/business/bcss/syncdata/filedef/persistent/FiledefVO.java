package com.sunrise.boss.business.bcss.syncdata.filedef.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FiledefVO implements Serializable {

    /** identifier field */
    private String filecode;

    /** nullable persistent field */
    private String filetype;

    /** nullable persistent field */
    private String filepath;

    /** full constructor */
    public FiledefVO(java.lang.String filecode, java.lang.String filetype, java.lang.String filepath) {
        this.filecode = filecode;
        this.filetype = filetype;
        this.filepath = filepath;
    }

    /** default constructor */
    public FiledefVO() {
    }

    /** minimal constructor */
    public FiledefVO(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.String getFiletype() {
        return this.filetype;
    }

    public void setFiletype(java.lang.String filetype) {
        this.filetype = filetype;
    }

    public java.lang.String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
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
