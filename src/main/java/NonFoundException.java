public class NonFoundException extends RuntimeException {

    public NonFoundException(int id) {
        super("Element with ID:" + id + "not found");
    }

}
