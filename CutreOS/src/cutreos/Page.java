/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cutreos;

import java.util.LinkedList;

/**
 *
 * @author ismael
 */
public class Page {

    boolean resident = false;
    int arrive_time = 0;
    int last_access_time = 0;
    int access_count = 0;
    //NUR
    boolean referenced = false;
    boolean modified = false;
    
    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public int getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(int arrive_time) {
        this.arrive_time = arrive_time;
    }

    public int getLast_access_time() {
        return last_access_time;
    }

    public void setLast_access_time(int last_access_time) {
        this.last_access_time = last_access_time;
    }

    public int getAccess_count() {
        return access_count;
    }

    public void setAccess_count(int access_count) {
        this.access_count = access_count;
    }

    public boolean isReferenced() {
        return referenced;
    }

    public void setReferenced(boolean referenced) {
        this.referenced = referenced;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }


    //parse the page data from a list
    public Page(LinkedList<Integer> p) {
        this.setResident(p.get(0) == 1);
        this.setArrive_time(p.get(1));
        this.setLast_access_time(p.get(2));
        this.setAccess_count(p.get(3));
        this.setReferenced(p.get(4) == 1);
        this.setModified(p.get(5) == 1);
    }
    
}
