package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class DataByteArray implements DataElement, Iterable<Byte> {
    private byte[] bytes;

    public DataByteArray() {
    }

    public DataByteArray(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte get(int index) {
        return bytes[index];
    }

    public int length() {
        return bytes.length;
    }

    public byte[] array() {
        return bytes;
    }

    @Override
    public DataByteArray getAsDataByteArray() {
        return this;
    }

    @Override
    public Iterator<Byte> iterator() {
        return new Iterator<Byte>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < length();
            }

            @Override
            public Byte next() {
                return get(i);
            }
        };
    }

    @Override
    public DataType getType() {
        return DataType.BYTE_ARRAY;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeInt(bytes.length);
        output.write(bytes);
    }

    @Override
    public void read(DataInput input) throws IOException {
        bytes = new byte[input.readInt()];
        input.readFully(bytes);
    }

    @Override
    public DataElement deepClone() {
        return new DataByteArray(Arrays.copyOf(bytes, bytes.length));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataByteArray that = (DataByteArray) o;
        return Arrays.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (byte b : bytes) {
            builder.append(b).append(", ");
        }
        if (length() != 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.append("]").toString();
    }
}
