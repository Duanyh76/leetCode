class MyHashSet {
    private int[] mySet;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        mySet = new int[1000001];
    }

    public void add(int key) {
        mySet[key] = 1;
    }

    public void remove(int key) {
        mySet[key] = 0;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return mySet[key] == 1;
    }
}