# PBDF
A binary data format for pangu engine

## Usage
Create data object:
```java
DataObject object = new DataObject();
object.put("x", 493.7);
object.put("y", 64.0);
object.put("z", -480.5);
object.put("health", 20.0f);
object.put("name", "Mouse0w0");
object.put("id", 1498);
object.put("uuid", UUID.fromString("17df5f16-10ce-4261-957c-ca257a3aaaea"));
object.put("spawnTimeStamp", System.currentTimeMillis());
object.put("bytes", new byte[4096]);
object.put("items", new DataList(new DataInt(100)));
```

Read and write binary data:
```java
DataUtils.write(element, dataOutput);
DataElement element = DataUtils.read(dataInput);
```