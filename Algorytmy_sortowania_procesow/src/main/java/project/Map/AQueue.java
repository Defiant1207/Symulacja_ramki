package project.Map;

import project.Processes.EProcessProperty;
import project.Processes.IProcess;

public abstract class AQueue implements IQueue {

    public final int x;
    IProcess[] processes;

    public AQueue(int x) {

        this.x = x;
        processes = new IProcess[x];

    }

    @Override
    public double getProcessA(int x) {
        return processes[x].getProperty(EProcessProperty.a);
    }

    @Override
    public double getProcessP(int x) {
        return processes[x].getProperty(EProcessProperty.P);
    }

    @Override
    public void sort() {
        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j < processes.length - 1; j++) {
                if (getProcessA(j+1) < getProcessA(j)) {
                    IProcess[] proc = new IProcess[processes.length];
                    proc[j] = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = proc[j];
                } else if (getProcessA(j+1) == getProcessA(j)  && getProcessP(j+1)  < getProcessP(j))
                {
                    IProcess[] proc = new IProcess[processes.length];
                    proc[j] = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = proc[j];
                }
            }
        }
    }

    @Override
    public int getProcessPosition(IProcess process) { // Zwraca numer wiersza na którym znajduje się jednostka
        Integer processX = null;
        for (int i = 0; i < processes.length; i++) {
            if (process == processes[i]) {
                processX = i;
            }

        }
        if (processX == null) {
            return -1;
        } else {
            return processX.intValue();
        }
    }

    @Override
    public boolean settleProcess(IProcess process, int x) {

        int settled = getProcessPosition(process);

        if (processes[x] != null) {
            return false;
        }
        if (settled >= 0) {
            processes[settled] = null;
        }
        processes[x] = process;
        return true;

    }



    @Override
    public String toString() {
        StringBuffer buffor = new StringBuffer();
        {
            for (int i = 0; i < x; i++) {
                if (processes[i] == null) {
                    buffor.append("[  ]");
                } else {
                    buffor.append(processes[i].getProperty(EProcessProperty.a));
                }

            }
            buffor.append("\n");

            return buffor.toString();
        }
    }

    @Override
    public void sortLCFS() {
    }
    @Override
    public double[] waitingTime() {
        double a = 0;
        double t = 0;
        double P = getProcessP(0);
        t = getProcessA(0) + getProcessP(0);
        for (int i = 1; i < processes.length; i++) {
            double a2;
            a2 = getProcessA(i);
            double P2;
            P2 = getProcessP(i);
            if (t >= a2) {
                a += t - a2;
                t += P2;
                P += P2;
            } else if (t < a2) {
                t = a2 + P2;
                P += P2;
            }
        }
        double tab[] = new double[2];
        tab[0] = a;
        tab[1] = P;
        return tab;
    }
}
