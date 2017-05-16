package EffectiveJava;

public class StaticFactory
{
    public StaticFactory()
    {

    }

    public static int factoryMethod()
    {
        return 1;
    }

    public int getSum(int val1, int val2)
    {
        return (val1 + val2);
    }

    public static void main(String[]args){
        System.out.print(StaticFactory.factoryMethod());
    }
}

/*
1) static factory can have names whereas constructor doesn't.
2) no new object needs to be created unlike constructors.
3) Easy to read and can create any number of static methods.
 */