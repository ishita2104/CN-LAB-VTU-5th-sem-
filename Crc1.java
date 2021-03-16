import java.util.Scanner;
import java.io.*;
class Crc1 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
    
        //Input Data Stream
        System.out.print("Enter message bits: ");
        String message = sc.nextLine();
        System.out.print("Enter generator: ");
        String generator = sc.nextLine();
        int data[] = new int[message.length() + generator.length() - 1];
        int divisor[] = new int[generator.length()];
        for(int i=0;i<message.length();i++)
        	data[i] = Integer.parseInt(message.charAt(i)+"");
        for(int i=0;i<generator.length();i++)
        	divisor[i] = Integer.parseInt(generator.charAt(i)+"");
        
        //Calculation of CRC
        for(int i=0;i<message.length();i++)
        {
        	if(data[i]==1)
        		for(int j=0;j<divisor.length;j++)
        			data[i+j] ^= divisor[j];      //data array is getting modified, it stores the remainder
        }
        
        //Display CRC
        System.out.print("The checksum code is: ");
        for(int i=0;i<message.length();i++)
        	data[i] = Integer.parseInt(message.charAt(i)+"");    //data array again stores message
        for(int i=0;i<data.length;i++) 
            System.out.print(data[i]);
        System.out.println();
        
        //Check for input CRC code
        System.out.print("Enter checksum code: ");
        	message = sc.nextLine();                         // message=checksum
        System.out.print("Enter generator: ");
        	generator = sc.nextLine();
        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];
        for(int i=0;i<message.length();i++)
       data[i] = Integer.parseInt(message.charAt(i)+"");             //data array contains the checksum values which is appended with remainder
        for(int i=0;i<generator.length();i++)
        	divisor[i] = Integer.parseInt(generator.charAt(i)+"");
        
        //Calculation of remainder
        for(int i=0;i<message.length();i++) 
        {
        	if(data[i]==1)
        		for(int j=0;j<divisor.length;j++)
        			data[i+j] ^= divisor[j];
        }
        
        //Display validity of data
        boolean valid = true;
        for(int i=0;i<data.length;i++)
        	if(data[i]==1)
        	{
        		valid = false;
        		break;
            }
        
        if(valid==true) 
        	System.out.println("Data stream is valid");
        else 
        	System.out.println("Data stream is invalid. CRC error occurred.");
    }

}
