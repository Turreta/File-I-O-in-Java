/*
 * Copyright (C) 2014 www.turreta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.turreta.io.file;
import java.io.File;

public class MyFileUtil {
	
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		
		/* Check if we are deleting a file and not a directory 
		 * which can be non-empty.
		 */		
		if(file.isFile()) {
			return file.delete();
		} else {
			// Log reason
			return false; 
		}
	}
	
	public static void main(String[] args) {
		// File C:/Users/user123/Desktop/delete_me.txt needs to be existing
		boolean t = MyFileUtil.deleteFile("C:/Users/user123/Desktop/delete_me.txt");
		System.out.println(t ? "File deleted" : "File not deleted");
	}
}