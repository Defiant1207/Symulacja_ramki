package Project.Swap;

import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;

public class FIFO extends ASwap {


    public FIFO(List<IProcess> processes_list) {
        super(processes_list);
    }

    /**
     * dla podanej ilosci ramek wykonywany jest algorytm zastepowania stron
     * @param x - liczba ramek
     * @return  ilosc wymian stron
     */
    public double missing_pages(int x) {
        List<IProcess> processes = new ArrayList<>();
        int a = 0;
        processes.add(processes_list.get(0));
        a++;
        int t = 0;
        while (a > 0 && a < x) {
            int ile_procesow = 0;

            for (int j = 0; j < processes.size(); j++) {
                if (processes_list.get(t).getPage() != processes.get(j).getPage())
                    ile_procesow++;
            }
            if (ile_procesow == processes.size()) {
                processes.add(processes_list.get(t));
                a++;
            }
            t++;
        }

        for (int i = t; i < processes_list.size(); i++) {

            int b = 0;
            for (int j = 0; j < x; j++) {
                if (processes.get(j).getPage() != processes_list.get(i).getPage()) {
                    b++;
                }

                if (b == x) {
                    a++;

                    processes.remove(0);
                    processes.add(processes_list.get(i));
                }

            }
        }
        return a;
    }
}
