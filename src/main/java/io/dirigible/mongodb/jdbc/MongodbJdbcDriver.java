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

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class MongodbJdbcDriver implements Driver {

	  public static final int MAJOR_VERSION = 1;
	  public static final int MINOR_VERSION = 0;
	  
	  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MongodbJdbcDriver.class);
	  
	  static {
	    try {
	      java.sql.DriverManager.registerDriver(new MongodbJdbcDriver());
	    } catch (SQLException e) {
	    	LOG.error("Error while registering the JDBC Driver", e);
			throw new RuntimeException(e);
	    }
	  }

	  public static String getVersion() {
	    return "MongoDB " + MAJOR_VERSION + "." + MINOR_VERSION + " JDBC Driver";
	  }

	  public boolean acceptsURL(String url) throws SQLException {
	    return url.startsWith("jdbc:mongodb:");
	  }

	  public Connection connect(String url, Properties info) throws SQLException {
	    return new MongodbConnection(url, info);
	  }

	  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		throw new SQLFeatureNotSupportedException();
	  }

	  public boolean jdbcCompliant() {
	    return false;
	  }

	  public int getMajorVersion() {
	    return MAJOR_VERSION;
	  }

	  public int getMinorVersion() {
	    return MINOR_VERSION;
	  }

	  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
	    throw new SQLFeatureNotSupportedException("The Driver uses slf4j for logging");
	  }

}
