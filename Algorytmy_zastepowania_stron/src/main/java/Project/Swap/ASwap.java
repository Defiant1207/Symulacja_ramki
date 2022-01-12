package Project.Swap;


import Project.Process.IProcess;

import java.util.List;

public abstract class ASwap implements ISwap {


    List<IProcess> processes_list;


    public ASwap(List<IProcess> processes_list) {
        this.processes_list = processes_list;
    }


}
