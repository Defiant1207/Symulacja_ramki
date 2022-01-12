package project;

import project.Map.IQueue;
import project.Map.Queue;
import project.Processes.IProcess;
import project.Processes.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {


        File dane = new File("dane.txt");
        boolean exist = dane.exists();

        String absolutePath = dane.getAbsolutePath();
        System.out.println("sciezka: "+absolutePath);
        System.out.println("Czy plik istnieje =" +exist);


        Scanner scanner = new Scanner(dane);
        int dataBase[][] = new int[10000][200];
        Map<Integer,List<IProcess>> procesy = new LinkedHashMap<Integer,List<IProcess>>();
        Map<Integer,IQueue>Queue = new LinkedHashMap<Integer,IQueue>();



        while (scanner.hasNext()) {
            for(int k=0; k<100; k++){
                List<IProcess> lcfs = new ArrayList<>();
                IQueue q1 = new Queue(100);
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 2; j++) {
                    dataBase[i][j] = scanner.nextInt();
                }
                IProcess proces = new Process(dataBase[i][1], dataBase[i][0], q1);
                lcfs.add(proces);
            }
            procesy.put(k,lcfs);
            Queue.put(k,q1);
        }
        }

for(int j=0; j<100; j++) {
    for (int i = 0; i < 100; i++) {
        while (!Queue.get(j).settleProcess(procesy.get(j).get(i), i)) ;
    }
    Queue.get(j).sort();
}

double x=0;
double y=0;
double y2=0;
double z=0;
for(int i=0; i<100; i++) {
    double[] tablica = Queue.get(i).waitingTime();

    System.out.println("["+(i+1)+"]"+"sredni czas oczekiwania procesu metoda FCFS = " + tablica[0] / 100);
    System.out.println("["+(i+1)+"]"+"sredni czas przetwarzania procesu  = " + tablica[1] / 100);
    x+=tablica[0]/100;
    y2+=tablica[1]/100;
}
System.out.println("Usredniony czas oczekiwania metoda LCFS = "+x/100);

        for(int i=0; i<100; i++) {
            Queue.get(i).sortLCFS();
            double[] tablica = Queue.get(i).waitingTime();

            System.out.println("["+(i+1)+"]"+"sredni czas oczekiwania procesu metoda LCFS = " + tablica[0] / 100);
            System.out.println("["+(i+1)+"]"+"sredni czas przetwarzania procesu  = " + tablica[1] / 100);
            z+=tablica[0]/100;
            y+=tablica[1]/100;
        }
        System.out.println("Usredniony czas oczekiwania metoda FCFS ="+x/100);
        System.out.println("Usredniony czas oczekiwania metoda LCFS ="+z/100);
        System.out.println("Usredniony czas przetwarzania metoda FCFS ="+y2/100);
        System.out.println("Usredniony czas przetwarzania metoda LCFS ="+y/100);

    }


    }