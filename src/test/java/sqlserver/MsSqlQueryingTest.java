package sqlserver;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import util.DataBaseUtils;
import util.ReadProperties;


public class MsSqlQueryingTest {

	@Test
	public void fetchData() throws SQLException {
		DataBaseUtils dataBaseUtils = new DataBaseUtils();
		String query = "select * from Course";
		List<String> listOfCourses = dataBaseUtils.getValuesFromColumn(query,"course_name");
		System.out.println(listOfCourses);
	}

	@Test
	public void insertData() throws SQLException {
		DataBaseUtils dataBaseUtils = new DataBaseUtils();
		String query = "insert into Course values('Automation Testing',20000);";
		dataBaseUtils.updateTableData(query);
	}
}
