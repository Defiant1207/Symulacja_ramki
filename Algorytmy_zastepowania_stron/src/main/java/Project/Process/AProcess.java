package Project.Process;

public abstract class AProcess implements IProcess {

    int page;

    public AProcess(int page) {

        this.page = page;
    }

    @Override
    public int getPage() {
        return page;
    }
}
