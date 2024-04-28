import student.TestCase;
public class HashMapTest extends TestCase{

    private HashMap map;

    public void setUp(){
        map = new HashMap(2);
    }

    public void testInsert(){
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());
        map.insert(5, new Seminar());

        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);
        map.remove(5);

        System.out.println();
    }
}
