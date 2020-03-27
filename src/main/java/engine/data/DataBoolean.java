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
    public boolean getAsBoolean() {
        return value;
    }
}
