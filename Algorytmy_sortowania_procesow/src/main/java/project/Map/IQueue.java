package project.Map;

import project.Processes.IProcess;

public interface IQueue {

    /**
     *
     * @param x - pozycja w tabeli
     * @return czas przyjscia procesu
     */

    double getProcessA(int x);
    /**
     *
     * @param x - pozycja w tabeli
     * @return czas przetwarzania procesu
     */

    double getProcessP(int x);

    /**
     *
     * @param process
     * @return pozycja na ktorej znajduje sie proces
     */

    int getProcessPosition(IProcess process);

    /**
     * umieszcza proces na podanej pozycji
     * @param process
     * @param x - pozycja na ktorej chcemy umiescic proces
     * @return prawda- jezeli mozna umiescic proces na danej pozycji, falsz- nie mozna
     */

    boolean settleProcess(IProcess process, int x);

    /**
     * Sortuje procesy zaczynajac od tych, ktore najwczesniej przyszly
     */
    void sort();

    /**
     * zlicza czasy oczekiwania i przetwarzania procesow
     * @return laczny czas oczekiwania i przetwarzania procesow
     */

    double[] waitingTime();

    /**
     * sortuje procesy zaczynajac od tego ktory jako ostatni przyszedl biorac pod uwage
     * aktualny czas
     */

    void sortLCFS();

}

