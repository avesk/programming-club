import java.util.*;

class Dvoniz{

	public static void main( String[] args ){

		Scanner sc = new Scanner( System.in );
		String[] str = sc.nextLine().split(" ");
		int N = Integer.parseInt( str[0] );
		int S = Integer.parseInt( str[1] );

		int[] input = new int[N];

		int k1 = 0;
		int k2 = 0;

		int count = 0;
		while( sc.hasNext() ){

			String line = sc.nextLine();
			int num = Integer.parseInt( line );
			input[count] = num;
			count++;

		}

		for( int i : input ){

			System.out.println( i );

		}

	}

	// public static int[] dviniz(){



	// }

}