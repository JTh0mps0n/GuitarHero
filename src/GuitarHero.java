
public class GuitarHero {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C

        GuitarString[] notes = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        char[] keys = new char[37];
        for (int i = 0; i < 37; i++) {
            notes[i] = new GuitarString(440 * Math.pow(1.05956, (i - 23)));
            keys[i] = keyboard.charAt(i);
        }

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                for (int i = 0; i < 37; i++) {
                    if(key == keys[i]){
                        notes[i].pluck();
                    }
                }
            }

            // compute the superposition of the samples
            double sample = 0;
            for (int i = 0; i < 37; i++) {
                sample += notes[i].sample();
            }
            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < 37; i++) {
                notes[i].tic();
            }
        }
    }

}
