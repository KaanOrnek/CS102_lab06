
import java.io.File;
import java.util.Scanner;

/**
 * CS102 Lab06 - recursion implementations
 * @author Mehmet Kaan Örnek
 * @version 8.12.2020
 */
public class Lab06 {
    public static void main ( String [] args)
    {
        Scanner scan = new Scanner(System.in);
        String strFor1;
        String strFor2;
        int intFor3;

        final String SPR = "**************"; //seperator

        System.out.print( SPR + "1" + SPR + "\nEnter a string;");
        strFor1 = scan.nextLine();
        System.out.println( "Input: " + strFor1 + "\nOutput: " + countLength(strFor1));

        System.out.print( "\n" + SPR + "2" + SPR + "\nEnter a string:");
        strFor2 = scan.nextLine();
        System.out.println( "Input: " + strFor2 + "\nOutput: " + nonVowels(strFor2,0));

        System.out.print( "\n" +SPR + "3" + SPR + "\nEnter an int:");
        intFor3 = scan.nextInt();
        System.out.println( "Input: \n"+ intFor3 + "\nOutput:");
        printBinaryStrings( intFor3 );

        System.out.println( "\n" +SPR + "4"+ SPR );
        File a = new File("C:/Users/Kaan/Desktop/teori çalış");
        File[] files = a.listFiles();
        System.out.println("The number of the files in the given directory is: " + fileNum(files,0));
    }

    /**
     * Recursion based method for counting length of the sting
     */
    public static int countLength( String str )
    {
        if(str.length()==1)
            return 1;
        return 1 + countLength(str.substring(0,str.length()-1));
    }

    /**
     * Recursion based method for finding the num of non-vowels in a given array of characters
     */
    public static int nonVowels( String str,int index )
    {
        if(index == countLength(str))
            return 0;
        else {
            if( isVowel(str.charAt(index),0) || str.charAt(index) == ' ')
                return nonVowels(str,index+1);
            return 1+nonVowels(str,index+1);
        }



    }
    /**
     * A method for checking if the given char is vowel or not
     */
    public static boolean isVowel(char entry,int startingPoint)
    {
        String vowels = "AaEeIiOoUu";
        if( startingPoint == countLength(vowels))
            return false;
        if( entry == vowels.charAt(startingPoint))
            return true;
        else
            return isVowel(entry,startingPoint+1);

    }

    /**
     * Recursion based method for printing all the binary strings (except only 1s together) of given length
     */
    public static void printBinaryStrings( int length )
    {
        if( length <= 0)
            System.out.println("Invalid input for a binary.");
        else
        {
            char[] str = new char[length];
            str[0] = '1';
            generateBinaryStrings(length,str,1);
            str[0] = '0';
            generateBinaryStrings(length,str,1);

        }
    }

    /**
     * Recursion based method for generating all the binary strings (except only 1s together) of given length
     */
    public static void generateBinaryStrings( int length, char[] output, int digit )
    {
       if( digit == length)
           System.out.println(output);
       else{
           if(output[digit-1] == '1')
           {
               output[digit]='0';
               generateBinaryStrings(length,output,digit+1);
           }
           if(output[digit-1] == '0')
           {
               output[digit]='0';
               generateBinaryStrings(length,output,digit+1);
               output[digit]='1';
               generateBinaryStrings(length,output,digit+1);
           }

       }
    }
    /**
     * Recursive method for counting the num of files in the given directory
     */
    public static int fileNum( File[] source,int startingPoint)
    {
        if( startingPoint >= source.length)
            return 0;
        else{
            if( source[startingPoint].isDirectory())
            {
                int x = 0;
                return fileNum(source[startingPoint].listFiles(),x)+fileNum(source,startingPoint+1);
            }
            else if( source[startingPoint].isFile())
                return 1+fileNum(source,startingPoint+1);
            else
                return fileNum(source, startingPoint);
        }
    }
}
