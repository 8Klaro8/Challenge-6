public class test {
    public static void main(String[] args) {
        String[][] myArray = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "l"},
        };

        //Horizontal
        // for (int i = 0; i < myArray.length; i++) {
        //     System.out.println("\nLine: " + (i + 1));
        //     for (int j = 0; j < myArray[i].length; j++) {
        //         System.out.println("Horizontal: " + myArray[i][j]);
        //     }
        // }

        // for (int e = 0; e < myArray.length + 1; e++) {
        //     System.out.println("\nLine: " + (e + 1));
        //     for (int d = 0; d < myArray.length; d++) {
        //         System.out.println("Vertical: " + myArray[d][e]);
        //     }
        // }

        // for (int c = 0; c < myArray.length; c++) {
        //     System.out.println("Diagonal 1: " + myArray[c][c]);

        // }

        for (int c = 0; c < myArray.length; c++) {
            System.out.println("Diagonal 1: " + myArray[c][(myArray.length - 1) - c]);

        }
    }
}
