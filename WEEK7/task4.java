import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class Solution {

    static String count(ArrayList mylist) {
        int student = 0;
        int rockstar = 0;
        int hacker = 0;

        for (Object obj : mylist) {

            if (obj instanceof Student) {
                student++;
            }

            if (obj instanceof Rockstar) {
                rockstar++;
            }

            if (obj instanceof Hacker) {
                hacker++;
            }
        }

        return student + " " + rockstar + " " + hacker;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList mylist = new ArrayList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            if (type.equals("Student")) {
                mylist.add(new Student());
            } 
            else if (type.equals("Rockstar")) {
                mylist.add(new Rockstar());
            } 
            else if (type.equals("Hacker")) {
                mylist.add(new Hacker());
            }
        }

        System.out.println(count(mylist));
    }
}
5
Student
Student
Rockstar
Student
Hacker
