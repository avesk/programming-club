public class Solution {

    public static void main( String[] args ){

        isPalindrome(434);

    }

    public static boolean isPalindrome(int x) {
        
        int numDigits;
        
        try{
        
            numDigits = (int) Math.log10( x ) +1;
            
        }
        catch( Exception e ){
            
            numDigits = 1;
            
        }
        
        int j = numDigits;
        int lower;
        int upper;
        
        for( int i = 1; i<numDigits; i++ ){
            
            lower = ( x % 10*i ) / 10*(i-1);
            upper = ( x % 10*j ) / 10*(j-1);
            
            System.out.println( "Lower: " + lower + '\n' + "Upper: " + upper );
            
            if( upper != lower )
                return false;
            
            j--;
            
        }
        
        return true;
            
            
        
        
        
    }
}