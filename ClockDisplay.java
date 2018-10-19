
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight). However, the internals of the clock follow the American-style
 * from 00:00 to 12:00 with the usage of pm and am. 
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Willen O. Leal
 * @version 2018.01.10
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean pm;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String amOrPm)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, amOrPm);

    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String amOrPm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        
         if(amOrPm.equals("am")) {
            pm = false;
        }
        else if(amOrPm.equals("pm")){
            pm = true;
        }

        updateDisplay();
        
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
       if (pm == false) {
           
                if(hours.getValue() == 0) 
                {
                    displayString = "" + (hours.getValue() + 12) + ":" + 
                        minutes.getDisplayValue();
                }
                
                else
                {
                    displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
                
                }
                
                
       }
    
       if (pm == true){
           
           if(hours.getValue() == 0) 
           {
               displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
           }
           else
           {
               displayString = "" + (hours.getValue() + 12) + ":" + 
                        minutes.getDisplayValue();
            
           }
       }
    }
}
