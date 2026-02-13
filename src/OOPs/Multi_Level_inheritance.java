package OOPs;
class x{
    int a,b,c;
    void add(){
        a=10;
        b=20;
        c=a+b;
        System.out.println("sum of two no : "+c);
    }
    void sub(){
        a=20;
        b=14;
        c=a-b;
        System.out.println("sub of two no : "+c);
    }
}
class y extends x{
    void multi(){
        a=10;
        b=20;
        c=a*b;
        System.out.println("multi of two no : "+c);
    }
    void div(){
        a=20;
        b=10;
        c=a/b;
        System.out.println("div of two no : "+c);
    }
}
class z extends y{
    void rem(){
        a=10;
        b=20;
        c=a%b;
        System.out.println("rem of two no : "+c);
    }
}
class Multi_Level_inheritance {
    public static void main(String[] args) {
        z r = new z();
        r.add();
        r.sub();
        r.multi();
        r.div();
        r.rem();
    }
}
