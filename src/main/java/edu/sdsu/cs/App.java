package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.ArrayPriQueue;
import edu.sdsu.cs.datastructures.HeapPriQueue;
import edu.sdsu.cs.datastructures.IPriorityQueue;
import edu.sdsu.cs.datastructures.UnorderedPriQueue;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Program 1
 * CS 310
 * 3 different priority queue implementations.
 *  - Unordered ArrayList implementation
 *  - Ordered ArrayList implementation
 *  - Heap implementation
 * @author Nicholas Hernandez
 *      - Red ID: 821-853-429
 * @author Bernard Gonzales
 *      - Red ID: 818-115-968
 *
 */
public class App 
{

    private static final int INITIAL_SIZE = 50000;

    public static void main( String[] args )
    {
        IPriorityQueue<Integer> pq = new ArrayPriQueue<>();
        File outputFile = createFile();
        PrintWriter printWriter = printWriter(outputFile);

        printWriter.println("=========================================================");
        printWriter.println("================Now testing ArrayPriQueue================");
        printWriter.println("=========================================================");
        printWriter.println();

        testSuite(pq, printWriter);

        printWriter.println("==============Now testing UnorderedPriQueue==============");
        printWriter.println("=========================================================");
        printWriter.println();
        pq = new UnorderedPriQueue<>();

        testSuite(pq, printWriter);

        printWriter.println("================Now testing HeapPriQueue=================");
        printWriter.println("=========================================================");
        printWriter.println();
        pq = new HeapPriQueue<>();

        testSuite(pq, printWriter);
        printWriter.close();

        System.out.println("Done with testing! Congrats!");

    }

    private static void testSuite(IPriorityQueue pq, PrintWriter printWriter) {
        for (int i = 1; i <= 3; i++) {
            performEnqueueTests(pq, INITIAL_SIZE, "N", printWriter);
            performPollTests(pq, INITIAL_SIZE, "N", printWriter);
            pq.clear();

            performEnqueueTests(pq, INITIAL_SIZE * 2, "2N", printWriter);
            performPollTests(pq, INITIAL_SIZE * 2, "2N", printWriter);
            pq.clear();

            performEnqueueTests(pq, INITIAL_SIZE * 4, "4N", printWriter);
            performPollTests(pq, INITIAL_SIZE * 4, "4N", printWriter);
            pq.clear();

            printWriter.println("Iteration " + i + " complete.");
            printWriter.println("=========================================================");
        }
    }

    private static void performEnqueueTests(IPriorityQueue pq, int testSize, String whichTest, PrintWriter printWriter) {
        double startTime = System.nanoTime();

        for (int i = 0; i < testSize; i++)
            pq.enqueue((int)(Math.random() * 100));

        double endTimeEnqueue = System.nanoTime() - startTime;
        double seconds = endTimeEnqueue / 1000000000;

        printWriter.println("Time taken to enqueue(" + whichTest + "): " + seconds + " seconds.");
    }

    private static void performPollTests(IPriorityQueue pq, int testSize, String whichTest, PrintWriter printWriter) {
        double startTime = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            pq.poll();
        }

        double endTime = System.nanoTime() - startTime;
        double seconds = endTime / 1000000000;
        printWriter.println("Time taken to poll(" + whichTest + "): " + seconds + " seconds.");
        printWriter.println();
    }

    private static File createFile() {
        File file = new File("output.txt");

        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            System.out.println("Hm, it broke trying to create a File");
            e.printStackTrace();
        }
        return null;
    }

    private static PrintWriter printWriter(File outputFile) {
        try {
            PrintWriter printWriter = new PrintWriter(outputFile);
            return printWriter;
        }   catch (IOException e) {
            System.out.println("Hm, it broke trying to create a PrintWriter");
            e.printStackTrace();
        }

        return null;
    }




}
