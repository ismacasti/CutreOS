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
        this.updateTimes();
        Process shortestRemaining = null;
        for(Process p: getReadyAndRunning()){
            if(p.isIdle()) continue;
            if(p.getRemaining_time() <= 0){
                p.setCurrent(Process.Status.FINISHED);
                continue;
            }
    
                                            a=((double)(p.expected_runtime+p.intrXProceso))/((double)(p.instrXProceso));
                                            b=((double)(p2.expected_runtime+pr.instrXProceso))/((double)(p2.instrXProceso));
                                            if(a>=b){
                                                if(p.acumInstrEjecutadas<p.instrXProceso&&p.getCurrent()==("ready"){
                                                    pr=(DisenoProceso)listaDeProcesos.get(i);
                                                }else{
                                                    validaTerminados();
    }
                                            
}
    }
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
