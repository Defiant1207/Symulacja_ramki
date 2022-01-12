package project.Processes;


import project.Map.IQueue;


public interface IProcess {

    /**
     * zwraca podany parametr
     * @param property
     * @return property
     */

    double getProperty(EProcessProperty property);

}
