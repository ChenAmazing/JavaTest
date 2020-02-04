package SimpleTestDemo;

import java.util.PriorityQueue;

public class UsePriorityQueue {
    public static PriorityQueue<Student> queue = new PriorityQueue<>();
    public static void main(String[] args) {
        queue.offer(new Student("xxx",8));
        queue.offer(new Student("mmm",22));
        queue.offer(new Student("nnn",12));
        System.out.println(queue.poll().age);
        System.out.println(queue.poll().age);
        System.out.println(queue.poll().age);
    }
}
