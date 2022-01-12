package Project.Swap;

import Project.Process.IProcess;

import java.util.ArrayList;
import java.util.List;

public class LFU extends ASwap {

    int[] proces;

    public LFU(List<IProcess> processes_list) {
        super(processes_list);
        this.proces = new int[20];
    }

    /**
     * dla podanego numeru strony zwieksza liczbe jego uzycia
     * @param x numer strony
     */
    public void procesUsed(int x) {
        int a = proces[x - 1];
        proces[x - 1] = a + 1;
    }

    /**
     *
     * @param x numer strony
     * @return liczba uzyc danej strony
     */
    public int HowManyTimesUsed(int x) {
        return proces[x - 1];
    }

    /**
     *
     * @param tab - tablica strony
     * @return strona ktora zostala najmniej razy uzyta
     */
    public int LFUProcess(List<IProcess> tab) {
        IProcess process = tab.get(0);
        int x = 0;

        for (int i = 1; i < tab.size(); i++) {
            if (HowManyTimesUsed(tab.get(i).getPage()) < HowManyTimesUsed(process.getPage())) {
                process = tab.get(i);
                x = i;
            }
        }
        return x;
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
        procesUsed(processes_list.get(0).getPage());

        int t = 0;
        while (a > 0 && a < x) {
            int ile_procesow = 0;

            for (IProcess process : processes) {
                if (processes_list.get(t).getPage() != process.getPage())
                    ile_procesow++;
            }

            if (ile_procesow == processes.size()) {
                processes.add(processes_list.get(t));
                a++;
            }
            procesUsed(processes_list.get(t).getPage());
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
                    procesUsed(processes_list.get(i).getPage());
                    processes.set(LFUProcess(processes), processes_list.get(i));
                }

            }
        }
        return a;
    }

}
