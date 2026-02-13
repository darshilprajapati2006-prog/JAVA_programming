package OOPs;
abstract class Programming{
    public abstract void Dev();
}
class Html extends Programming{
    @Override
    public void Dev() {
        System.out.println("tim berners lee");
    }
}
class Java extends Programming{
    @Override
    public void Dev() {
        System.out.println("james gosling");
    }
}

public class AbstractMethod {
    static void main(String[] args) {
        Html r1 = new Html();
        Java r2 = new Java();
        r1.Dev();
        r2.Dev();
    }
}


