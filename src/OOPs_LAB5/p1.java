package OOPs_LAB5;
/*->insert:

    IF rear == 9
    THROW Overflow
    IF front == -1
    front = 0
    rear = rear + 1
    queue[rear] = x

   ->DELETE():
        IF front == -1 OR front > rear
        THROW Underflow
        x = queue[front]
        front = front + 1
        RETURN x

    ->display():
        IF front == -1 OR front > rear
        PRINT Empty
        FOR i = front TO rear
        PRINT queue[i]
        */

interface QueueImpl {
    void insert(int x);
    int delete();
    void display();
}

class OverflowException extends Exception {
    OverflowException(String msg) {
        super(msg);
    }
}

class UnderflowException extends Exception {
    UnderflowException(String msg) {
        super(msg);
    }
}

class QueueDemo implements QueueImpl {
    int[] queue = new int[10];
    int front = -1, rear = -1;

    public void insert(int x) {
        try {
            if (rear == 9) {
                throw new OverflowException("Overflow");
            }
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = x;
            System.out.println(x + " inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int delete() {
        try {
            if (front == -1 || front > rear) {
                throw new UnderflowException("Underflow");
            }
            return queue[front++];
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class p1 {
    public static void main(String[] args) {
        QueueDemo q = new QueueDemo();

        q.insert(10);
        q.insert(20);
        q.insert(30);

        q.display();

        System.out.println(q.delete());
        q.display();

        q.delete();
        q.delete();
        q.delete();

        for (int i = 1; i <= 11; i++) {
            q.insert(i);
        }
    }
}
