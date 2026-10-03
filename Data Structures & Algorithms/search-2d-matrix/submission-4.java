class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int finalColumnIndex = matrix[0].length - 1;
        int finalRowIndex = matrix.length - 1;

        int top = 0;
        int bottom = finalRowIndex;

        int selection = 0; //0,1,2
        int correctRow = 0;
        // System.out.println(top);
        // System.out.println(bottom);

        //Binary Search 1
        while (top <= bottom) {

            System.out.println("Selection: " + selection);
            System.out.println("Bottom: " + bottom);
            System.out.println("Top: " + top);

            System.out.println(" ");

            //Skip this check when selection == 0
            if (selection == 1) {
                if (top == finalRowIndex) {
                    correctRow = top;
                    break;
                }
                if (matrix[top][finalColumnIndex] > target) {
                    correctRow = top;
                    break;
                }
            } else if (selection == 2) {
                if (matrix[bottom][finalColumnIndex] < target) {
                    correctRow = bottom + 1;
                    break;
                }
            }

            int mid = (top + bottom)/2;

            if (matrix[mid][finalColumnIndex] == target) { //Just return true if we find the target
                correctRow = mid;
                return true;
            }

            //potential = false -> top = top + 1
            if (matrix[mid][finalColumnIndex] < target) {
                selection = 1;
                top = mid + 1;
            }

            //potential = true -> bottom = bottom - 1
            if (matrix[mid][finalColumnIndex] > target) {
                selection = 2;
                bottom = mid - 1;
            }

        }

        System.out.println("Correct Row: " + correctRow);

        //Binary Search 2
        int left = 0;
        int right = finalColumnIndex;

        while (left <= right) {
            
            int mid = (left + right)/2;

            if (matrix[correctRow][mid] == target) {
                return true;
            } else if (matrix[correctRow][mid] < target) {
                left = mid + 1;
            } else if (matrix[correctRow][mid] > target) {
                right = mid - 1;
            }
        }
        return false;
        
        
    }
}
