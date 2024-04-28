public class HashMap {
    private class Record {
        int key;
        Seminar value;


        public Record(int key, Seminar value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 16;
    private int size;
    private Record[] records;

    public HashMap (){
        this(DEFAULT_TABLE_SIZE);
    }

    public HashMap(int tableSize) {
        size = 0;
        if(!Base2Math.isPowerOfTwo(tableSize)){
            tableSize = DEFAULT_TABLE_SIZE;
        }
        records = new Record[tableSize];
    }

    private void insert(Record record) {
        int hash = firstHash(record.key);
        int step = secondHash(record.key);
        while (records[hash] != null && records[hash].key > 0) {
            hash += step;
            hash %= records.length;
        }
        records[hash] = record;
        size++;

        if(size > records.length / 2){
            rehash();
        }
    }

    public void insert(int key, Seminar value) {
        insert(new Record(key, value));
    }

    public void remove(int key){
        int hash = firstHash(key);
        int step = secondHash(key);
        while (records[hash] != null) {
            if(records[hash].key == key){
                records[hash].key = -1;
                size--;
                return;
            }
            hash += step;
            hash %= records.length;
        }
    }

    public Seminar search(int key){
        int hash = firstHash(key);
        int step = secondHash(key);
        while (records[hash] != null) {
            if(records[hash].key == key){
                return records[hash].value;
            }
            hash += step;
            hash %= records.length;
        }
        return null;
    }

    private int firstHash(int key) {
        return key % records.length;
    }


    private int secondHash(int key) {
        return (((key / records.length) % (records.length / 2)) * 2) + 1;
    }

    private void rehash() {
        Record[] oldRecords = records;
        records = new Record[records.length * 2];
        size = 0;
        for (Record oldRecord : oldRecords) {
            if (oldRecord != null && oldRecord.key > 0) {
                insert(oldRecord);
            }
        }
    }
}
