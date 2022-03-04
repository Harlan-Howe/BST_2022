package bst;
import java.util.Scanner;

public class BSTRunner
{
    public static void main(String[] args)
    {
        System.out.println("Creating Tree.");
        BST tree = new BST();
        System.out.println("Done creating Tree.");
        Scanner keyReader = new Scanner(System.in);
        // =============================================
        System.out.println("Press <return> to begin.");
        String dummy = keyReader.nextLine();
        System.out.println("---------------------------------- Printing in reverse order: ");
        tree.printReverseOrder();
        System.out.println("---------------------------------- Done Printing in reverse order: ");
        // =============================================
        System.out.println("Press <return> for next test.");
        dummy = keyReader.nextLine();
        System.out.println("---------------------------------- Counting num letters");
        int n = tree.getNumLetters();
        System.out.println("This tree contains "+n+" letters.");
        if  (n==-1)
            throw new RuntimeException("You got -1. I'm guessing you haven't written this part yet.");
        System.out.println("---------------------------------- Done Counting num letters.");
        // =============================================
        System.out.println("Press <return> for next test.");
        dummy = keyReader.nextLine();
        System.out.println("---------------------------------- Checking for 'Contains' 3 times.);");
        for (int i = 0; i<3; i++)
        {
            System.out.println("Enter a word to search for.");
            String target = keyReader.nextLine();
            if (tree.contains(target))
                System.out.println(target + " is in the tree.");
            else
                System.out.println(target + " is not in the tree.");
        }
        System.out.println("---------------------------------- Done checking for contains.");
        // =============================================
        System.out.println("Press <return> for next test.");
        dummy = keyReader.nextLine();
        System.out.println("---------------------------------- Finding max depth.");
        int depth = tree.getDepth();
        System.out.println("The tree has a depth of "+depth+".");
        if (depth == -1)
            throw new RuntimeException("You said the depth was -1. I'm guessing you haven't written this part yet.");
        System.out.println("---------------------------------- Done finding max depth.");
    }
}
