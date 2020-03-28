package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class DataString implements DataElement {
    private String value;

    public DataString() {
    }

    public DataString(String value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.STRING;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getAsString() {
        return value;
    }

    @Override
    public UUID getAsUUID() {
        return UUID.fromString(value);
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeUTF(value);
    }

    @Override
    public void read(DataInput input) throws IOException {
        value = input.readUTF();
    }

    @Override
    public DataElement deepClone() {
        return new DataString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataString that = (DataString) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
}
