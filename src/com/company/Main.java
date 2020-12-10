package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    /**
     * Recursively counts the length of a string
     * @param str String
     * @return Length of string
     */
    public static int countString( String str){
        //base case
        if( str.length() == 0) {
            return 0;
        }
        //general case
        else {
            return ( 1 + countString(str.substring(0, str.length() - 1)) );
        }
    }

    /**
     * Recursively counts non-vovels
     * @param str
     * @return number of non-vovels
     *
     */
    public static int countNonVowel( String str){
        str = str.toLowerCase();

        if( str.length() == 0){
            return 0;
        }
        if ( !( str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i'
                || str.charAt(0) == 'o' || str.charAt(0) == 'u')){
            return 1 + countNonVowel( str.substring( 1 ) );
        }
        else {
            return countNonVowel( str.substring( 1 ) );
        }

    }

    public static ArrayList<String> binaryString( int n ){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> an_1;
        ArrayList<String> an_2;

        //base case
        if( n == 0 ){
            result.add("");
        }
        else if( n == 1){
            result.add( "0");
            result.add( "1");
        }
        else if ( n == 2){
            result.add( "00" );
            result.add( "01" );
            result.add( "10" );
        }
        else{
            an_1 = binaryString( n - 1 );
            an_2 = binaryString( n - 2 );
            for( int i = 0; i < an_1.size(); i++){
                result.add( an_1.get(i) + "0" );
            }
            for( int i = 0; i < an_2.size(); i++){
                result.add( an_2.get(i) + "01" );
            }
        }
        return result;
    }

    public static int countFiles( String dir){
        File file = new File( dir );
        File[] list = file.listFiles();
        int sum = 0;

        if( list.length == 0){
            return sum;
        }

        else{
            list = file.listFiles();
            for ( int i = 0; i < list.length; i++){
                if( list[i].isDirectory() )
                    // +1 resembles the file itself and countFiles gives the files inside of it.
                sum  = 1 + sum + countFiles( list[i].toString() );
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println( "Length of abcdefh is: ---> " + countString( "abcdefh"));
        System.out.println( "Non-vowel count of \"CS102 is a good course\" is: ---> "  + countNonVowel( "CS102 is a good course"));
        System.out.println( "All binary strings of length n  without 1's that come "+
                "together are: ");
        for( String s : binaryString( 3 )){
            System.out.println( s );
        }
    }
}
