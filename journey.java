//Caron Rademan g21r7490
//Practical 1 Task 9
import library.*;
import java.util.ArrayList; //check if this import is allowed ??
public class journey{
	public static void printMatrixToConsole(ArrayList<String>stops, int [][] absDistances){
		int len = stops.size();
		//find the longest bus stop string 
		int maxStopNameLen = stops.get(0).length();
		for (String s: stops){
			if (s.length()>maxStopNameLen){
				maxStopNameLen = s.length();
			}
		}
		String space=""; //space to put before the first bus stop name
		for (int i=0;i<maxStopNameLen+2;i++){
			space=space+" ";
		}
		//print out the "poster":
		//1. print out the column headings
		IO.write(space);
		for (String s:stops){
			IO.write(s+"  ");
		}
		IO.writeLine();
		//2.print out the row headings and data
		for (int i=0; i<len; i++){
			IO.write(stops.get(i));//print out the row heading
			//sp before the first number is standard space - row heading
			int sp = (space.length()+4-stops.get(i).length());
			for (int k=0;k<sp;k++){
				IO.write(" ");
			}
			for (int j=0; j<len;j++){
				IO.write(absDistances[i][j]+"      ");//six spaces between numbers that are 2 digits
				if (absDistances[i][j]<10){ //add an extra space for one digit number
					IO.write(" ");
				}
			}
			IO.writeLine();
		} 	
	}//printMatrix
	

	public static int[][] makeMatrix(ArrayList<String>stops, ArrayList<Integer>distances){
		//make an arraylist of "coordinates" corresponding to the stops, with first stop having a zero "coordinate"
		ArrayList<Integer>coordinates = new ArrayList<Integer>();
		int sum = 0;
		coordinates.add(sum); //first stop will be 0
		for (Integer d: distances){
			sum=sum+d;
			coordinates.add(sum);
		}
		//make a 2d array of absolute distances between stops
		int len = stops.size();
		int [][] absDistances = new int [len][len]; //matrix will be symmetrical (numberofstops x numberofstops)
		for (int i=0; i<len; i++){ //two for loops for rows and columns
			for (int j=0; j<len;j++){
				absDistances[i][j]=Math.abs(coordinates.get(i)-coordinates.get(j));
			}
		}
		return absDistances; //return the matrix to main method
	}//makeMatrix
	
	
	public static void main (String [] args){
		//prompt the user and take in name of file with data
		String filename = IO.readString("Enter the name of your file: ");
		//IO.writeLine(filename);
		//read the file and create a list of the data
		InFile data = new InFile (filename);
		//check for error
		if (data.openError()){
			IO.writeLine("cannot open");
		}//if
		ArrayList<String>stops = new ArrayList<String>();//create an ArrayList to hold the names of the bus stops
		String place = data.readWord();
		ArrayList<Integer>distances = new ArrayList<Integer>();
		int dist;
		//read the file to get the names of the stops and distances
		while(!data.noMoreData()){
			stops.add(place);
			dist = data.readInt();
			if (data.noMoreData()){
				break;
			}
			distances.add(dist);
			place = data.readWord();
		}//while
		//IO.writeLine(stops);
		//IO.writeLine(distances);
		
		//make the matrix:
		int [][] matrix = makeMatrix(stops,distances);
		printMatrixToConsole(stops,matrix);
	}//main
}