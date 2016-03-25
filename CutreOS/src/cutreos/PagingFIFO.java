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
public class PagingFIFO extends PagingAlgorithm {

    String name = "FIFO";
    
    public PagingFIFO(Scheduling sched) {
        super(sched);
    }

    public PagingFIFO() {
        super();
    }
    
    @Override
    void swap(Process proc) {
        LinkedList<Page> pages = proc.getPages();
        Page oldest = null;
        for(Page p: pages){
            if (p.isResident()){
                if(oldest == null) oldest = p;
                else{
                    if(p.getArrive_time() < oldest.getArrive_time()){
                        oldest = p;
                    }
                }
            }
        }
        oldest.setResident(false);
    }
    
    public static final String getName(){
        return "FIFO";
    }



}
