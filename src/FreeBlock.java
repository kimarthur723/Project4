public class FreeBlock {
    private int level;
    private int offset;

    public FreeBlock(int level, int offset){
        this.level = level;
        this.offset = offset;
    }

    public boolean isBuddy(FreeBlock other){
        return other.offset == (this.offset & (1 << this.level));
    }
}
