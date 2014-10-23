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

package com.turreta.apache.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogProgramFlowSample {
	
	private Logger logger = LogManager.getLogger(LogProgramFlowSample.class.getName());
	
	public void doItA() {
		logger.entry();
		this.doItB();
		logger.exit();
	}
	
	private void doItB() {
		logger.entry();
		this.doItC();
		logger.exit();
	}
	
	private void doItC() {
		logger.entry();
		System.out.println("DONE");
		logger.exit();
	}
	
	
	public static void main(String[] args) {
		LogProgramFlowSample sample = new LogProgramFlowSample();
		sample.doItA();
	}
}

