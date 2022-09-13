package h12;

import java.io.*;

public class FileSystemIOFactory implements IOFactory {

    /**
     * This method creates a BufferedReader with the provided file path.
     * @param resourceName The resource to read from
     * @return returns the created BufferedReader
     * @throws IOException gets thrown when a I/O error occurs
     */
    @Override
    public BufferedReader createReader(String resourceName) throws IOException {
        return new BufferedReader(new FileReader(resourceName));
    }

    /**
     * This method creates a BufferedWriter with the provided file path.
     * @param resourceName The resource to write to
     * @return returns the created BufferedWriter
     * @throws IOException gets thrown when a I/O error occurs
     */
    @Override
    public BufferedWriter createWriter(String resourceName) throws IOException {
        return new BufferedWriter(new FileWriter(resourceName));
    }

    /**
     * This method indicates if a Reader is supported.
     * @return returns true
     */
    @Override
    public boolean supportsReader() {
        return true;
    }

    /**
     * This method indicates if a Writer is supported.
     * @return returns true
     */
    @Override
    public boolean supportsWriter() {
        return true;
    }
}
/*
 _____
/     \
vvvvvvv  /|__/|
   I   /O,O   |
   I /_____   |      /|/|
  J|/^ ^ ^ \  |    /00  |    _//|
   |^ ^ ^ ^ |W|   |/^^\ |   /oo |
   \m___m__|_|    \m_m_|   \mm_|
 */
