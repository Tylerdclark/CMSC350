package wk8.project4;

public class ParenthesizedList<E> implements DFSActions<E>{

    StringBuilder toPrint = new StringBuilder();

    @Override
    public void cycleDetected() {
        toPrint.append(" * ");
    }

    @Override
    public void processVertex(E content) {
       toPrint.append(content);
    }

    @Override
    public void descend() {
        toPrint.append(" ( ");
    }

    @Override
    public void ascend() {
        toPrint.append(" ) ");
    }

    @Override
    public String toString() {
        String replaceString = toPrint.toString();
        return replaceString.replace(" (  )", "").replace("(  *  )", " * ");
    }

}
