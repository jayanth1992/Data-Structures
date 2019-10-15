package dataStructures;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.push(1);
        priorityQueue.push(10);
        priorityQueue.push(5);
        priorityQueue.push(16);
        priorityQueue.push(20);
        priorityQueue.push(3);
        priorityQueue.push(15);

        System.out.println(priorityQueue.max());

        System.out.println(priorityQueue.extractMax());

        System.out.println(priorityQueue.max());

        System.out.println(priorityQueue.extractMax());


    }
}
