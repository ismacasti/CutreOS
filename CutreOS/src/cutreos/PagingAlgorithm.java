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

public abstract class PagingAlgorithm {
    private static final int page_read_time = 5;
    //we asume a process can only have 3 pages resident
    //in main memory
    //if necesary, the paging algorithm will swap out a page
    private static final int page_limit = 3;
    
    LinkedList<Process> allProcesses;
    Scheduling sched;

    public PagingAlgorithm(Scheduling sched) {
        this.allProcesses = allProcesses;
        this.sched = sched;
    }
    
    public void runPage(Process proc, Page p){
        if (p.resident) p.accessPage(sched.getTime());
        else{
            this.loadPage(proc, p);
        }
    }

    @SuppressWarnings("empty-statement")
    public void tick(){
        Process running = sched.getRunning();
        if (running != null){
            //for(Process proc: running.getPages()){
                
            //}
        }
    }
    
    private void loadPage(Process proc, Page p) {
        LinkedList<Page> pages = proc.getPages();
        //check if more than page_limit pages are resident
        int n = 0;
        for(Page a: pages){
            if(a.isResident()) n++;
        }
        if(n >= page_limit) this.swap(proc);
        
        p.setResident(true);
        p.setArrive_time(sched.getTime() + page_read_time);
        PageFaultInterrupt i = new PageFaultInterrupt();
        i.interrupt(this.sched, proc);
    }

    abstract void swap(Process proc);
}
