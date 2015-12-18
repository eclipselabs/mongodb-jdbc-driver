/**
 * 	Copyright 2015 Georgi Pavlov
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package io.dirigible.mongodb.jdbc.util;

import java.util.Iterator;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCursor;

public class LocalIteratorMongoCursor implements MongoCursor<String> {

	Iterator<String> iterator;
	
	LocalIteratorMongoCursor(Iterator<String> iterator){
		this.iterator = iterator;
	}
	
	@Override
	public void close() {}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}
	@Override
	public String next() {
		return iterator.next();
	}
	@Override
	public String tryNext() {
		return null;
	}
	@Override
	public ServerCursor getServerCursor() {
		return null;
	}
	@Override
	public ServerAddress getServerAddress() {
		return null;
	}

}
