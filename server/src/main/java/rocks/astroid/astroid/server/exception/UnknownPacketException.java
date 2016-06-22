package rocks.astroid.astroid.server.exception;

public class UnknownPacketException extends RuntimeException {
    public UnknownPacketException() { super(); }
    public UnknownPacketException(String message) { super(message); }
    public UnknownPacketException(String message, Throwable cause) { super(message, cause); }
    public UnknownPacketException(Throwable cause) { super(cause); }
}
