package project.Map;

import project.Processes.EProcessProperty;
import project.Processes.IProcess;

import java.util.ArrayList;
import java.util.List;

public class Queue extends AQueue {

    public Queue(int x) {
        super(x);
    }

    @Override
    public void sortLCFS() {
        IProcess[] processes2 = new IProcess[processes.length];
        for (int i = 0; i < processes.length; i++) {
            processes2[i] = processes[i];
        }
        double t = 0;
        t = getProcessA(0) + getProcessP(0);
        List<IProcess> queue = new ArrayList<>();

        for (int i = 1; i < processes.length; i++) {
            if (processes2[i] != null) {
                if (processes2[i].getProperty(EProcessProperty.a) > t) {
                    queue.add(processes2[i]);
                    processes2[i] = null;
                } else {
                    for (int j = 1; j < processes2.length; j++) {
                        if (processes2[j] != null) {
                            if (processes2[j].getProperty(EProcessProperty.a) <= t) {
                                queue.add(processes2[j]);
                                processes2[j] = null;
                            }
                        }
                    }
                }
            }
            processes[i] = queue.get(queue.size() - 1);


            if (getProcessA(i)> t) {
                t = getProcessP(i) + getProcessA(i);
            } else {
                t += getProcessP(i);
            }
            queue.remove(queue.size() - 1);

        }
    }


}
