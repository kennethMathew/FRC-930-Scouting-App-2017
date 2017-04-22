package com.example.anew.frcscoutingapp;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;

public class FileIO extends Activity {
    static int MaxStringLength = 30; //change this to alter the maximum length of each string in the array.
     static public void writeToFile(ArrayList<String> Data, File file, int entries) throws IOException {
        //File file = getBaseContext().getFileStreamPath("Homework.dat");
        FileIO.CreateFile(file);
        RandomAccessFile raf =  new RandomAccessFile(file, "rw");
        String BufferString = " "; //set to a white space so below for loop is not true..
        byte[]BufferStringArray = new byte[MaxStringLength];
        long LastPosition = 0; //file position pointer
        while (!(BufferString.equals("#"))) {  //&& raf.length() != 0
            if (raf.getFilePointer() == raf.length()) { // deals with if eof
                LastPosition = raf.length(); //write to end of file.
                break;
            }
            LastPosition = raf.getFilePointer();
            raf.read(BufferStringArray, 0, MaxStringLength);
            BufferString = new String (BufferStringArray,"UTF-8");
            BufferString = BufferString.substring(0, 1);
            raf.skipBytes((entries -1) * MaxStringLength); // to the next record //each record is MaxStringLength bytes.
        }
        raf.seek(LastPosition); //goto position decided above
        for (int i = 0; i < entries; i++) {   //i is an array pointer
            raf.writeBytes(Data.get(i)); //write the data
        }
        raf.close();
    }

    static public ArrayList<String> PadData(ArrayList<String> StringArray, int entries){
        String Padding = "#";
        int AmountOfPadding = 0;
        for(int i = 0; i < entries; i++){
            AmountOfPadding = MaxStringLength - StringArray.get(i).length();
            for (int count = 0; count < AmountOfPadding; count++){
                StringArray.set(i, (StringArray.get(i) + Padding));
            }

        }
        return StringArray;
    }

    static ArrayList<ArrayList<String>> readFromFile(File file, int NoOfEntries) throws IOException { // searchparameter is used to find a specific line.
        FileIO.CreateFile(file);
        ArrayList<ArrayList<String>> twoDArrayList = new ArrayList<ArrayList<String>>();
        twoDArrayList.add(new ArrayList<String>(NoOfEntries));
        RandomAccessFile raf =  new RandomAccessFile(file, "r");
        String BufferString = " ";
        String CheckString = " ";
        int pointer = 0;
        long PositionPointer = 0;
        byte [] BufferArray = new byte[MaxStringLength];
        while (raf.getFilePointer() < raf.length()){ //while not end of file.
            PositionPointer = raf.getFilePointer();
            raf.read(BufferArray, 0, MaxStringLength); //read next MaxStringLength bytes no offset. 1 offset. 0 byte would be last byte of preivous data entry
            BufferString = new String (BufferArray, "UTF-8"); //needs formating
            CheckString = BufferString.substring(0, 1);  //if its an empty record then skip it.
            if (!(CheckString.equals("#"))){
                raf.seek(PositionPointer);
                for (int i = 0; i < NoOfEntries; i++){ //0 to 4
                    raf.read(BufferArray, 0, MaxStringLength);
                    BufferString = new String (BufferArray, "UTF-8");
                    BufferString = BufferString.replaceAll("#","");
                    twoDArrayList.get(pointer).add(i, BufferString);
                    //ReturnStrings[pointer][i] = BufferString;
                }
                //no need for skip record as the reading takes us to next record.
                pointer += 1;
                twoDArrayList.add(pointer, new ArrayList<String>(NoOfEntries));

            }

        }  //end while
        raf.close();
        return twoDArrayList;
    }

    static boolean DeleteEntry(File file, String SearchFor, int  Entries) throws IOException{
        FileIO.CreateFile(file);
        RandomAccessFile raf =  new RandomAccessFile(file, "rw");
        int EntryLength = MaxStringLength * Entries; //size of the entry in bytes
        long LastPosition = 0;
        String BufferString = " ";
        byte[] BufferStringArray = new byte[MaxStringLength];
        while (!(BufferString.equals(SearchFor))) {
            if (raf.getFilePointer() == raf.length()) {
                raf.close();
                return false; //just reading to eof
            }
            LastPosition = raf.getFilePointer();
            raf.read(BufferStringArray, 0, MaxStringLength);
            BufferString = new String (BufferStringArray,"UTF-8");
            BufferString = BufferString.replaceAll("#","");
            raf.skipBytes(EntryLength - MaxStringLength); // to the next record //each record is MaxStringLength bytes.
        }
        raf.seek(LastPosition);
        for (int i = 0; i < EntryLength; i++){
            raf.writeBytes("#");
        }
        raf.close();
        return true;
    }


    static void CreateFile(File file) {  //perhaps adapt to accept string so it can be used with other files.
        if (file.exists());
        else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}