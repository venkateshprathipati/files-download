package com.url.downloadProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.first.app.ModelData;

public class DataManager {
	  public static  ArrayList<ArrayList<ModelData>> copyURLToFile(List<String> fileNames) {
	         
	        ArrayList<ArrayList<ModelData>> myDict = new ArrayList<ArrayList<ModelData>>();
	       
	        String fileNameString="/home/file";
	        int fileNameCount=1;
	        for(int k=0;k<fileNames.size();k++){
	        try {
	        	
	        	String[] paramName=fileNames.get(k).split("/");
	            String paramName1 = paramName[0] = paramName[0].replace("Tmin", "Min Temp")
	            												.replace("Tmax", "Max Temp")
	            												.replace("Tmean", "Mean Temp");
	           
	            fileNameString=fileNameString+fileNameCount+"";
	            File file = new File(fileNameString);
	           
	            fileNameCount = Integer.valueOf(fileNameCount);
	            fileNameCount++;
	            fileNameString = "/home/file";
	            String sUrl = "https://www.metoffice.gov.uk/pub/data/weather/uk/climate/datasets/";
	            sUrl=sUrl+fileNames.get(k);
	            URL url = new URL(sUrl);
	            InputStream input = url.openStream();
	       
	            String country = FilenameUtils.getBaseName(url.getPath());
	           
	            if (file.exists()) {
	                if (file.isDirectory())
	                    throw new IOException("File '" + file + "' is a directory");
	              
	                if (!file.canWrite())
	                    throw new IOException("File '" + file + "' cannot be written");
	            } else {
	                File parent = file.getParentFile();
	                if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
	                    throw new IOException("File '" + file + "' could not be created");
	                }
	            }
	           
	            FileOutputStream output = new FileOutputStream(file);

	            byte[] buffer = new byte[4096];
	            int n = 0;
	            while (-1 != (n = input.read(buffer))) {
	                output.write(buffer, 0, n);
	            }
	            output.close();
	           
	            int count = 0;
	            ArrayList<ModelData> modelvenky = new ArrayList<ModelData>();
	            BufferedReader r = new BufferedReader(new FileReader(file));
	            String line;
	            String[] s;
	            while ((line=r.readLine()) != null) {
	                count++;
	                ModelData mv=new ModelData();
	                if(count>8){
	                    line.replace(" ", "");
	                   s=line.split(" +");
	                   for(int i=0;i<s.length;i++){
	                   switch(i){
	                   case 0 : mv.setYear(s[i]);mv.setCountry(country);mv.setWeatherParam(paramName1);break;
	                   case 1 : mv.setJan(s[i]);break;
	                   case 2 : mv.setFeb(s[i]);break;
	                   case 3 : mv.setMar(s[i]);break;
	                   case 4 : mv.setApr(s[i]);break;
	                   case 5 : mv.setMay(s[i]);break;
	                   case 6 : mv.setJune(s[i]);break;
	                   case 7 : mv.setJuly(s[i]);break;
	                   case 8 : mv.setAug(s[i]);break;
	                   case 9 : mv.setSep(s[i]);break;
	                   case 10 : mv.setOct(s[i]);break;
	                   case 11 : mv.setNov(s[i]);break;
	                   case 12 : mv.setDec(s[i]);break;
	                   case 13 : mv.setWin(s[i]);break;
	                   case 14 : mv.setSpr(s[i]);break;
	                   case 15 : mv.setSum(s[i]);break;
	                   case 16 : mv.setAut(s[i]);break;
	                   case 17 : mv.setAnn(s[i]);break;
	                   
	                   }
	                   }
	                   modelvenky.add(mv);
	                }
	            }   r.close();
	            myDict.add(modelvenky);
	          
	            System.out.println("File ' " + file + "' downloaded successfully!");
	           
	        }
	        catch(IOException ioEx) {
	            ioEx.printStackTrace();
	        }
	    }
	        return  myDict;
	    }
}
