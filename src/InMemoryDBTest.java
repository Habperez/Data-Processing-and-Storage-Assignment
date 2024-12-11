public class InMemoryDBTest {
    public static void main(String[] args) {
        InMemoryDB db = new InMemoryDBImpl();

        // Test get on empty DB
        System.out.println(db.get("A")); // Should print null

        // Test put without transaction
        try {
            db.put("A", 5);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()); // Should print "No transaction in progress"
        }

        // Test transaction workflow
        db.begin_transaction();
        db.put("A", 5);
        System.out.println(db.get("A")); // Should print null
        db.commit();
        System.out.println(db.get("A")); // Should print 5

        // Test rollback
        db.begin_transaction();
        db.put("B", 10);
        System.out.println(db.get("B")); // Should print null
        db.rollback();
        System.out.println(db.get("B")); // Should print null
    }
}
