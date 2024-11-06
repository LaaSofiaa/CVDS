package edu.eci.cvds.patterns.archetype;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World");
        if (args.length!=0){
            System.out.println("Hello" + String.join(" ",args) );
        }

    }
}
