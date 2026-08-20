class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer>[] sqr = new HashMap[9]; 
        for (int s =0; s<sqr.length; s++){
            sqr[s] = new HashMap<Character,Integer>();
        }
        for (int row =0; row<board.length; row++){
            HashMap<Character,Integer> hrz = new HashMap<>();
            HashMap<Character,Integer> vtr = new HashMap<>();
            for (int col =0; col< board[row].length; col++){
                char num = board[row][col];
                char num2 = board[col][row];
                int idxSqr = (row/3)*3+(col/3);
                
                if (num>='1'&&num<='9'){
                    if(hrz.containsKey(num)||sqr[idxSqr].containsKey(num)){
                        return false;
                    }
                    else{
                        hrz.put(num,1);
                        sqr[idxSqr].put(num,1);
                    }
                }
                if (num2>='1'&&num2<='9'){
                    if (vtr.containsKey(num2)){
                        return false;
                    }
                    else{
                        vtr.put(num2,1);
                    }
                }
            }
        }
        return true;
    }
}
