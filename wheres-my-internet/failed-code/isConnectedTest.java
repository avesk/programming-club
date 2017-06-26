public static boolean isConnected( ArrayList<House> houseList, int N ){

		// if 1 is disconnected, than print out all elements
		if( houseList.get(1).edgeList.size() == 0 )
			System.out.println( "1 is disconnected" );

		//set all houses that are a child of 1 as marked
		for(House child : houseList.get(1).edgeList)
				child.marked = true

		//Set all houses that have internet as marked by iterating through each marked house
		House h;
		for( int i = 2; i<=N; i++ ){

			h = houseList.get(i);

			if( h.marked ){

				for(House x : h.edgeList)
					x.marked = true;

			}

		}

		return false;
		
	}