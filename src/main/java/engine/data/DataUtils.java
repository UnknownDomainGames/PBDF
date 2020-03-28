package engine.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class DataUtils {

    public static void write(DataElement element, DataOutput output) throws IOException {
        output.writeByte(element.getType().getId());
        element.write(output);
    }

    public static DataElement read(DataInput input) throws IOException {
        DataElement element = DataType.valueOf(input.readByte()).create();
        element.read(input);
        return element;
    }

    private DataUtils() {
    }
}
