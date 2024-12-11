public interface InMemoryDB {
    Integer get(String key);
    void put(String key, int val) throws IllegalStateException;
    void begin_transaction();
    void commit() throws IllegalStateException;
    void rollback() throws IllegalStateException;
}
