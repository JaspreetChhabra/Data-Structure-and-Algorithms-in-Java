class Parent{
    int anInt=100;
    Parent(){
        System.out.print("Parent");
    }
    public void display(){
        System.out.println("A" + anInt);
    }
}

class Child1 extends Parent {
    int anInt=200;
    public int display(int a){
        System.out.println("B" + anInt);
        return a;
    }
}
public class ThreadDemo
{

    public static void mythrow()
    {
        System.out.print("L0 ");
        throw new RuntimeException();
    }

    public static void main(String [] args)
    {
       Parent parent = new Child1();
       Child1 child1 = new Child1();
       int i = child1.display(10);
    }
}
