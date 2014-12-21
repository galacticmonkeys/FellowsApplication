/** A queue to store integers implemented using an array. 
  * @author Yuan Yuan

  * Method:
  *  -pointer to the first item (dequeuePointer)
  *  -pointer to the last item (enqueuePointer)
  *  -pointer in between items (array indexing)
  
  * When you enqueue, start from 0. work your way up. When queue is full, set back to 0
  * When you dequeue, start from 0. work your way up. When queue is full, set back to 0
  * In other words, have chasing pointers.

*/

public class Queue {

    /** Constructor. Takes in the size of your queue. Sets all pointers*/
    public Queue(int maxSize) {
        enqueuePointer = 0;
        dequeuePointer = 0;
        currentSize = 0;
        myQueue = new int[maxSize];
        this.maxSize = maxSize;
    }

    /** Puts new number in your queue. If queue is full, the program will
      * thrown an illegal state exception */
    public void enqueue(int newNumber) {
        if (currentSize == maxSize) {
            throw new IllegalStateException("Queue is full");
        } else {
            myQueue[enqueuePointer] = newNumber;
            enqueuePointer = enqueuePointer + 1; 
            currentSize = currentSize + 1;

            if (enqueuePointer == maxSize) {
                enqueuePointer = 0;
            }
        }
    }

    /** Removes and returns a new number in your queue. If the queue is empty,
      * the program will thrown an illegal state exception */
    public int dequeue() {
        int res = myQueue[dequeuePointer];
        if (currentSize == 0) {
            throw new IllegalStateException("Nothing in queue");
        } else {
            myQueue[dequeuePointer] = 0; 
            dequeuePointer = dequeuePointer + 1;
            currentSize = currentSize - 1;

            if (dequeuePointer == maxSize) {
                dequeuePointer = 0;
            }
        }
        return res;
    }


    /** private integers containing first pointer, last pointer, maximum size, current size.
        the queue itself is implemented using an int array */
    private int enqueuePointer, dequeuePointer, maxSize, currentSize; 
    private int[] myQueue;
}