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

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;

public class MongodbDataSource implements DataSource {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MongodbDataSource.class);
	
	 static {
		try {
			Class.forName(MongodbJdbcDriver.class.getCanonicalName());
		} catch (ClassNotFoundException e) {
			LOG.error("MongoDB DataSource unable to load MongoDB JDBC Driver", e);
			throw new RuntimeException(e);
		}
	}
	 
	private String url;
	private String userName;
	private String password;
	
	private PrintWriter logger;
	private int loginTimeout;
	
	public MongodbDataSource(){}
	
	public MongodbDataSource(String url, String userName, String password){
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return this.logger;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		this.logger = out;
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		this.loginTimeout = seconds;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return this.loginTimeout;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new SQLFeatureNotSupportedException();
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
	public Connection getConnection() throws SQLException {
		return this.getConnection(this.userName, this.password);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return DriverManager.getConnection(this.url, this.userName, this.password);
	}

}
