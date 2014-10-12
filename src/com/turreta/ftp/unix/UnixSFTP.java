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

package com.turreta.ftp.unix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import com.turreta.thread.StreamGobbler;

public class UnixSFTP {
	
	private static boolean doSFTP(String localFile, String ftpHost, String ftpUserId, String ftpDestPath) {
		
		// Build the command
		StringBuilder ftpCommand = new StringBuilder("sftp -b").append(" ");
		ftpCommand.append(ftpUserId).append("@").append(ftpHost).append(":");
		
		String destPath = ftpDestPath;
		if (destPath != null && !destPath.trim().equalsIgnoreCase("")) {			
			if (destPath.equals(".") || destPath.equals("./")) {
				destPath = "/.";
			} else if(!destPath.endsWith("/")) {
				destPath = destPath + "/";
			}
		} else {
			return false;
		}
		
		// add the destination path to the command
		ftpCommand.append(destPath);
		
		boolean successful = false;
		UUID idOne = UUID.randomUUID();
		
		String uuidfileName = idOne.toString();
		File f = new File(uuidfileName);
		if (f.exists()) {
			f.delete();
		}
		
		try {
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.write("put " + localFile);
			fw.close();
		} catch (IOException e1) {
			return successful;
		}
		
		try {
			Process p = Runtime.getRuntime().exec(ftpCommand.toString());				
			com.turreta.thread.StreamGobbler errorGobbler  = new StreamGobbler(p.getErrorStream(), "ERROR", null);	
			StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "OUTPUT", null);
			errorGobbler.start();
            outputGobbler.start();
			
			int exitVal = p.waitFor();
			if(exitVal == 0) {
				successful = true;
			}
		} catch (Exception e) {
			successful = false;
		}
		return successful;
	}
	
	public static void main(String[] args) {
		
		// Sample usage
		UnixSFTP.doSFTP("/home/user123/testfile001.txt", "remote-ftp-host", "remoteuser01", "/");
	}
}
