class MinStack {

    private ArrayList<Integer> backingArray;
    private ArrayList<Integer> minTracker;
    private int min;

    public MinStack() {
        backingArray = new ArrayList<>();
        minTracker = new ArrayList<>();
    }
    
    public void push(int val) {
        if (minTracker.size() == 0) {
            minTracker.addFirst(val);
        } else {
            if (val < minTracker.getFirst()) {
                minTracker.addFirst(val);
            } else {
                minTracker.addFirst(minTracker.getFirst());
            }
        }
        backingArray.addFirst(val);
    }
    
    public void pop() {
        backingArray.removeFirst();
        minTracker.removeFirst();
    }
    
    public int top() {
        return backingArray.getFirst();
    }
    
    public int getMin() {
        return minTracker.getFirst(); //Current height's min
    }
}
