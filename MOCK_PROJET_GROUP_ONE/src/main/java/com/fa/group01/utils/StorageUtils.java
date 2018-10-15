/**
 * 
 */
package com.fa.group01.utils;

import java.io.File;

/**
 * @author nguyenthanhlinh
 *
 */
public class StorageUtils {
	
	public static final String FEATURE_LOCATION = "C:/upload";
	
	
	public static String getFileExtension(String fileName){
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(dotIndex);
    }

    public static void removeFile(String fileName){
        File file = new File(FEATURE_LOCATION + "/" + fileName);
        if (file.exists()){
            file.delete();
        }
    }

}