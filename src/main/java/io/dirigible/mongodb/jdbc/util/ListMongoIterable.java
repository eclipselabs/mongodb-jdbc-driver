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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.mongodb.Block;
import com.mongodb.Function;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;

public class ListMongoIterable implements MongoIterable<String> {

	List<String> entries;

	public ListMongoIterable(List<String> backingList){
		this.entries = backingList;
	}
	
	@Override
	public <U> MongoIterable<U> map(Function<String, U> mapper) {
		return null;
	}
	
	@Override
	public MongoCursor<String> iterator() {
		return new LocalIteratorMongoCursor(entries.iterator());
	}				
	@Override
	public <A extends Collection<? super String>> A into(A target) {
		return null;
	}
	@Override
	public void forEach(Block<? super String> block) {
	}
	@Override
	public String first() {
		Iterator<String> iter = this.iterator();
		return iter.hasNext()?this.iterator().next():null;
	}
	@Override
	public MongoIterable<String> batchSize(int batchSize) {
		return this;
	}
	
}
