package project.Processes;

import project.Map.IQueue;

import java.util.HashMap;
import java.util.Map;

public abstract class AProcess implements IProcess {

    protected Map<EProcessProperty, Double> stats;
    protected IQueue queue;

    public AProcess(int P, int a, IQueue queue) {
        stats = new HashMap<>();
        this.queue = queue;
        this.stats.put(EProcessProperty.a, (double) a);
        this.stats.put(EProcessProperty.P, (double) P);

    }

    @Override
    public double getProperty(EProcessProperty property) {
        Double value = stats.get(property);
        if (value != null)
            return value;
        return 0;
    }


}
