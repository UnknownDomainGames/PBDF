package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataEnd implements DataElement {
    public static final DataEnd END = new DataEnd();

    private DataEnd() {
    }

    @Override
    public DataType getType() {
        return DataType.END;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        // DO NOT DO ANYTHING
    }

    @Override
    public void read(DataInput input) throws IOException {
        // DO NOT DO ANYTHING
    }

    @Override
    public DataElement deepClone() {
        return END;
    }
}
