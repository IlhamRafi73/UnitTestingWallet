import java.util.stream.DoubleStream;

public class Calculator {

    int val1;
    int val2;

    public Calculator(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int add(){
        return val1 + val2;
    }

    public int minus(){
        return val1 + val2;
    }

    public int multiply(){
        return val1 * val2;
    }

    public int divide(){
        return val1 / val2;
    }
}