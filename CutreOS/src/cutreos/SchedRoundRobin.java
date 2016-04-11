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
import cutreos.Process.Status;

public class SchedRoundRobin extends SchedAlgorithm{
    
    LinkedList<Process> ready;
    LinkedList<Process> blocked;
    Process running;

            public SchedRoundRobin(LinkedList<Process> allProcess, Scheduling sched) {
            super(allProcess, sched);
    }

    @Override
    String getName() {
       return "Round Robin"; 
    }
    
    
@Override
 public void tick() {
        this.updateTimes();
        if (this.getRunning() != null && !this.getRunning().isIdle()){
            if (this.getRunning().getExpected_runtime() < this.getRunning().getRunning_time()) {
                this.getRunning().finishProcess();
                this.chooseNewProcess();
            }else{
                if(this.getRunning().getQuantum()<=0){
                    if(!this.getReady().isEmpty())
                    this.getRunning().setCurrent(Status.READY);
                    this.chooseNewProcess();
                }
            }
        }else{
            this.chooseNewProcess();
        }
        
    }

    private void chooseNewProcess(){
        Process earliest = null;
        for(Process p: allProcesses){
            if (p.getCurrent() == Status.READY && !p.isIdle()){
                if (earliest == null && p.getQuantum() > 0)
                    earliest = p; 
                else{
                    if(earliest!=null){
                     if (p.getReady_time() > earliest.getReady_time()){
                        earliest = p;
                    }   
                    }     
                }       
                if (p.getQuantum() <= 0)
                    p.setQuantum(this.getReady().peekFirst().getQuantum());
            }
        }
        if (earliest != null) earliest.setCurrent(Status.RUNNING);
        this.running = earliest;
    }

    
    private void setQuantumRunning(int quantum){
     this.getRunning().setQuantum(quantum);
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
