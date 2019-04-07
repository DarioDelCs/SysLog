package test;

import java.util.List;

import daoImpl.MySQLConnectionImpl;
import log.LogDB;

public class Test {
	
	private static MySQLConnectionImpl con;
	private static LogDB log;

	private static MySQLConnectionImpl con2;
	private static LogDB log2;
	
	public static void main(String[] args) {
		startConnection();

			select();
			insert();
			update();
			delete();
			storedProcedure();
			getLog();
			
		closeConnection();
	}
		
	private static void startConnection () {
		System.out.println("-------------START CONNECTION--------------");
		con = new MySQLConnectionImpl("test_syslog", "admin", "123", "192.168.1.38", "3306");
		log = new LogDB();
		con.addPropertyChangeListener(log);

		con2 = new MySQLConnectionImpl("test_syslog2", "admin", "123", "192.168.1.38", "3306");
		log2 = new LogDB();
		con2.addPropertyChangeListener(log2);
		System.out.println("-------------------------------");
	}
	
	private static void select() {
		System.out.println("-------------SELECTS--------------");
		List<Object[]> list2 = con.doSelect("SELECT * FROM users where NOMBRE = 'Name'");
		for (Object[] objects : list2) {
			for (int i = 0; i < objects.length; i++) {
				System.out.print(objects[i]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		List<Object[]> list1 = con2.doSelect("SELECT * FROM users");
		for (Object[] objects : list1) {
			for (int i = 0; i < objects.length; i++) {
				System.out.print(objects[i]+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	
	private static void insert() {
		System.out.println("-------------INSERTS--------------");
		System.out.println(con.doInsert("Insert into users(LOGIN_ID,NOMBRE,PASSWORD,EMAIL,PROFILENAME) values ('Another','another','12375','some','Administrator')"));
		System.out.println(con2.doInsert("Insert into users(LOGIN_ID,NOMBRE,PASSWORD,EMAIL,PROFILENAME) values ('secondInsert','insert','aaa123','some2','admin')"));
		System.out.println("-------------------------------");
	}
	
	private static void update(){
		System.out.println("-------------UPDATES--------------");
		System.out.println(con2.doUpdate("update users set PASSWORD='newPass' where USER_ID = 2"));
		System.out.println("-------------------------------");
	}

	private static void delete() {
		System.out.println("-------------DELETES--------------");
		System.out.println(con.doDelete("delete from users where NOMBRE='nom'"));
		System.out.println("-------------------------------");
	}
	
	private static void storedProcedure() {
		System.out.println("-------------STORED PROCEDURE--------------");
		System.out.println(con.callStoredProcedure("call insertUser('ProcedureName', 'Login', '123', 'profile', 'email')"));
		System.out.println(con.callStoredProcedure("call updateUsers('newProcedureEmail', '1')"));
		System.out.println(con2.callStoredProcedure("call deleteUsers('1')"));
		System.out.println("-------------------------------");
	}

	private static void getLog() {
		System.out.println("-------------GET LOG--------------");
		System.out.println("First connection");
		LogDB.getSentenceDateType("test_syslog", "admin");
		System.out.println();
		LogDB.getSentenceDate("test_syslog", "admin", "select");
		System.out.println();
		LogDB.getSentenceDateUser("test_syslog", "insert");

		System.out.println();
		System.out.println();
		System.out.println("Second connection");
		LogDB.getSentenceDateType("test_syslog2", "admin");
		System.out.println();
		LogDB.getSentenceDate("test_syslog2", "admin", "insert");
		System.out.println();
		LogDB.getSentenceDateUser("test_syslog2", "stored procedure");
		System.out.println("-------------------------------");
	}
	
	private static void closeConnection() {
		System.out.println("-------------CLOSE CONNECTION--------------");
		con.closeConnection();
		con2.closeConnection();
		System.out.println("-------------------------------");
	}

	
}

