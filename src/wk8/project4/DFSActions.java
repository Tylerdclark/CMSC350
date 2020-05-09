package wk8.project4;

public interface DFSActions<E> {
public void cycleDetected();
public void processVertex(E content);
public void descend();
public void ascend();
}
