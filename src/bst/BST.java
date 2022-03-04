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
        
        for (int i=0; i<numWords; i++)
        {
            int which = (int)(Math.random()*dictionary.size());
            System.out.println(dictionary.get(which));
            add(dictionary.get(which));
        }
    
        System.out.println("------------------\n"+this.toString());
    }
    
    public String toString()
    {
        
        return subString("",root);
    }
        
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
    public void add(String s)
    {
        if (root == null)
            root = new TreeNode(s);
        else
            addToSubTree(s,root);
    }
    
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
    
    
    
    
    
}
