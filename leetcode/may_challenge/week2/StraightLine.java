package leetcode.may_challenge.week2;

public class StraightLine {

    public static void main(String[] args) {
        int[][] coords = {{0,0},{0,1},{0,-1}};
        System.out.println(Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
        System.out.println(checkStraightLine(coords));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];

        double ydiff = (point2[1]-point1[1]);
        double xdiff = (point2[0]-point1[0]); 
        double initialTan;
        if(xdiff!=0.0){
            initialTan = ydiff/xdiff; 
        }else{
            initialTan = Double.POSITIVE_INFINITY;
        }
    
        for(int i=2;i<coordinates.length;i++){
            point1 = coordinates[i-1];
            point2 = coordinates[i];

            ydiff = (point2[1]-point1[1]);
            xdiff = (point2[0]-point1[0]); 

            double tanQ;

            if(xdiff!=0.0){
                tanQ = ydiff/xdiff; 
            }else{
                tanQ = Double.POSITIVE_INFINITY;
            }

            if(tanQ != initialTan){
                return false;
            }
        }
        return true;
    }
}