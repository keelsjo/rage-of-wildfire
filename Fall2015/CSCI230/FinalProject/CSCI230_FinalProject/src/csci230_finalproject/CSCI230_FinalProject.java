/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci230_finalproject;

import java.util.Random;

/**
 *
 * @author Home
 */
public class CSCI230_FinalProject
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] values = new int[500];
        Random num = new Random();
        
        for(int i = 0; i < values.length; i++){
            values[i] = num.nextInt(values.length / 2);
        }
        
        OpenHashing opHash = new OpenHashing();
        ClosedHashing clHash = new ClosedHashing();
        
        for (Object value : values)
        {
            try
            {
                opHash.addValue((Comparable)value);
            }
            catch (UnhashableDataTypeException ex)
            {
                
            }
        }
        
        for (Object value : values)
        {
            try
            {
                clHash.addValue(value);
            }
            catch (UnhashableDataTypeException ex)
            {
                
            }
            
        }
        int go = 7;
    }
    
}
