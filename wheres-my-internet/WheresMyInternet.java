import java.util.*;

class WheresMyInternet{
	
	public static void main( String args[] ){

		Scanner sc = new Scanner( System.in );

		int N = sc.nextInt();
		int M = sc.nextInt();

		//An array to store the houses
		ArrayList<House> houseList = new ArrayList<House>(1);
		//Create the first house and sets marked as true, because first house always has internet

		//Add a dud house
		houseList.add( new House( 0 ) );
		//Set it as marked to avoid it being printed
		houseList.get( 0 ).marked = true;

		for( int i = 1; i<=N; i++ ){

			houseList.add( new House( i ) );

		}

		//Declare the two house vars which will be fed line by line into the program
		int H1;
		int H2;

		//Populate each house in the arrayList with linkedList edges
		for( int i = 0; i<M; i++ ){

			//Establish H1 and H2 as the two houses which are connected
			H1 = sc.nextInt();
			H2 = sc.nextInt();

			houseList.get(H1).edgeList.add( houseList.get(H2) );
			houseList.get(H2).edgeList.add( houseList.get(H1) );

		}

		verifyInternet( houseList.get(1) );

		Boolean isConnected = true;
		for( House unmarked : houseList ){

			if( !unmarked.marked ){
				isConnected = false;
				System.out.println( unmarked.val );

			}
				
		}

		if( isConnected )
			System.out.println( "Connected" );	

	}

	public static void verifyInternet( House H ){

		H.marked = true;

		for( House h : H.edgeList ){

			if( h.marked == true )
				continue;
			else
				verifyInternet( h );

		}

		return;
		
	}


	static class House{

		int val;
		boolean marked = false;
		LinkedList<House> edgeList = new LinkedList<House>();

		House( int v ){

			val = v;

		}

	}

}






