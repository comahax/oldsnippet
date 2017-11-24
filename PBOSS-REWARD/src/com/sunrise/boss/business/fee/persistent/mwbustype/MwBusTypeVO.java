package com.sunrise.boss.business.fee.persistent.mwbustype;

public class MwBusTypeVO  implements java.io.Serializable {

    // Fields    

     private Long bustype;
     private String busname;
     private Integer state;

    // Constructors

    /** default constructor */
    public MwBusTypeVO() {
    }

	/** minimal constructor */
    public MwBusTypeVO(Long bustype) {
        this.bustype = bustype;
    }
    
    /** full constructor */
    public MwBusTypeVO(Long bustype, String busname, Integer state) {
        this.bustype = bustype;
        this.busname = busname;
        this.state = state;
    }

   
    // Property accessors

    public Long getBustype() {
        return this.bustype;
    }
    
    public void setBustype(Long bustype) {
        this.bustype = bustype;
    }

    public String getBusname() {
        return this.busname;
    }
    
    public void setBusname(String busname) {
        this.busname = busname;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
   








}