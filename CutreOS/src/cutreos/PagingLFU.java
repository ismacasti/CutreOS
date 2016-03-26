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
public class PagingLFU extends PagingAlgorithm {

    String name = "LFU";
    public PagingLFU(Scheduling sched) {
        super(sched);
    }
    
    public PagingLFU() {
        super();
    }

    public String getName(){
        return this.name;
    }

    @Override
    void swap(Process proc) {
        LinkedList<Page> pages = proc.getPages();
        Page oldest = null;
        for(Page p: pages){
            if (p.isResident()){
                if(oldest == null) oldest = p;
                else{
                    if(p.getAccess_count()< oldest.getAccess_count()){
                        oldest = p;
                    }
                }
            }
        }
        oldest.setResident(false);
    }
    
}
