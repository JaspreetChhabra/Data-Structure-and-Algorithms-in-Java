package Array.Easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Geeks https://www.geeksforgeeks.org/find-unique-elements-matrix/

//  Given a matrix mat[][] having n rows and m columns. We need to find unique elements in matrix i.e, those elements which are not repeated in the matrix or those elements whose frequency is 1.
//
//  Examples:
//
//  Input :  20  15  30  2
//  2   3   5   30
//  6   7   6   8
//  Output : 3  20  5  7  8  15
//
//  Input :  1  2  3
//  5  6  2
//  1  3  5
//  6  2  2
//  Output : No unique element in the matrix

class UniqueElementMatrix {

    static void uniqueElement(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println("Rows: " +  row + " Column: " + column);

        for (int i =0; i < row; i++) {
            for (int j=0; j < column; j++){
                if (map.containsKey(matrix[i][j]))
                    map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
                else
                    map.put(matrix[i][j], 1);

            }
        }

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)iterator.next();
            int key = (int) mapElement.getKey();
            int value = (int) mapElement.getValue();

            if(value == 1)
                System.out.print(key + " ");
        }

    }

    public static void Order(Object o)
    {
        System.out.println("Object");
    }

    public static void Order(String s)
    {
        System.out.println("String");
    }

    public static void main(String args[]){

        int[][] matrix = {{1, 2, 3},
                {4, 5, 2}
        };

        uniqueElement(matrix);

//        int A1[] = {1, 2, 3};
//        int A2[] = {1, 2, 3};
//        if (A1.equals(A2))
//            System.out.println("Same");
//        else
//            System.out.println("Not same");
    }


}
