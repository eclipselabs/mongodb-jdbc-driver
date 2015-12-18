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
package io.dirigible.mongodb.jdbc;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.util.SortedMap;

public class MongodbParameterMetaData implements ParameterMetaData {

	public MongodbParameterMetaData(SortedMap<Integer, Object> parameters) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (isWrapperFor(iface)) {
	        return (T) this;
	    }
	    throw new SQLException("No wrapper for " + iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return iface != null && iface.isAssignableFrom(getClass());
	}

	@Override
	public int getParameterCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isNullable(int param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSigned(int param) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPrecision(int param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScale(int param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getParameterType(int param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getParameterTypeName(int param) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParameterClassName(int param) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getParameterMode(int param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
