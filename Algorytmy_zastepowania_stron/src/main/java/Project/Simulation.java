package Project;

import Project.Process.IProcess;
import Project.Process.Process;
import Project.Swap.FIFO;
import Project.Swap.LFU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {

    public static void main(String args[]) throws FileNotFoundException {

        File dane = new File("dane.txt");
        Scanner line = new Scanner(dane);
        int dataBase[] = new int[10000];
        Map<Integer, List<IProcess> > allprocesses = new HashMap<>();

        while (line.hasNext()) {
            for (int j = 0; j < 100; j++) {
                List<IProcess> processes = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    dataBase[i] = line.nextInt();
                    IProcess proces = new Process(dataBase[i]);
                    processes.add(proces);
                }
                allprocesses.put(j,processes);
            }
        }
        double x3F=0;
        double x5F=0;
        double x7F=0;
        double x3L=0;
        double x5L=0;
        double x7L=0;

        for(int i=0; i<100; i++) {
            FIFO fifo = new FIFO(allprocesses.get(i));

            System.out.println("["+(i+1)+"] Dla FIFO: ");
            System.out.println(" 3 ramki " + fifo.missing_pages(3) / 100);
            x3F+=fifo.missing_pages(3);
            x5F+=fifo.missing_pages(5);
            x7F+=fifo.missing_pages(7);
            System.out.println(" 5 ramek " + fifo.missing_pages(5) / 100);
            System.out.println(" 7 ramek " + fifo.missing_pages(7) / 100);

            System.out.println("["+(i+1)+"] Dla LFU: ");
            LFU lfu = new LFU(allprocesses.get(i));
            System.out.println(" 3 ramki " + lfu.missing_pages(3) / 100);

            System.out.println(" 5 ramek " + lfu.missing_pages(5) / 100);
            System.out.println(" 7 ramek " + lfu.missing_pages(7) / 100);
            x3L+=lfu.missing_pages(3);
            x5L+=lfu.missing_pages(5);
            x7L+=lfu.missing_pages(7);

        }
        System.out.println("Srednia liczba brakujacych stron Dla FIFO: ");
        System.out.println(" 3 ramki " + x3F/10000);
        System.out.println(" 5 ramek " + x5F/10000);
        System.out.println(" 7 ramek " + x7F/10000);
        System.out.println("Srednia liczba brakujacych stron Dla LFU: ");
        System.out.println(" 3 ramki " + x3L/10000);
        System.out.println(" 5 ramek " + x5L/10000);
        System.out.println(" 7 ramek " + x7L/10000);
    }
}
