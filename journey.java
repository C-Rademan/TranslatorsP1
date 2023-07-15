//Caron Rademan g21r7490
//Practical 1 Task 9
import library.*;
import java.util.ArrayList; //check if this import is allowed ??
public class journey{
	public static void makeMatrix(String [] stops, Integer [] distances){
		
		
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
		IO.writeLine(stops);
		IO.writeLine(distances);
		
	}//main
}