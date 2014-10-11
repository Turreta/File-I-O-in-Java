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

package com.turreta.apache.commons.io.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DeleteDiretory {
	public static void main(String[] args) {
		String directory = "C:/Users/user123/Downloads/commons-io-2.4-bin/commons-io-2.4";
		try {
			FileUtils.deleteDirectory(new File(directory));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
