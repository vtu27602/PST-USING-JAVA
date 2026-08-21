import java.util.*;

public class ConstraintDrivenDesign {

    // Represents a solution candidate
    static class Solution {
        String name;
        double cost;
        double performance;
        double reliability;
        double scalability;

        Solution(String name, double cost, double performance,
                 double reliability, double scalability) {
            this.name = name;
            this.cost = cost;
            this.performance = performance;
            this.reliability = reliability;
            this.scalability = scalability;
        }
    }

    // Hard constraints
    static class Constraints {
        double maxCost;
        double minPerformance;
        double minReliability;
        double minScalability;

        Constraints(double maxCost, double minPerformance,
                    double minReliability, double minScalability) {
            this.maxCost = maxCost;
            this.minPerformance = minPerformance;
            this.minReliability = minReliability;
            this.minScalability = minScalability;
        }
    }

    // Check whether a solution satisfies all hard constraints
    static boolean satisfiesConstraints(Solution solution,
                                        Constraints constraints) {

        return solution.cost <= constraints.maxCost
                && solution.performance >= constraints.minPerformance
                && solution.reliability >= constraints.minReliability
                && solution.scalability >= constraints.minScalability;
    }

    // Score a feasible solution using weighted soft constraints
    static double calculateScore(Solution solution) {

        double performanceWeight = 0.30;
        double reliabilityWeight = 0.30;
        double scalabilityWeight = 0.25;
        double costWeight = 0.15;

        // Lower cost is better, so invert it.
        double costScore = 100 - solution.cost;

        return solution.performance * performanceWeight
                + solution.reliability * reliabilityWeight
                + solution.scalability * scalabilityWeight
                + costScore * costWeight;
    }

    public static void main(String[] args) {

        // Define hard constraints
        Constraints constraints = new Constraints(
                50,  // Maximum cost
                70,  // Minimum performance
                80,  // Minimum reliability
                60   // Minimum scalability
        );

        // Candidate solutions
        List<Solution> solutions = Arrays.asList(
                new Solution("Solution A", 40, 80, 90, 70),
                new Solution("Solution B", 60, 95, 95, 90),
                new Solution("Solution C", 30, 75, 85, 65),
                new Solution("Solution D", 45, 85, 88, 80)
        );

        Solution bestSolution = null;
        double bestScore = Double.NEGATIVE_INFINITY;

        System.out.println("Evaluating solutions...\n");

        for (Solution solution : solutions) {

            if (!satisfiesConstraints(solution, constraints)) {
                System.out.println(solution.name + " -> REJECTED");
                continue;
            }

            double score = calculateScore(solution);

            System.out.printf(
                    "%s -> FEASIBLE, Score: %.2f%n",
                    solution.name,
                    score
            );

            if (score > bestScore) {
                bestScore = score;
                bestSolution = solution;
            }
        }

        System.out.println("\n-------------------------");

        if (bestSolution != null) {
            System.out.println("Best Solution: " + bestSolution.name);
            System.out.printf("Score: %.2f%n", bestScore);
        } else {
            System.out.println("No solution satisfies all constraints.");
        }
    }
}


OUTPUT :
Evaluating solutions...

Solution A -> FEASIBLE, Score: 77.50
Solution B -> REJECTED
Solution C -> FEASIBLE, Score: 74.75
Solution D -> FEASIBLE, Score: 80.15

-------------------------
Best Solution: Solution D
Score: 80.15
