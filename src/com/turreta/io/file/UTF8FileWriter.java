package com.turreta.io.file;

import java.io.BufferedReader;
import java.io.File;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class UTF8FileWriter {

	public static String write(File file){
		 
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
	                      new FileInputStream(new File("C:/Users/ksangabr/workspace/turreta - algorithms/bin/jp_data20140101040311.dat")), "UTF8"));
	 
			String str;
	 
			while ((str = in.readLine()) != null) {
			    System.out.println(str);
			}
	 
	                in.close();
		    } 
		    catch (UnsupportedEncodingException e) 
		    {
				System.out.println(e.getMessage());
		    } 
		    catch (IOException e) 
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
		return "";
	}
}
