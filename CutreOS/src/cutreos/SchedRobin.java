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
public class SchedRobin extends SchedAlgorithm {

    String name = "Round Robin";
    //default quantum
    int quantum_size = 5;
    
    public SchedRobin(LinkedList<Process> allProcess, Scheduling sched) {
            super(allProcess, sched);
            
    }
    
    @Override
    String getName() {
        return name;
    }

    @Override
    void tick() {
        this.updateTimes();
        for(Process p: getReadyAndRunning()){
            if(p.isIdle()) continue;
            if(p.getRemaining_time() <= 0){
                p.setCurrent(Process.Status.FINISHED);
                continue;
            }
        }
        if(this.getRunning() != null){
            if(this.getRunning().getQuantum() > 0){
                this.getRunning().setQuantum(this.getRunning().getQuantum() -1);
            }else{
                Process old = this.getRunning();
                chooseNewProcess();
                old.setCurrent(Process.Status.READY);
                if(this.getRunning() == null){
                    old.setQuantum(this.getQuantum());
                    old.setCurrent(Process.Status.READY);
                }
            }
        }else chooseNewProcess();
    }

    private void chooseNewProcess(){
        Process earliest = null;
        for(Process p: allProcesses){
            if (p.getCurrent() == Process.Status.READY && !p.isIdle()){
                if (earliest == null){
                    earliest = p;
                }else{
                    if (p.getArriveTime() < earliest.getArriveTime()){
                        earliest = p;
                    }
                }
            }
        }
        if (earliest != null){
            earliest.setCurrent(Process.Status.RUNNING);
            earliest.setQuantum(this.quantum_size);
        }
    }
    
    @Override
    public int getQuantum() {
        return quantum_size;

    }

    @Override
    public void setQuantum(int quantum) {
        this.quantum_size = quantum;
    }
    
}
