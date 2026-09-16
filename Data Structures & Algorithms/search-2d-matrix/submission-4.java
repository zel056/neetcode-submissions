class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rLength = matrix[0].length;

        int rowIdx = matrix.length-1;

        // int rHead = matrix[0][rLength-1];
        // int rTail = matrix[rowIdx][rLength-1];
        int rHead =0;
        int rTail = rowIdx;
        while (rHead<=rTail){
            int medium = rHead+(rTail-rHead)/2;
            if (target<=matrix[medium][rLength-1]&&target>=matrix[medium][0]){
                rowIdx = medium;
                break;
            }
            else if(target<matrix[medium][0]){
                rTail = medium-1;
            }
            else{
                rHead = medium+1;
            }
        }

        if (rowIdx==-1){
            return false;
        }

        int cHead = 0;
        int cTail = rLength-1;
        while (cHead<=cTail){
            int medium = cHead+(cTail-cHead)/2;
            if (target<matrix[rowIdx][medium]){
                cTail = medium-1;
            }
            else if(target>matrix[rowIdx][medium]){
                cHead = medium+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
