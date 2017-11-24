package net.gmcc.pboss.domain.model.smsobject;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * SmsobjectVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="FX_SW_SMSOBJECT")
public class SmsobjectVO  implements java.io.Serializable {


    // Fields    

     private Long seqid;
     private String countyid;
     private String objecttype;
     private String name;
     private String mobile;
     private String busitype;


    // Constructors

    /** default constructor */
    public SmsobjectVO() {
    }

	/** minimal constructor */
    public SmsobjectVO(Long seqid) {
        this.seqid = seqid;
    }
    
    /** full constructor */
    public SmsobjectVO(Long seqid, String countyid, String objecttype, String name, String mobile, String busitype) {
        this.seqid = seqid;
        this.countyid = countyid;
        this.objecttype = objecttype;
        this.name = name;
        this.mobile = mobile;
        this.busitype = busitype;
    }

   
    // Property accessors    
    @Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "FX_SW_SMSOBJECT_SEQ", allocationSize=1)
	@Column(name = "SEQID", unique = true, nullable = false, precision = 14, scale = 0)
    
    public Long getSeqid() {
        return this.seqid;
    }
    
    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }
    
    @Column(name="COUNTYID", length=14)

    public String getCountyid() {
        return this.countyid;
    }
    
    public void setCountyid(String countyid) {
        this.countyid = countyid;
    }
    
    @Column(name="OBJECTTYPE", length=16)

    public String getObjecttype() {
        return this.objecttype;
    }
    
    public void setObjecttype(String objecttype) {
        this.objecttype = objecttype;
    }
    
    @Column(name="NAME", length=32)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="MOBILE", length=12)

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Column(name="BUSITYPE", length=16)

    public String getBusitype() {
        return this.busitype;
    }
    
    public void setBusitype(String busitype) {
        this.busitype = busitype;
    }
}
