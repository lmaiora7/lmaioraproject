
/**
 * Write a description of class RouteCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RouteCipher
{
    private String [][] letterBlock;
    private int numRows;
    private int numCols;

    public RouteCipher(int row,int col)
    {
        numRows = row;
        numCols = col;
        letterBlock = new String[row][col];
    }
    
    /**
     * Used for testing.
     * @param message the string to send to fillBlock
     * @return letterBlock;
     */
    public String[][] fillAndGetLetterBlock(String message){
        fillBlock(message);
        return letterBlock;
    }
    
    
    /**
     * Places a string into letterBlock in row-major order. 
     * @param str the string to be processed
     * Postcondition:
     *     if str.length() < numRows * numCols, "A" is placed in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    private void fillBlock(String str) {
        int inc=0;
        for(int r=0;r<numRows;r++){
            for(int c=0;c<numCols;c++){
                if(inc<str.length()){
                    letterBlock[r][c]=str.substring(inc,inc+1);
                }
                else{
                    letterBlock[r][c]="A";
                }
                inc++;
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     * Precondition: letterBlock has been filled
     * @return the encrypted string from letterBlock
     */
    private String encryptBlock()
    { /* implementation not shown in description */
        String encrypted = "";
        for(int c=0;c<letterBlock[0].length;c++)
            for(int r=0;r<letterBlock.length;r++)
                encrypted+=letterBlock[r][c];
        return encrypted;
    }

    /** Encrypts a message.
     * @param message the string to be encrypted
     * @return the encrypted message;
     *         if message is the empty string, returns the empty string 
     */
    public String encryptMessage(String message) {
        int amount=0;
        String result="";
        if(message==null)return null;
        while(amount<message.length()){
            if(amount+(numRows*numCols)>message.length()){
                String temp=message.substring(amount,message.length());
                this.fillBlock(temp);
            }
            else
                this.fillBlock(message.substring(amount,amount+(numRows*numCols)));
            
            result+=this.encryptBlock();
            amount+=numRows*numCols;
        }
        return result;
    }

}
