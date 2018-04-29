package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.Year;
import main.java.memoranda.Month;
import nu.xom.Element;

//TASK 3-2 SMELL WITHIN A CLASS
public class Day {
    Element dEl = null;

    public Day(Element el) {
        dEl = el;
    }
    
    public Day(){
        dEl= null;
    }

    public int getValue() {
        return new Integer(dEl.getAttribute("day").getValue()).intValue();
    }

    /*
     * public Note getNote() { return new NoteImpl(dEl);
     */

    public Element getElement() {
        return dEl;
    }
    
    
    
    //TASK3-2 SMELL BETWEEN CLASSES
    
    public Day createDay(CalendarDate date) {
        
        Year y = new Year();
        y = y.createYear(date.getYear());
        //if (y == null)
           // y = createYear(date.getYear());
        Month m = y.getMonth(date.getMonth());
        if (m == null)
            m = y.createMonth(date.getMonth());
        Day d = m.getDay(date.getDay());
        if (d == null)
            d = m.createDay(date.getDay());
        return d;
    }
    
    public  Day getDay(CalendarDate date) {
        
        Year y = new Year();
        y = y.createYear(date.getYear());
        //Year y = getYear(date.getYear());
        //if (y == null)
            //return null;
        Month m = y.getMonth(date.getMonth());
        if (m == null)
            return null;
        return m.getDay(date.getDay());
    }
}
