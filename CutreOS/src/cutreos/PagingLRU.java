/*
 * Copyright (C) 2016 ismael
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cutreos;

import java.util.LinkedList;

/**
 *
 * @author ismael
 */
public class PagingLRU extends PagingAlgorithm{

    String name = "LRU";

    public PagingLRU(Scheduling sched) {
        super(sched);
    }
    
    public PagingLRU() {
        super();
    }
    
    public static final String getName(){
        return "LRU";
    }
    
    private Page getLastAccessed(Page p1, Page p2){
        if(this.sched.getTime() - p1.getLast_access_time() >= 
                this.sched.getTime() - p2.getLast_access_time()){
            return p1;
        }else{
            return p2;
        }
    }

    @Override
    void swap(Process proc) {
        LinkedList<Page> pages = proc.getPages();
        Page oldest = null;
        for(Page p: pages){
            if (p.isResident()){
                if(oldest == null) oldest = p;
                else{
                    oldest = getLastAccessed(oldest, p);
                }
            }
        }
        oldest.setResident(false);
    }
}
