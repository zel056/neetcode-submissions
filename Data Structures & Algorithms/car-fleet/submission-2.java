class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int [position.length][2];
        Stack<Double> stack = new Stack<>();

        for(int i=0; i<position.length;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }

        Arrays.sort(cars,(a, b) -> Integer.compare(b[0],a[0]));

        for (int i=0; i<position.length;i++){
            int currPos = cars[i][0];
            int currSpd = cars[i][1];

            int diff = target-currPos;
            double time = (double)diff/currSpd;

            if (!stack.isEmpty()&&time<=stack.peek()){
                continue;
            }
            stack.push(time);
        }

        return stack.size();
    }
}
