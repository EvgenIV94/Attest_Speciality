package Attest_Speciality;

public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        // Если объект не был использован в блоке try-with-resources
        if (count == 0) {
            throw new IllegalStateException("Счетчик не был использован.");
        }
    }
    
}

