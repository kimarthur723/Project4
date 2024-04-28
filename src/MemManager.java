import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemManager {
    private byte[] pool;
    private ArrayList<LinkedList<FreeBlock>> freeList;
    private HashMap freeBlocks;
    private static final int DEFAULT_POOL_SIZE = 16;

    private static final int MINIMUM_BLOCK_SIZE = 2;


    public MemManager() {
        this(DEFAULT_POOL_SIZE);
    }


    public MemManager(int poolSize) {
        if (!Base2Math.isPowerOfTwo(poolSize)) {
            poolSize = DEFAULT_POOL_SIZE;
        }

        pool = new byte[poolSize];

        int level = Base2Math.log2(poolSize);
        freeList = new ArrayList<>(level);
        for(int i = 0; i < level; i++){
            freeList.add(new LinkedList<>());
        }
        freeList.get(level).add(new FreeBlock(level, 0));

        freeBlocks = new HashMap(poolSize * 2);
    }


    private FreeBlock findBlock(int size) {
        int level = Base2Math.log2(size);
        for (int i = level; i >= 0; i--) {
            if(freeList.get(i).size() > 0){
                return freeList.get(i).removeFirst();
            }
        }
        return null;
    }

    public Handle insert(byte[] space, int size) {
        int level = Base2Math.log2(size);
        if(level > freeList.size() || freeList.get(level).isEmpty()){
            expand();
        }

        return null;
    }


    private void splitBlock(int index) {

    }


    private void expand() {
        byte[] oldPool = pool;
        pool = new byte[pool.length * 2];
        System.arraycopy(oldPool, 0, pool, 0, oldPool.length);
        for (int i = 0; i < oldPool.length; i++) {
            freeList.add(new LinkedList<>());
        }
    }




}
