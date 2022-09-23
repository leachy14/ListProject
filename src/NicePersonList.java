import java.util.*;
/**
 * A class that represents a list of people on Santa's Nice List.
 * Santa will bring a number of presents to each child on the list
 * The list contains the child's name and the list of presents.
 * @Author Christopher Leach
 * @Version 0.1
 */
public class NicePersonList<T> {
    private T[] list;
    private int numberOfEntries;
    private boolean IntegrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public NicePersonList() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public NicePersonList(int initialCapacity) {
        IntegrityOK = false;

        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity];
        list = tempList;
        numberOfEntries = 0;
        IntegrityOK = true;
    } //end constructor

    public void add(T newEntry) {
        checkIntegrity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
        ensureCapacity();
    } // end add

    public void add(int newPosition, T newEntry) {
        checkIntegrity();
        if ((newPosition >= 0) && (newPosition <= numberOfEntries)) {
            if (newPosition < numberOfEntries)
                makeRoom(newPosition);
            list[newPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        } else
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
    } //end add
    public T remove(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            assert !isEmpty();
            T result = list[givenPosition];
            if (givenPosition < numberOfEntries - 1)
                removeGap(givenPosition);
            numberOfEntries--;
            return result;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    } //end remove

    public void clear() {
        checkIntegrity();
        for (int index = 0; index < numberOfEntries; index++)
            list[index] = null;
        numberOfEntries = 0;
    } //end clear

    public T replace(int givenPosition, T newEntry) {
        checkIntegrity();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            T origianlEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return origianlEntry;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    } // end replace

    public T getEntry(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            assert !isEmpty();
            return list[givenPosition];
        } else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry

    public T[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index];
        } // end for
        return result;
    } // end toArray

    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(list[index]))
                found = true;
        } // end for
        return found;
    } // end contains

    public int getLength() {
        return numberOfEntries;
    } // end getLength

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private void ensureCapacity() {
        int capacity = list.length;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity);
        } // end if
    } // end ensureCapacity

    private void makeRoom(int givenPosition) {
        int capacity = list.length - 1; //not sure if -1 is needed in this case since I didn't start the array at 1
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity);
        } // end if
    } // end makeRoom

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        for (int index = removedIndex; index < numberOfEntries; index++)
            list[index] = list[index + 1];
    } // end removeGap

    private void checkIntegrity() {
        if (!IntegrityOK)
            throw new SecurityException("NicePersonList object is corrupt.");
    } // end checkIntegrity

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a list whose capacity exceeds allowed maximum.");
    } // end checkCapacity

} //end nice person list
