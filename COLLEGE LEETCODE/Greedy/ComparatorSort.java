import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements  Comparable<Student>{
    int age;
    String name;

    public Student (int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student that) {
        if (this.age > that.age) return 1;
        return -1;
    }
}

class ComparatorSort {
    public static void main(String[] args) {
        Comparator<Integer> com = (Integer a, Integer b) -> {
            if (a % 10 > b % 10) return 1;
            else return -1;
        };

        // Comparator<Integer> com = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         if (a % 10 > b % 10) return 1;
        //         else return -1;
        //     }
        // };

        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(72);
        list.add(41);
        list.add(95);

        // Collections.sort(list, (a, b) -> a % 10 - b % 10);
        Collections.sort(list, com);
        System.out.println(list);

        List<String> strs = new ArrayList<>();
        strs.add("Faizan");
        strs.add("Khan");
        strs.add("Coder");
        strs.add("Programmer");

        Collections.sort(strs, (a, b) -> a.length() - b.length());
        System.out.println(strs);

        List<Student> students = new ArrayList<>();
        students.add(new Student(21, "John"));
        students.add(new Student(18, "Jack"));
        students.add(new Student(24, "Jade"));
        students.add(new Student(17, "Jim"));

        Collections.sort(students);

        for (Student s : students) {
            System.out.println("| Age: " + s.age + " || Name: " + s.name + " |");
        }
    }
}
