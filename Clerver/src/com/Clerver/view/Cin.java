package com.Clerver.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cin
{

   private static BufferedReader cin =  new BufferedReader (new InputStreamReader (System.in));
   
   public static int readInt ()
   {
     String input = "";
     int val = 0;
     
     try
     {
       input = cin.readLine();
       val = Integer.parseInt (input);
     }
     catch (IOException e) {}
     catch (NumberFormatException e) {}    
     return val;
   }
   
   public static String readString ()
   {    
     String val = "";
     
     try
     {
       val = cin.readLine();
     }
     catch (IOException e) {}
     return val;
   }
}
