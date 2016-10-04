package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoBase<T extends DaoBase<T>> {
	
	public T findById(Connection conn, Long id) throws SQLException {

        PreparedStatement ps = 
        		conn.prepareStatement ("select t.* from " + getTable() + " t where t."+getPrimaryKey() +" = ?");
        ps.setLong(1, id);
	    ResultSet rset = ps.executeQuery();
	    
	    try {
		    if ( !rset.next() ) throw new SQLException("No rows found: " + getTable() + ":" + getPrimaryKey() );
			T base = makeNewT();
			base.decodeResultSet(rset);
			return base;
	    } finally {
		    // Close the RseultSet
		    rset.close();
	    }
	}
	
	public List<T> list(Connection conn) throws SQLException {
	    List<T> list = new ArrayList<T>(); 
	    // Create a Statement
	    Statement stmt = conn.createStatement();
	    try {
		    // Select first_name and last_name column from the customers table
		    ResultSet rset = stmt.executeQuery ("select t.* from " + getTable() + " t");
		    
		    try {
		    	while ( rset.next() ) {
					T base = makeNewT();
					base.decodeResultSet(rset);
		    		list.add(base);
		    	}
			    return list;
		    } finally {
			    // Close the RseultSet
			    rset.close();
		    }
	    } finally {
		    // Close the Statement
		    stmt.close();
	    }
	}
	
	public abstract void decodeResultSet(ResultSet rset) throws SQLException;
	public abstract String getTable();
	public abstract String getPrimaryKey();
	public abstract T makeNewT();
}
