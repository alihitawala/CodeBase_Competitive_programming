package Coding.HEarth.IterativeDeeping;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by aliHitawala on 10/12/15.
 */
public class Runner {
    public static void main(String... arg)
    {
        int number_of_nodes, destination;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();

            int adjacency_matrix[][] = new int[number_of_nodes][number_of_nodes];
            System.out.println("Enter the adjacency matrix");
            for (int i = 0; i < number_of_nodes; i++)
                for (int j = 0; j < number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();

            System.out.println("Enter the destination for the graph");
            destination = scanner.nextInt();

            IterativeDeeping iterativeDeepening = new IterativeDeeping(adjacency_matrix, 0, destination);
            System.out.println(iterativeDeepening.search());
        }catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
    }
}
