package wk8.project4;

public class Hierarchy<E> implements DFSActions<E>{

    StringBuilder toPrint = new StringBuilder();
    int indentCounter = 0;

    @Override
    public void cycleDetected() {
        //admittedly lazy way to ensure the asterisk is not printed on the next line
        toPrint.setLength(toPrint.length()-1); //deleting the \n added from processVertex()
        toPrint.append(" * ").append("\n");

    }

    @Override
    public void processVertex(E content) {
        //either zero or some indent, so it repeats the max of counter or zero
        toPrint.append(" ".repeat(Math.max(0, indentCounter)));
        toPrint.append(content).append("\n");
    }

    @Override
    public void descend() {
        indentCounter += 4;
    }

    @Override
    public void ascend() {
        indentCounter -= 4;
    }

    @Override
    public String toString() {
        return toPrint.toString();
    }
}
