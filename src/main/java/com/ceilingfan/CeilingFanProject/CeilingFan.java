package com.ceilingfan.CeilingFanProject;

import java.time.LocalDate;

public class CeilingFan {

	private Direction direction=Direction.FORWARD;
	private State st=State.OFF;
	private String inputDate="2021-12-25";
	
	
	private enum Direction {
        FORWARD("forward"),
        REVERSE("reverse");

        private final String value;
        Direction(String value) {
            this.value = value;
        }
        String getValue() {
            return value;
        }
    }
	
	 private enum State {
	        OFF    (0),
	        ONE   (1),
	        TWO   (2),
	        THREE (3);

	        private final int value;
	        State(int value) {
	            this.value = value;
	        }
	        int getValue() {
	            return value;
	        }
	    }
	 public int increaseSpeed()
	 {
		 if(checkIf25thDecember())
			{
				st=State.OFF;
			}
		 else
		 {
		 int fanState=st.getValue();
		 switch(fanState) {
			case 0:
				st=State.ONE;
				break;
			case 1:
				st=State.TWO;
				break;
			case 2:
				st=State.THREE;
                break;
			case 3:
				st=State.OFF;
				break;
			default:
				System.out.println("Invalid inputs");
		}
		 }
		 return st.getValue();
	 }
	 public String reverseDirection()
	 {
		if(!checkIf25thDecember())
		{
		 direction= direction.getValue().equalsIgnoreCase("Forward")?Direction.REVERSE:Direction.FORWARD;
		}
		 return direction.getValue();
	 }
	 
	 private boolean checkIf25thDecember()
	 {
		 LocalDate currentdate = LocalDate.parse(inputDate);
	     int currentDay = currentdate.getDayOfMonth();
	     int currentMonth = currentdate.getMonthValue();
		 if(currentDay==25 && currentMonth==12) 
		 {
			 return true;
		 }
		 return false;
	 }
	 
	public void pullCord() 
	 {
		
	    if(direction.getValue().equalsIgnoreCase("forward"))
		{
			increaseSpeed();	
		}
		else if(direction.getValue().equalsIgnoreCase("reverse"))
		{
			reverseDirection();
		}
	 }
	
	 
	 public String getDirection()
	 {
		 return direction.getValue();
	 }
	 public int getSpeed()
	 {
		 return st.getValue();
	 }
	 public String getInputDate() {
			return inputDate;
		}
	 public void setInputDate(String inputDate) {
			this.inputDate= inputDate;
		} 
}
