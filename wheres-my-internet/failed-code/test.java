import java.util.*;

class WheresMyInternet{
	
	public static void main( String args[] ){

		int[][] edgeList;
		Scanner sc = new Scanner( System.in );

		int N = sc.nextInt();
		int M = sc.nextInt();

		edgeList = new int[N+1][2];
		int E1;
		int E2;

		for( int i = 0; i<M; i++ ){
			E1 = sc.nextInt();
			E2 = sc.nextInt();

			// System.out.println( "E1: " + E1 + " E2: " + E2 );
			edgeList[E1][0] = E2;

		}

		edgeList = checkConnectedness( edgeList, N, M );

		if( edgeList == null){
			
			System.out.println( "Connected" );
			return;

		}


		for( int j = 1; j<=N; j++ ){

			// System.out.println( "\n" + "curr: " + j + " marked?: " + edgeList[j][1] );
			if( edgeList[j][1] == 0 )
				System.out.println( j );

		}

	}

	public static int[][] checkConnectedness( int[][] edgeList, int N, int M ){

		int curr = 1;

		for( int i = 1; i<=M; i++ ){

			edgeList[curr][1] = 1;
			edgeList[ edgeList[curr][0] ][1] = 1;

			if( edgeList[curr][0] == 0 && edgeList[ edgeList[curr][0] ][0] == 0 )
				return edgeList;

			// System.out.println( "curr: " + curr + " marked?: " + edgeList[curr][1] );
			curr = edgeList[curr][0];

		}

		return null;

	} 

}




