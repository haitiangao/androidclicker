package com.bb.clickaway;

import android.content.Context;
import android.util.Log;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileFunctions {
    private Context ctx;

    public FileFunctions(Context ctx){
        this.ctx = ctx;
    }

    public String loadDoc(){
        String content = null;
        StringBuilder builder = new StringBuilder();
        int ch;
        try{
            FileInputStream fis = ctx.openFileInput("save.sav");
            while((ch=fis.read())!=-1)
            {
                builder.append((char)ch);
            }
            content = builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (content.equals(""))
            return "0";
        else
            return content;
    }

    public void saveDoc(){
        try{
            FileOutputStream fos = ctx.openFileOutput("save.sav",0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}

