package com.sunrise.exam.ui.component;


import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.component.impl.DefaultCode2Name;
import com.sunrise.jop.test.jop.BOTestCase;

public class Code2NameTestCase extends BOTestCase {
	private Code2Name testObj;

	public Code2NameTestCase() {
        super("Code2Name Test");
	}

	
    protected void setUp() throws Exception {
        super.setUp();
        testObj = new DefaultCode2Name();
    }

    protected void tearDown() throws Exception {
    	testObj  = null;
    	
    	super.tearDown();
    }
    

    public void testCode2NameByField(){
    	String value = testObj.code2Name("#COMPANY_FIELD", "999", "");
    	
    	System.out.println(value);
    }

    public void testCode2NameBySql(){
    	String value = testObj.code2Name("#COMPANY_SQL", "999", "");
    	
    	System.out.println(value);
    }
}
