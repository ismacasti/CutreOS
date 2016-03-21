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

/**
 *
 * @author ismael
 */
public class SigTermSVCInterrupt extends Interrupt{

    String name = "SigTerm SVC Interrupt";
            
    
    //in a SigTerm interrupt (normal termination)
    //the process is allowed to finish all its I/O
    //we implement this by setting the total runtime
    //to the current running time+1
    public void interrupt(Scheduling sched, Process proc) {
        proc.setExpected_runtime(proc.getRunning_time()+1);
    }
    
}
