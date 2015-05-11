package memory;

import java.util.HashMap;
import java.util.Map;

public class MainMemory {

	private int totalBytes;
	private Byte[] bytes;
	private int usedBytes;

	public MainMemory(int totalBytes) {

		this.totalBytes = totalBytes;
		bytes = new Byte[totalBytes];

		for (int i = 0; i < totalBytes; i++) {
			bytes[i] = new Byte(i);
		}

	}

	public boolean allocate(int processID, int numBytes)
			throws OutOfMemoryException {

		if (isFull()) {
			throw new OutOfMemoryException();
		}

		else {

			int bytesFree = 0;
			int[] listOfBytes = new int[numBytes];
			int counter = 0;

			for (int i = 0; i < totalBytes; i++) {

				if (bytes[i].isFree() && bytesFree < numBytes) {

					bytesFree++;
					listOfBytes[counter++] = i;

				}

				else if (!bytes[i].isFree()) {
					bytesFree = 0;
					listOfBytes = new int[numBytes];
					counter = 0;

				}

				if (bytesFree == numBytes) {
					break;
				}
			}

			if (bytesFree == numBytes) {
				for (int i = listOfBytes[0]; i < numBytes + listOfBytes[0]; i++) {
					bytes[i].use();
					bytes[i].setProcessID(processID);
				}

				return true;
			}

			return false;

		}

	}

	public boolean isFull() {
		if (usedBytes == totalBytes) {
			return true;
		} else {
			return false;
		}
	}

	public void free(int processID) {

		for (Byte x : bytes) {
			if (x.getProcessID() == processID) {
				x.setFree();
			}
		}

	}

	public String print() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < totalBytes; i++) {
			builder.append(i);
			builder.append("\t");
			if (bytes[i].isFree()) {
				builder.append("FREE");
			} else {
				builder.append(bytes[i].getProcessID());
			}
			builder.append("\n");

		}
		return builder.toString();
	}
}
