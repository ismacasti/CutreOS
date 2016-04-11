/*
 * Copyright (C) 2016 Beto Garcia
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
 * @author Beto Garcia
 */
public class SchedHRRN extends SchedAlgorithm  {
    
    LinkedList<Process> ready;
    LinkedList<Process> blocked;
    Process running;
    
    public SchedHRRN(LinkedList<Process> allProcess, Scheduling sched) {
            super(allProcess, sched);
    }
    
    
    @Override
    String getName() {
       return "HRRN";
    }

  @Override
    void tick() { 
        int priority;
        this.updateTimes();
        Process shortestRemaining = null;
        for(Process p: getReadyAndRunning()){
            if(p.isIdle()) continue;
            if(p.getRemaining_time() <= 0){
                p.setCurrent(Process.Status.FINISHED);
                continue;
            }
            if(p.getCurrent()==Process.Status.RUNNING)
                p.setReady_time(0);
            priority=((p.getExpected_runtime()+p.getReady_time())/p.getExpected_runtime());
            System.out.println(priority);
            p.setHRRNPriority(priority);
            if(shortestRemaining == null) shortestRemaining = p;
            else if(p.getHRRNPriority() > shortestRemaining.getHRRNPriority()){
                shortestRemaining.setCurrent(Process.Status.READY);
                shortestRemaining = p;
            }              
            }
        if(shortestRemaining != null) shortestRemaining.setCurrent(Process.Status.RUNNING);
        else sched.runIdle();
    }
    
    @Override
    public int getQuantum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQuantum(int quantum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
