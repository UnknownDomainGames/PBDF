package engine.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

abstract class BaseDataTest {

    @Test
    public void test() throws IOException {
        DataElement element = create();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        DataUtils.write(element, new DataOutputStream(output));
        DataElement read = DataUtils.read(new DataInputStream(new ByteArrayInputStream(output.toByteArray())));
        Assertions.assertEquals(element, read);
    }

    protected abstract DataElement create();
}
