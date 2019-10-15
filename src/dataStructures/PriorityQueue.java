package dataStructures;

public class PriorityQueue {

    private int size;
    private int[] arr;

    public PriorityQueue(int capacity) {
        this.size = 0;
        this.arr = new int[capacity+1];
    }

    public void push(int num) {
        if (this.size == 0) {
            this.arr[1] = num;
        } else {
            this.arr[this.size+1] = num;
            shiftUp(arr, this.size+1);
        }

        this.size++;
    }

    public int max() {
        return this.arr[1];
    }

    public int extractMax() {

        int largest = this.arr[1];

        this.arr[1] = this.arr[this.size];
        shiftDown(this.arr, 1);
        this.size--;
        return largest;
    }

    private void shiftUp(int[] arr, int i) {

        if (i == 1) {
            return;
        }

        if (arr[i/2] < arr[i]) {
            swap(arr, i/2, i);
            shiftUp(arr, i/2);
        }

    }

    private void shiftDown(int[] arr, int i) {

        int left = 2*i;
        int right = 2*i + 1;

        int largest = -1;

        if (left <= this.size && this.arr[left] >this.arr[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= this.size && this.arr[right] > this.arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            shiftDown(arr, largest);
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
