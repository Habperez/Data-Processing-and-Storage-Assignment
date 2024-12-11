import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InMemoryDBImpl implements InMemoryDB {
    private final Map<String, Integer> mainState = new HashMap<>();
    private Map<String, Integer> transactionState = null;
    private Stack<Map<String, Integer>> transactionStack = new Stack<>();

    @Override
    public Integer get(String key) {
        if (transactionState != null && transactionState.containsKey(key)) {
            return transactionState.get(key);
        }
        return mainState.get(key);
    }

    @Override
    public void put(String key, int val) {
        if (transactionState == null) {
            throw new IllegalStateException("No transaction in progress");
        }
        transactionState.put(key, val);
    }

    @Override
    public void begin_transaction() {
        if (transactionState != null) {
            throw new IllegalStateException("A transaction is already in progress");
        }
        transactionState = new HashMap<>();
        transactionStack.push(new HashMap<>(mainState));
    }

    @Override
    public void commit() {
        if (transactionState == null) {
            throw new IllegalStateException("No transaction in progress");
        }
        mainState.putAll(transactionState);
        transactionState = null;
    }

    @Override
    public void rollback() {
        if (transactionState == null) {
            throw new IllegalStateException("No transaction in progress");
        }
        mainState.clear();
        mainState.putAll(transactionStack.pop());
        transactionState = null;
    }
}
