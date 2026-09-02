class Solution {
    public int maxArea(int[] heights) {
        int header =0;
        int tail = heights.length-1;

        int area = 0;

        while (header<tail){
            int local = (tail-header)*Math.min(heights[header],heights[tail]);

            if (heights[header]<=heights[tail]){
                header++;
            }
            else if (heights[header]>=heights[tail]){
                tail--;
            }

            if (local>area){
                area = local;
            }
        }

        return area;
    }
}
