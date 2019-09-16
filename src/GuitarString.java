public class GuitarString {

    public RingBuffer<Double> queue;
    private static double samplingRate = 44100.0;
    private int t;

    public GuitarString(double frequency){
        int n = (int) (samplingRate / frequency);
        queue = new RingBuffer<>(n);
        for (int i = 0; i < n; i++) {
            queue.enqueue(0.0);
        }
    }

    public GuitarString(double[] init){
        queue = new RingBuffer<>(init.length);
        for (int i = 0; i < init.length; i++) {
            queue.enqueue(init[i]);
        }
    }
    public void pluck(){
        for (int i = 0; i < queue.size(); i++) {
            queue.dequeue();
            queue.enqueue(Math.random() - .5);
        }
    }
    public void tic(){
        double x = queue.dequeue();
        queue.enqueue(.994 * ((x + queue.peek())/2));
        t++;
    }
    public double sample(){
        return queue.peek();
    }
    public int time(){return t;}
}
