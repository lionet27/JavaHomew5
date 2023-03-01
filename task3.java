// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000
import java.util.ArrayDeque;
import java.util.Deque;;

public class task3 {
    public static void PrintChess(int[][] chess){
        for (int i=0;i<chess.length;i++){
            for (int j=0;j<chess[0].length;j++){
                System.out.print(chess[i][j]+"-");
            }
            System.out.println();
        }
    }

    public static boolean QueenIsPosible(int[][] chess,int k,int m){
        for (int i=0;i<k;i++){
            if(chess[i][m]==1) return false;
            if ((i-k+m)>=0){
                if(chess[i][i-k+m]==1) return false;
                }          
        }
        int count=2;
        for (int i=k+1;i<chess.length;i++){
            if(chess[i][m]==1) return false;
            if ((i-k+m)<chess[0].length){
                if(chess[i][i-k+m]==1)return false;   
            }     
            if ((i-k+m-count)>=0){ 
                if(chess[i][i-k+m-count]==1){ 
                    return false;
                } else{
                    count+=2;
                }
            } 
        }            
        count=2;
        for (int i=k-1;i>=0;i--){
            if ((i-k+m+count)<chess[0].length){
                if(chess[i][i-k+m+count]==1){
                    return false;
                }else{
                    count+=2;
                }    
            }
        }
        for (int j=0;j<m;j++){
            if(chess[k][j]==1) return false;                       
        }
        for (int j=m+1;j<chess[0].length;j++){
            if(chess[k][j]==1) return false;
        }
        return true;
    }

    public static void PutQueen(int[][] chess,int k,int m){
        chess[k][m]=1;

        for (int i=0;i<k;i++){
            chess[i][m]=8;
            if ((i-k+m)>=0)chess[i][i-k+m]=8;
        }
        int count=2;
        for (int i=k+1;i<chess.length;i++){
            chess[i][m]=8;
            if ((i-k+m)<chess[0].length) chess[i][i-k+m]=8;
            if ((i-k+m-count)>=0){ 
                chess[i][i-k+m-count]=8;
                count+=2;
            } 
        }       
        count=2;
        for (int i=k-1;i>=0;i--){
            if ((i-k+m+count)<chess[0].length){
                chess[i][i-k+m+count]=8;
                count+=2;
            }
        }
        for (int j=0;j<m;j++){
            chess[k][j]=8;
        }
        for (int j=m+1;j<chess[0].length;j++){
            chess[k][j]=8;
        }
    }

    public static int[][] ReturnChessGame(Deque<Integer> moves){
        int[][] chess = new int[8][8];
        int k=0;
        int m=0;
        int count=0;

        for (int pos : moves) {
            if(count%2==0){
                k=pos;            
            } else{
                m=pos;
                PutQueen(chess, k, m);
            }
            count+=1;            
        }
        return chess;
    }    

    public static int[][] EightQueen(int k,int m){
        int[][] chess = new int[8][8];
        Deque<Integer> moves=new ArrayDeque<>();
        int queens=0;        

        while (queens<8){
            
            for (int i=k;i<chess.length;i++){
                boolean findPlaceInRow=false;
                for (int j=m;j<chess[0].length;j++){
                    
                    if (QueenIsPosible(chess, i, j)){
                        moves.addLast(i); 
                        moves.addLast(j);
                        PutQueen(chess, i, j);
                        queens+=1; 
                        findPlaceInRow=true;
                        m=0;
                    }                
                }
                if (findPlaceInRow==false){                    
                    m=moves.removeLast()+1;
                    k=moves.removeLast();
                    queens-=1;
                    while(m>8){
                        m=moves.removeLast()+1;
                        k=moves.removeLast(); 
                        queens-=1;                       
                    }                                        
                    chess=ReturnChessGame(moves);
                    break;
                }
            }            
        }
        return chess;
    }
   
    public static void main(String[] args) {
        int[][] chess = new int[8][8];
        for (int j=0;j<7;j++){
            chess=EightQueen(0, j);
            PrintChess(chess);
            System.out.println();
        }   
    }
    
}
