import javax.swing.*;

public class AlphaBetaChess {  
    //P,R,K,B,Q,A = Pawn, Rook, Knight, Bishop, Queen, King 
    static String chessBoard[][]={
        {"r","k","b","q","a","b","k","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"R"," "," "," "," "," "," "," "},
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
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        
        //vertical moves
        for (int j=-1; j<=1; j+=2) {
            try {
                while (" ".equals(chessBoard[r][c+temp*j])) {
                    //move rook from it's current location
                    oldPiece=chessBoard[r][c+temp*j];
                    //set old loaction to nothing
                    chessBoard[r][c]=" ";
                    //set new location to rook
                    chessBoard[r][c+temp*j]="R";
                    if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+r+(c+temp*j)+oldPiece;
                     }                 
                    //if king is save then record move
                    chessBoard[r][c]="R";
                    chessBoard[r][c+temp*j]=oldPiece;
                    temp++;
                }
                //if rook can capture
                if (Character.isLowerCase(chessBoard[r][c+temp*j].charAt(0))){
                    //move rook from it's current location
                    oldPiece=chessBoard[r][c+temp*j];
                    //set old loaction to nothing
                    chessBoard[r][c]=" ";
                    //set new location to rook
                    chessBoard[r][c+temp*j]="R";
                    if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+r+(c+temp*j)+oldPiece;
                     }                 
                    //if king is save then record move
                    chessBoard[r][c]="R";
                    chessBoard[r][c+temp*j]=oldPiece;
                }
            } catch (Exception e) {}
            temp=1;
            
            //horizontal moves
            try {
                while (" ".equals(chessBoard[r+temp*j][c])) {
                    //move rook from it's current location
                    oldPiece=chessBoard[r+temp*j][c];
                    //set old loaction to nothing
                    chessBoard[r][c]=" ";
                    //set new location to rook
                    chessBoard[r+temp*j][c]="R";
                    if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+(r+temp*j)+c+oldPiece;
                     }                 
                    //if king is save then record move
                    chessBoard[r][c]="R";
                    chessBoard[r+temp*j][c]=oldPiece;
                    temp++;
                }
                //if rook can capture
                if (Character.isLowerCase(chessBoard[r+temp*j][c].charAt(0))){
                    //move rook from it's current location
                    oldPiece=chessBoard[r+temp*j][c];
                    //set old loaction to nothing
                    chessBoard[r][c]=" ";
                    //set new location to rook
                    chessBoard[r+temp*j][c]="R";
                    if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+(r+temp*j)+c+oldPiece;
                     }                 
                    //if king is save then record move
                    chessBoard[r][c]="R";
                    chessBoard[r+temp*j][c]=oldPiece;
                }
            } catch (Exception e) {}
        }
        
        return list;
    }
    //possible moves for knight
    public static String possibleK(int i) {
        String list="";
        return list;
    }
    //possible moves for bishop
    public static String possibleB(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        //enable bishop to move diagonally
        for (int j=-1; j<=1; j+=2){
            for (int k=-1; k<=1; k+=2){
                try {
                    while(" ".equals(chessBoard[r+temp*j][c+temp*k])) {
                        //where bishop is going
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        //make current location blank
                        chessBoard[r][c]=" ";
                        //update new spot
                        chessBoard[r+temp*j][c+temp*k]="B";
                        if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c]="B";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                        oldPiece=chessBoard[r+temp*j][c+temp*k];
                        //make current location blank
                        chessBoard[r][c]=" ";
                        //update new spot
                        chessBoard[r+temp*j][c+temp*k]="B";
                        if (kingSafe()){
                            //assume king is safe for now
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                        }
                        chessBoard[r][c]="B";
                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        
                    }
                } catch (Exception e){}
                temp=1;
            }
        }
        return list;
    }
    //possible moves for queen
    public static String possibleQ(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        int temp=1;
        //enable queen to move in all eight directions
        for (int j=-1; j<=1; j++){
            for (int k=-1; k<=1; k++){
                if (j!=0 || k!=0) {
                    try {
                        while(" ".equals(chessBoard[r+temp*j][c+temp*k])) {
                            //where queen is going
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            //make current location blank
                            chessBoard[r][c]=" ";
                            //update new spot
                            chessBoard[r+temp*j][c+temp*k]="Q";
                            if (kingSafe()){
                                //assume king is safe for now
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c]="Q";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                            oldPiece=chessBoard[r+temp*j][c+temp*k];
                            //make current location blank
                            chessBoard[r][c]=" ";
                            //update new spot
                            chessBoard[r+temp*j][c+temp*k]="Q";
                            if (kingSafe()){
                                //assume king is safe for now
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            }
                            chessBoard[r][c]="Q";
                            chessBoard[r+temp*j][c+temp*k]=oldPiece;

                        }
                    } catch (Exception e){}
                    temp=1;
                }
            }
        }
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
