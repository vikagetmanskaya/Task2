package by.javacourse.task2.exception;

public class FlowerException extends Exception {
    public FlowerException() {
    }

    public FlowerException(String message) {
        super(message);
    }

    public FlowerException(String message, Exception e) {
        super(message, e);
    }

    public FlowerException(Exception e) {
        super(e);
    }
}
