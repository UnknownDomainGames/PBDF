package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataBoolean implements DataElement {
    private boolean value;

    public DataBoolean() {
    }

    public DataBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.BOOLEAN;
    }

    @Override
    public boolean isBoolean() {
        return true;
    }

    @Override
    public boolean getAsBoolean() {
        return value;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeBoolean(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readBoolean();
    }

    @Override
    public DataElement deepClone() {
        return new DataBoolean(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBoolean that = (DataBoolean) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
