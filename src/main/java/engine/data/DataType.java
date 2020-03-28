package engine.data;

import java.util.function.Supplier;

public enum DataType {
    END(0, () -> DataEnd.END),
    OBJECT(1, DataObject::new),
    LIST(2, DataList::new),
    STRING(3, DataString::new),
    BOOLEAN(4, DataBoolean::new),
    BYTE(5, DataByte::new),
    SHORT(6, DataShort::new),
    INT(7, DataInt::new),
    LONG(8, DataLong::new),
    INT128(9, DataInt128::new),
    FLOAT(10, DataFloat::new),
    DOUBLE(11, DataDouble::new),
    BYTE_ARRAY(12, DataByteArray::new);

    private static final DataType[] idToTypes = new DataType[13];

    private final byte id;
    private final Supplier<DataElement> factory;

    static {
        for (DataType value : DataType.values()) {
            idToTypes[value.id] = value;
        }
    }

    public static DataType valueOf(int id) {
        return idToTypes[id];
    }

    DataType(int id, Supplier<DataElement> factory) {
        this.id = (byte) id;
        this.factory = factory;
    }

    public byte getId() {
        return id;
    }

    public DataElement create() {
        return factory.get();
    }
}
