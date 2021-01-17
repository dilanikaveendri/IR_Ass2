import java.io.*;

public class XMLFileCreator {
    public static void main(String[] args){
        BufferedReader reader;
        int counter = 0;
        //create output file
        createFile();

        //read from .txt file and write to .xml
        try {
            reader = new BufferedReader(new FileReader("file3.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();

                //write to xml file
                FileWriter myWriter = null;
                BufferedWriter bw = null;
                PrintWriter pw = null;

                try {
                    myWriter = new FileWriter("xmlfile.xml", true);
                    bw = new BufferedWriter(myWriter);
                    pw = new PrintWriter(bw);
                    pw.println("<DOC> <DOCNO> " + counter +" </DOCNO> " +line +" </DOC>");
                    pw.flush();
                    counter++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(){
        try {
            File myObj = new File("xmlfile.xml");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}