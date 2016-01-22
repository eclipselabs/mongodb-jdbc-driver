# mongo-jdbc
JDBC channel for MongoDB.
While this driver mostly adheres to the JDBC ways of connections, statements and resultsets, note that this driver does not translate to/from SQL. It uses Mongo's query format instead. 
Example:

	MongodbConnection conn = new MongodbConnection("jdbc:mongodb://localhost/mydb", null);
	try {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("{ find: \"testCollection\",filter: {$text:{$search:\"name\"}} }");
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
		fail(e.getMessage());
	} finally {
		conn.close();
	}
