import java.io.BufferedReader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.fastica.*;
import org.*;
import java.io.*;
import javax.sound.sampled.*;
import Jama.*;


public class Mesma {
	
	final static int NE=5;
	
	

	
	public static void main(String[] args) throws FastICAException {
		
		
		Scanner scan =new Scanner(System.in);		
		double EL[][]= new double[NE][72];
		
		
		int i,j;
	//Read the End-members from the library
		
		/*File EL_file = new File("file.txt");
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(EL_file));
		    String text = null;
		    for( i=0;i<NE;i++)
		    	
		    	{
                   j=0;
		    while ((text = reader.readLine()) != null) {
		        EL[i][j]=(Integer.parseInt(text));
		        j++;
		    }
		}} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		*/
		
		//Input data
		
		double[][] pix_spec=new double[1000][72];
		int k;
		int Bands=72;
		int count=0;
		int pixels=1000;
		File file_1=new File("CRSdata.txt");
				
	              try {
					Scanner sc = new Scanner(file_1);
					sc.useDelimiter(",");
					
					for( i=0;i<pixels;i++){
					    for( j=0;j<Bands;j++){
					        pix_spec[i][j]=sc.nextDouble();
					       count++;
					        System.out.println(count);
					    }
					    sc.nextLine();
					}
					sc.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	              FastICA test = null;          
	              
    //Calculating Independent Components using Fast ICA
	try{ test = new FastICA(pix_spec,5);}
	catch(FastICAException  f)
	{f.printStackTrace();}
	
	//Getting Independent Components
	
	double[][] IC=test.getICVectors();// 5 rows 72 columns
	
	
	System.out.println("number of independent components--"+IC.length);
	System.out.println("Length of each component--"+IC[0].length);
	
	Matrix  A= new Matrix(IC);
	Matrix A_trans= A.transpose();
	Matrix A_trans_A= A_trans.times(A);
	Matrix A_trans_A_inv=A_trans_A.inverse();
	Matrix mult_pix=A_trans_A_inv.times(A_trans);
	
	
	
	
	
	
	
	
	
	
	
	              
		//Initialize the Matrix-Model
	//	for (double[] row: MM)
	  //  Arrays.fill(row, 0.0);
		
		/*for(i=0;i<N;i++)
			for(j=0;j<NE;j++)
			{
				
				
				
				
				
				
			}*/
		
		

	
		
		
		
		
		
		

	}

}
