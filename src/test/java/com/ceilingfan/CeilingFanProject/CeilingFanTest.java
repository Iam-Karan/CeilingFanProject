package com.ceilingfan.CeilingFanProject;

import junit.framework.TestCase;

/**
 * Unit test for CeilingFan App.
 */
public class CeilingFanTest extends TestCase
{
	CeilingFan cf=null;
    
    public void testPullCordOn25thDec() 
    {
    	cf=new CeilingFan();
    	cf.setInputDate("2021-12-25");
    	cf.pullCord();
    	assertEquals(0, cf.getSpeed());
    	assertEquals(0, cf.increaseSpeed());
        assertEquals("forward",cf.getDirection());
        cf.reverseDirection();
        assertEquals("forward",cf.getDirection());
        System.out.println("The fan is running at "+cf.getSpeed() +" speed and "+cf.getDirection()+" direction");
        cf=null;
    	
    }
    public void testPullCordWithout25thDec() 
    {
    	cf=new CeilingFan();
    	cf.setInputDate("2021-12-26");
    	cf.pullCord();
    	assertEquals(1, cf.getSpeed());
    	assertEquals(2, cf.increaseSpeed());
        assertEquals("forward",cf.getDirection());
        cf.reverseDirection();
        assertEquals("reverse",cf.getDirection());
        assertEquals(3, cf.increaseSpeed());
        System.out.println("The fan is running at "+cf.getSpeed() +" speed and "+cf.getDirection()+" direction");
        assertEquals(0, cf.increaseSpeed());
        cf=null;
    	
    }
}
