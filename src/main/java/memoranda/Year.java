package main.java.memoranda;

import java.util.Vector;

import main.java.memoranda.Month;
import main.java.memoranda.Day;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;

//TASK 3-2 SMELL WITHIN A CLASS
public class Year {
    Element yearElement = null;
    Element _root = null;

    public Year(Element el) {
        yearElement = el;
    }
    
    public Year(){
        yearElement = null;
    }

    public int getValue() {
        return new Integer(yearElement.getAttribute("year").getValue())
            .intValue();
    }

    public Month getMonth(int m) {
        Elements ms = yearElement.getChildElements("month");
        String mm = new Integer(m).toString();
        for (int i = 0; i < ms.size(); i++)
            if (ms.get(i).getAttribute("month").getValue().equals(mm))
                return new Month(ms.get(i));
        //return createMonth(m);
        return null;
    }

    public Month createMonth(int m) {
        Element el = new Element("month");
        el.addAttribute(new Attribute("month", new Integer(m).toString()));
        yearElement.appendChild(el);
        return new Month(el);
    }

    public Vector getMonths() {
        Vector v = new Vector();
        Elements ms = yearElement.getChildElements("month");
        for (int i = 0; i < ms.size(); i++)
            v.add(new Month(ms.get(i)));
        return v;
    }

    public Element getElement() {
        return yearElement;
    }
    
    //TASK3-2 SMELL BETWEEN CLASSES
    
    public Year createYear(int y) {
        Element el = new Element("year");
        el.addAttribute(new Attribute("year", new Integer(y).toString()));
        
        /*
        if(el != null){
            _root.appendChild(el);
        }
        */
        return new Year(el);
    }

    public Year getYear(int y) {
        Elements yrs = _root.getChildElements("year");
        String yy = new Integer(y).toString();
        for (int i = 0; i < yrs.size(); i++)
            if (yrs.get(i).getAttribute("year").getValue().equals(yy))
                return new Year(yrs.get(i));
        //return createYear(y);
        return null;
    }
    
    
}
