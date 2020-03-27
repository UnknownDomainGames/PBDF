package engine.data;

public interface DataNumber extends DataElement {

    Number getAsNumber();

    int getAsInt();

    long getAsLong();

    float getAsFloat();

    double getAsDouble();

    byte getAsByte();

    short getAsShort();
}
