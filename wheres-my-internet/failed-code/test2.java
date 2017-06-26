import java.util.*;

class WheresMyInternet{
	
	public static void main( String args[] ){

		Scanner sc = new Scanner( System.in );

		int N = sc.nextInt();
		int M = sc.nextInt();

		//An array to store the houses
		House[] houseList = new House[N+1];
		//Create the first house and sets marked as true, because first house always has internet
		houseList[1] = new House( 1 );
		houseList[1].marked = true;

		int E1;
		int E2;

		for( int i = 0; i<M; i++ ){

			//Establish E1 and E2 as the two houses which are connected
			E1 = sc.nextInt();
			E2 = sc.nextInt();

			//Only add the house to the house list, if its place is empty
			if( houseList[E1] == null )
				houseList[E1] = new House( E1 );

			if( houseList[E2] == null )
				houseList[E2] = new House( E2 );

			// System.out.println( "E1: " + houseList[E1].val + "E2: " + houseList[E2].val + "EdgeList Length: " + houseList[E1].edgeList.length );

			//
			if( houseList[E1].edgeList[0] == null )
				houseList[E1].edgeList[0] = houseList[E2];
			else
				houseList[E1].edgeList[1] = houseList[E2];

			if( houseList[E2].edgeList[0] == null )
				houseList[E2].edgeList[0] = houseList[E1];
			else
				houseList[E2].edgeList[1] = houseList[E1];

		}

		if( isConnected( houseList[1], N ) )
			System.out.println( "Connected" );
		else{

			for( int a = 1; a<=N; a++){
				// Null pointer exception occurs here if I don't include "houseList[a] != null" as a condition
				// However, I get the wrong answer if I do include it
				if( houseList[a] != null && !houseList[a].marked )
					System.out.println( houseList[a].val );

			}
		}

/*** For testing graph ***/
		// for( int j=1; j<=N; j++ ){

		// 	System.out.println( "House: " + houseList[j].val );
		// 	for( int k=0; k<2; k++ ){

		// 		try{

		// 			System.out.println( "EdgeTo: " + houseList[j].edgeList[k].val );

		// 		}
		// 		catch( Exception e ){

		// 		}

		// 	}
		// }

	}

	public static boolean isConnected( House h, int N ){

		int count = 0;
		h.marked = true;

		while( true ){

			count++;

			if( h.edgeList[0] != null && !h.edgeList[0].marked )
				h = h.edgeList[0];
			else if( h.edgeList[1] != null && !h.edgeList[1].marked )
				h = h.edgeList[1];
			else
				break;

			h.marked = true;

		}

		if( count == N )
			return true;
		else
			return false;

	}

	static class House{

		int val;
		boolean marked = false;
		House edgeList[] = new House[2];

		House( int v ){

			val = v;

		}

	}

}






