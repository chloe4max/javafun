package epita.lethao.datamodel.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDB1 {
	private static final String DATABASE = "jdbc:postgresql://localhost:5432/person-database";
	private static final String CREATE_TABLE = "CREATE TABLE public.\"PERSON2\"\r\n" + 
			"(\r\n" + 
			"    name character varying(500) COLLATE pg_catalog.\"default\",\r\n" + 
			"    sex character varying(100) COLLATE pg_catalog.\"default\",\r\n" + 
			"    age integer,\r\n" + 
			"    height double precision,\r\n" + 
			"    weight double precision,\r\n" + 
			"    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),\r\n" + 
			"    CONSTRAINT \"PERSON2_pkey\" PRIMARY KEY (id)\r\n" + 
			")\r\n" + 
			"\r\n" + 
			"TABLESPACE pg_default;\r\n" + 
			"\r\n" + 
			"ALTER TABLE public.\"PERSONS\"\r\n" + 
			"	OWNER to postgres;";
	public static void test() {
		try {
			Connection connection = DriverManager.getConnection(DATABASE, "postgres", "");
			PreparedStatement createStatement = connection.prepareStatement(CREATE_TABLE);
			createStatement.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
