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
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UTF8FileWriter {

	public void write(File file, String text) throws IOException{
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(file), "UTF8"));
			out.append(text);
		 }
		 finally {
				out.flush();
				out.close();
		 }	    
	}
	
	public static void main(String... args) {
		String stringToWrite = "すべての人間の知恵は、これらの2つの単語に含まれている - 待って、ホープ";
		File file = new File("the_count_of_monte_cristo.txt");
		UTF8FileWriter utf8Writer = new UTF8FileWriter();
		
		try {
			utf8Writer.write(file, stringToWrite);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
