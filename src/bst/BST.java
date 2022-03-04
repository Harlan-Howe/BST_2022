/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bst;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author harlan.howe
 */
public class BST {

    private TreeNode root;

    /**
     * constructor for BST - loads the whole dictionary into memory; asks the user how many words to add to the tree,
     * and then adds that many random words from the dictionary into a tree, anchored at "root." Prints the tree
     */
    public BST()
    {
        //loads the words from the dictionary file into memory.
        ArrayList<String> dictionary = new ArrayList<String>();
        File inputFile = new File("word_list_moby_crossword.flat.txt");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(new File("word_list_moby_crossword.flat.txt")));
            String word;
            while((word = reader.readLine())!=null)
            {
                dictionary.add(word);
            }

        }catch (FileNotFoundException fnfExp)
        {
            System.out.println("File not found.");
            fnfExp.printStackTrace();
        }
        catch (IOException ioExp)
        {
            ioExp.printStackTrace();
        }
        System.out.println("Dictionary Loaded. "+dictionary.size());

        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("How many words should I add to the tree? ");
        int numWords = keyboard.nextInt();

        System.out.println("Adding words to BST...");
        for (int i=0; i<numWords; i++)
        {
            int which = (int)(Math.random()*dictionary.size());
            System.out.println(i+"\t"+dictionary.get(which));
            add(dictionary.get(which));
        }
    
        System.out.println("------------------\n"+this.toString());
    }

    /**
     * generates a string describing the Tree. This is a wrapper method for the recursive subString method.
     * @return a string describing the tree.
     */
    public String toString()
    {
        
        return subString("",root);
    }

    /**
     * recursive method to draw the tree, tabbing in for each branches left and right children, so that the tree is
     * printed sideways, with the root at leftmost.
     * @param prefix - the string to draw at the beginning of the line before the left, self, and right nodes, typically a series of tabs.
     * @param subroot - which TreeNode will serve as the root of this section of the tree.
     * @return a string describing this portion of the tree
     */
    public String subString(String prefix, TreeNode subroot)
    {
        if (subroot == null)
            return "";
        else 
        {
            String result = "";
            result+= subString(prefix+"\t",subroot.getLeft());
            result+= prefix+subroot.getValue()+"\n";
            result+= subString(prefix+"\t",subroot.getRight());
            return result; 
        }
    }

    /**
     * Adds the given string to this tree. Wrapper method for the recursive "addToSubTree"
     * @param s - string to add to the tree
     */
    public void add(String s)
    {
        if (root == null)
            root = new TreeNode(s);
        else
            addToSubTree(s,root);
    }

    /**
     * recursive method to append this string to the given subtree, anchored at subroot.
     * @param s - string to add
     * @param subroot - the root of the branch to which we should add s
     */
    public void addToSubTree(String s, TreeNode subroot)
    {
        int rel = s.compareTo(subroot.getValue());
        if (rel<0)
        {
            if (subroot.getLeft() == null)
                subroot.setLeft(new TreeNode(s));
            else
                addToSubTree(s,subroot.getLeft());
        }
        else
        {
            if (subroot.getRight() == null)
                subroot.setRight(new TreeNode(s));
            else
                addToSubTree(s,subroot.getRight());
        }
    }

    /**
     * prints a list of all the words in this tree (unindented) in reverse-alphabetical order.
     */
    public void printReverseOrder()
    {
        //TODO: write the code to make this work. This may need to be a wrapper method for a recursive call. (In which
        //  case, you'll need to write that recursive method.)
    }


    /**
     * finds the total number of letters in the entire tree.
     * @return - the number of characters.
     */
    public int getNumLetters()
    {
        //TODO: write the code to make this work. This may need to be a wrapper method for a recursive call. (In which
        //  case, you'll need to write that recursive method.)
        return -1; // temp code - replace this!
    }

    /**
     * determines whether the given string is already in this tree.
     * @param target - the string to search for.
     * @return - true if the string is in this tree; false otherwise.
     */
    public boolean contains(String target)
    {
        //TODO: write the code to make this work. This may need to be a wrapper method for a recursive call. (In which
        //  case, you'll need to write that recursive method.)
        return false; // temp code - replace this!
    }

    /**
     * finds the maximum depth of any node in the tree. Assume the root is at depth = 0.
     * @return - the depth of the deepest node, a.k.a. the depth of the tree.
     */
    public int getDepth()
    {
        //TODO: write the code to make this work. This may need to be a wrapper method for a recursive call. (In which
        //  case, you'll need to write that recursive method.)
        return -1; // temp code - replace this!
    }
    
}
