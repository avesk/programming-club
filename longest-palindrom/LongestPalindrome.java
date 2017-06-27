import java.util.*;

class LongestPalindrome{

	public static void main( String[] args ){

		String ans;
		int centeredAt;

		Scanner sc = new Scanner( System.in );

		ans = sc.nextLine();

		System.out.println( longestPalindrome( ans ) );

		// centeredAt = sc.nextInt();	

		// System.out.println( "Palindrome length: " + palindromeAt( ans, centeredAt ) );

		// ans = longestPalindrome( sc.nextLine() );

		// System.out.println( "longestPalindrome: " + ans );

		// if( isPal( ans ) )
		// 	System.out.println( "Is Palindrome!" );
		// else
		// 	System.out.println( "Not Palindrome..." );

	}

/**
*
* Key Conditions:
*	
*	Must check both Even and Odd palindromes:
*	If Odd, procede with the regular algorithm
*	If Even, replace String with a String: 2n+1 characters, with a $ before every odd indice:
*
*	Eg.) abaaba = $a$b$a$a$b$a$
*
*	Once we find a palindrome longer than 3, we can start looking for a pivot point past the next letter in the string	
*
*	1. If the right hand palindrome is completely contained in the range of the palindrome centered at the point of reflection, this is not the
*	next possible longest palindrome
*
*	2. If the right hand palindrome extends beyond the input length, stop the algorithm and examine the longest palindrome
*
*	3. If the right hand palindrome expands to the farthest edge contained by the palindrome centered at the point of reflection, and its mirror palindrome expands to the leftmost edge, 
* 	this is the next longest possible palindrome
*
*	4. If the right palindrome expands to the rightmost edge, but its mirror palindrome expands beyond the left edge, 
* 	this is not the next possible longest palindrome
*
*
*
*
**/

	public static String longestPalindrome( String sTemp ){

		int[] lengthArray = new int[sTemp.length()*2 +1];
		int i = 0;
		int leftEdge, rightEdge;
		int nextPossibleLongest;

		String s = generateFindEvenStr( sTemp );
        // String s = sTemp;

		//Iterate until condition 2 is met
		// i = current center
		while( i < s.length() ){

			// 1. Mark down the length of that palindrome in a lengthArray at i
			lengthArray[i] = palindromeAt( s, i ); 

			// 2. Check the four conditions in the righthand radius to determine which is the next possible longest palindrome

			// Establish leftEdge and rightEdge
			leftEdge = i - lengthArray[i]/2;
			rightEdge = i + lengthArray[i]/2;

			// System.out.println( "LeftEdge: " + leftEdge + " rightEdge: " + rightEdge );

			// This will hold true if case 3 isn't met
			nextPossibleLongest = rightEdge+1;

			//Iterate through lefthand palindrome lengths checking cases
			// m = leftHand pointer
			for( int m = i-1; m >= leftEdge; m-- ){

				// System.out.println( "This is m: " + m );
                
                // if( i == 10 ){
                //     System.out.println( "lengthArray[m]: " + lengthArray[m] );
                //     System.out.println( (m - lengthArray[m]/2) + " ?= " + leftEdge
                //     + "\n" + (lengthArray[m]/2 + (2*i - m)) + " ?= " + rightEdge );
                    
                // }
                    
				// case 1: 
				if( m - lengthArray[m]/2 > leftEdge ){

					lengthArray[ 2*i - m ] = lengthArray[m];
				// 	System.out.println( "IN CASE 1!!" );

				}
				
				// case 2:
                if( i + lengthArray[m]/2+1 >= s.length()-1 ){
                    // System.out.println( "i: " + i + "\n" + "lengthArray[m]: " + lengthArray[m] );
                    // System.out.println( "IN CASE 2!!" );

					lengthArray[ 2*i - m ] = lengthArray[m];
					
				// 	for( int cnt = 0; cnt<lengthArray.length; cnt++ ){
		    
    //                     System.out.println( "Index: " + cnt + " Value: " + lengthArray[cnt] );
		    
		  //          }
		            
					return removePlaceHolders( s, lengthArray );

				}
				
				// case 3:
				else if( m - lengthArray[m]/2 == leftEdge && lengthArray[m]/2 + (2*i - m) == rightEdge ){
                    
					lengthArray[ 2*i - m  ] = lengthArray[m];
					
					if( nextPossibleLongest != rightEdge+1 ){
					    
					    if( lengthArray[ 2*i - m  ] > lengthArray[ nextPossibleLongest ] )
					        nextPossibleLongest = 2*i - m;
					}
					else
					    nextPossibleLongest = 2*i - m;
				// 	System.out.println( "IN CASE 3!!" );
				}

				// case 4:
				else if( m - lengthArray[m]/2 < leftEdge  ){

					lengthArray[ 2*i - m ] = (m - leftEdge)*2 +1;
				// 	System.out.println( "IN CASE 4!!" );

				}

			}

			i = nextPossibleLongest < s.length()-1 ? nextPossibleLongest : s.length()-1;

// 			System.out.println( "This is i end of While: " + i );

		}	
		
// 		for( int cnt = 0; cnt<lengthArray.length; cnt++ ){
		    
//             System.out.println( "Index: " + cnt + " Value: " + lengthArray[cnt] );
		    
// 		}

		return removePlaceHolders( s, lengthArray );

	}

	public static int palindromeAt( String s, int x ){

		int i = x-1;
		int j = i+2;

		while( j<s.length() && i>=0 ){
			// System.out.println( "i: " + i + " j: " + j );
			if( s.charAt(i) != s.charAt(j) )
				return (j-1) - i;
			i--;
			j++;

		}

		return (j-1) - i;
 
	}


	public static String generateFindEvenStr( String s ){

		String newString = "";

		for( int i = 0; i < s.length(); i++ ){

			newString += '$';
			newString += s.charAt( i );

		}

		newString += '$';

		return newString;

	}
	
	public static String removePlaceHolders( String s, int[] lengthArray ){
	    
	    // Find the largest palindrome centered at k
		int max = 0;
		for( int k = 0; k<lengthArray.length; k++ ){
		    
			if( lengthArray[k] > lengthArray[max] )
				max = k;

		}
	    
	    String tempLongestStr = s.substring( max - lengthArray[max]/2, max + lengthArray[max]/2 +1 );
	    String longestStr = "";

		for( int l = 1; l < tempLongestStr.length(); l+=2 ){

			longestStr += tempLongestStr.charAt( l );

		}
		
		return longestStr;
	    
	}

// edisubdsbabesuaaabbaaaoerundskracecar
// vsadfaxbabaaabbaaa

}