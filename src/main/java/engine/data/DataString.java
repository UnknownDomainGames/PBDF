package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

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
    public String getAsString() {
        return value;
    }
}
