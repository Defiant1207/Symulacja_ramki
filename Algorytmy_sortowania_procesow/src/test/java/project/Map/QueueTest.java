package project.Map;

import org.junit.Assert;
import org.junit.Test;
import project.Processes.Process;
import project.Processes.IProcess;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void sortTest(){
        IQueue q1 = new Queue(5);
        List<IProcess> fcfs = new ArrayList<>();
        IProcess proces1 = new Process(4,5,q1);
        IProcess proces2 = new Process(2,6,q1);
        IProcess proces3 = new Process(8,5,q1);
        IProcess proces4 = new Process(25,4,q1);
        IProcess proces5 = new Process(21,3,q1);
        fcfs.add(proces1);
        fcfs.add(proces2);
        fcfs.add(proces3);
        fcfs.add(proces4);
        fcfs.add(proces5);


        for(int i=0; i<5; i++){
            while(!q1.settleProcess(fcfs.get(i),i));
        }
        q1.sort();

         assertEquals(5.0,q1.getProcessA(2),"process1");
         assertEquals(4.0,q1.getProcessA(1),"process2");
         assertEquals(6.0,q1.getProcessA(4),"process3");
         assertEquals(5.0,q1.getProcessA(3),"process4");
        assertEquals(3.0,q1.getProcessA(0),"process5");
        assertEquals(4.0,q1.getProcessP(2),"process5");

    }
    @Test
    public void waitingTimeTest(){
        IQueue q1 = new Queue(5);
        List<IProcess> fcfs = new ArrayList<>();
        IProcess proces1 = new Process(4,5,q1);
        IProcess proces2 = new Process(2,6,q1);
        IProcess proces3 = new Process(8,5,q1);
        IProcess proces4 = new Process(25,4,q1);
        IProcess proces5 = new Process(21,3,q1);
        fcfs.add(proces1);
        fcfs.add(proces2);
        fcfs.add(proces3);
        fcfs.add(proces4);
        fcfs.add(proces5);

        for(int i=0; i<5; i++){
            while(!q1.settleProcess(fcfs.get(i),i));
        }
        q1.sort();
        double[] tablica =q1.waitingTime();
        assertEquals(167.0,tablica[0]);
        assertEquals(60.0,tablica[1]);


    }

}