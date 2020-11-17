package com.vadc.fr.dto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;

public class ListOfLines implements Iterable<String> {
    private List<String> linesList = new ArrayList<>();

    public ListOfLines(List<String> pListOfLines)
    {
        linesList = pListOfLines;
    }

    public List<String> getLinesList()
    {
        return linesList;
    }

    public void setLinesList(List<String> pListOfLines)
    {
        linesList = pListOfLines;
    }

    public void add(String pLine)
    {
        linesList.add(pLine);
    }

    public void WriteToFile (String pFileName) throws IOException
    {
        Path file = Paths.get(pFileName);
        try ( OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE)))
        {
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(output));
            for (String line : linesList)
            {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void ReadFromFile (String pFileName, Boolean pAppend) throws IOException
    {
        Path file = Paths.get(pFileName);
        try (InputStream input = new BufferedInputStream(Files.newInputStream(file)))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            if (!pAppend) linesList.clear();
            String line = reader.readLine();
            while(line != null)
            {
                linesList.add(line);
            }
        }
    }

    @Override
    public Iterator<String> iterator() {
        return linesList.iterator();
    }
}
