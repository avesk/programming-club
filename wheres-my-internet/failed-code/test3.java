class WheresMyInternet{
	
	public static void main( String args[] ){

		Scanner sc = new Scanner( System.in );

		int N = sc.nextInt();
		int M = sc.nextInt();

		//An array to store the houses
		ArrayList houseList = new ArrayList();
		//Create the first house and sets marked as true, because first house always has internet
		houseList.add( 1, new House( 1 ) );
		houseList.get( 1 ).marked = true;

		int H1;
		int H2;

		for( int i = 0; i<M; i++ ){

			//Establish E1 and E2 as the two houses which are connected
			H1 = sc.nextInt();
			H2 = sc.nextInt();

			//Only add the house to the house list, if its place is empty
			if( houseList.get(H1) == null )
				houseList.add( H1, new House( H1 ) );

			if( houseList.get(H2) == null )
				houseList.add( H2, new House( H2 ) );

			//add the houses to each of the respective edgeLists
			houseList.get(H1).edgeList.add( houseList.get(H2) );
			houseList.get(H2).edgeList.add( houseList.get(H1) );

		}

		for( int b = 1; b<=N; b++ ){


			System.out.println( "House #: " + houseList[b].val);

			for( int c = 0; c<houseList.get(b).edgeList.size(); c++ ){

				System.out.print( houseList.get(b).edgeList.get( c ).val + ", "  );

			}
			

		}

/**
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
**/
	}

/**
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
**/

	static class House{

		int val;
		boolean marked = false;
		LinkedList edgeList = new LinkedList();

		House( int v ){

			val = v;

		}

	}

}