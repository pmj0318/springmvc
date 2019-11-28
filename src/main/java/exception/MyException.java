package exception;

public class MyException  extends Exception{
    private  String mgs;

    public MyException(String mgs) {
        super(mgs);
        this.mgs = mgs;
    }
}
