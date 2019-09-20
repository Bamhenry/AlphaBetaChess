import javax.swing.*;

public class AlphaBetaChess {  
    //P,R,K,B,Q,A = Pawn, Rook, Knight, Bishop, Queen, King 
    static String chessBoard[][]={
        {"r","k","b","q","a","b","k","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","K","B","Q","A","B","K","R"}};
    
    //C monitors capitals; L monitors lower cases
    static int kingPositionC, kingPositionL;
    
    public static void main(String[] args) {
//        JFrame f=new JFrame("Chess Game");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        UserInterface ui=new UserInterface();
//        f.add(ui);
//        f.setSize(500, 500);
//        f.setVisible(true);
          System.out.println(possibleMoves());
    } 
    
    public static String possibleMoves() {
        String list="";
        
        for (int i=0; i<64; i++){
            switch (chessBoard[i/8][i%8]) {
                case "P":
                    list+=possibleP(i);
                    break;
                case "R":
                    list+=possibleR(i);
                    break;
                case "K":
                    list+=possibleK(i);
                    break;
                case "B":
                    list+=possibleB(i);
                    break;
                case "Q":
                    list+=possibleQ(i);
                    break;
                case "A":
                    list+=possibleA(i);
                    break;
            }
        }
        return list; //x1, y1, x2, y2, captured piece
    }
    
    //possible moves for pawn
    public static String possibleP(int i) {
        //
        String list="";
        return list;
    }
    //possible moves for rook
    public static String possibleR(int i) {
        String list="";
        return list;
    }
    //possible moves for knight
    public static String possibleK(int i) {
        String list="";
        return list;
    }
    //possible moves for bishop
    public static String possibleB(int i) {
        String list="";
        return list;
    }
    //possible moves for queen
    public static String possibleQ(int i) {
        String list="";
        return list;
    }
    //possible moves for king
    public static String possibleA(int i) {
        //add castling
        String list="", oldPiece;
       
        int r=i/8, c=i%8;
        for (int j=0; j<9; j++){
            if (j!=4) {
                try{
                //[r][c] is position of king before it is moved
                //[r-1][c-1] is the upper, leftmost location the king can move
                //[j/3][j%3] for values of j between 0 and 9 represent the 3 rows of 3 columns each
                //combining them: [r-1+j/3][c-1+j%3] starts in the upper, leftmost square the king
                //can possibly move to and combs through each option.
                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) ||
                            " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
                        oldPiece=chessBoard[r-1+j/3][c-1+j%3];
                        chessBoard[r][c]=" ";
                        chessBoard[r-1+j/3][c-1+j%3]="A";
                        int kingTemp=kingPositionC;
                        //update new location for king
                        kingPositionC=i+(j/3)*8+j%3-9;
                        if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                        }
                        //after check king, put king back to original spot
                        chessBoard[r][c]="A";
                        chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
                        kingPositionC=kingTemp;                    
                    }
                } catch (Exception e){}
            }
        }
        return list;
    }
    public static boolean kingSafe(){
        return true;
    }
}
