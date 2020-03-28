package engine.data;

import java.util.function.Supplier;

public enum DataType {
    OBJECT(0, DataObject::new),
    LIST(1, DataList::new),
    STRING(2, DataString::new),
    BOOLEAN(3, DataBoolean::new),
    BYTE(4, DataByte::new),
    SHORT(5, DataShort::new),
    INT(6, DataInt::new),
    LONG(7, DataLong::new),
    INT128(8, DataInt128::new),
    FLOAT(9, DataFloat::new),
    DOUBLE(10, DataDouble::new),
    BYTE_ARRAY(11, DataByteArray::new);

    private static final DataType[] idToTypes = new DataType[10];

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
