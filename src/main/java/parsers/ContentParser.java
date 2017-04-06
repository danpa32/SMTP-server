package parsers;

import mail.Message;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 05.04.2017.
 */
public class ContentParser {
    private String[] contents = new String[5];
    private String[] subjects = new String[5];

    public ContentParser(File f) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String str= "";

        int count = 0;
        while(str != null) {
            str = br.readLine();
            if(str == null)
                break;
            subjects[count] = str.substring(str.indexOf(':') + 1);
            contents[count] = "";
            while(!str.equals("===")) {
                str = br.readLine();
                if(!str.equals("===")) {
                    contents[count] += str + "\n";
                }
            }
            System.out.println(subjects[count] + " " + contents[count]);
            ++count;
        }
    }

    public String[] getContent() {
        return contents;
    }

    public String[] getSubjects() {
        return subjects;
    }
}