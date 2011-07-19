package basicparser.programflow;

import basicparser.Node;

import javax.sound.midi.Sequence;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.Throwable;

public class UnknownChildException extends RuntimeException {
	public UnknownChildException() {
		super();
	}

	public UnknownChildException(Node child) {
		super(child.toString());
	}

	public UnknownChildException(String message) {
		super(message);
	}

	public UnknownChildException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownChildException(Throwable cause) {
		super(cause);
	}
}