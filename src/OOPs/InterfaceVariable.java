package OOPs;
interface customerRaj{
    int amt = 5;  //public+static+final
    void purchase();  //public+abstract
}
class sellerSanju implements customerRaj{
    @Override
    public void purchase(){
        System.out.println("raj needs" + " "+amt+" " +"kg rice");
    }
}
public class InterfaceVariable {
    static void main(String[] args) {
        customerRaj c = new sellerSanju();
        c.purchase();
    }
}
