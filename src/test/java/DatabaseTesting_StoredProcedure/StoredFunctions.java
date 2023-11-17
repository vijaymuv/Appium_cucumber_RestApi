package DatabaseTesting_StoredProcedure;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;

public class StoredFunctions {
    Statement s = null;
    Connection con = null;
    ResultSet rs, rs1, rs2;
    CallableStatement css;
    @BeforeClass
    void setUp() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Vijay@2608");

    }

    @AfterClass
    void tearDown() throws SQLException {

        con.close();
    }

    public boolean compareResultSets(ResultSet result1, ResultSet result2) throws SQLException {
        while (result1.next()) {
            result2.next();
            int count = result1.getMetaData().getColumnCount();
            for (int i = 1; i <= count; i++) {
                if (!StringUtils.equals(result1.getString(i), result2.getString(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void storedFunction_FoundOrNot() throws SQLException {
        s = con.createStatement();
        rs = s.executeQuery("show function status where Name ='customerCreditLevel';");
        rs.next();
        Assert.assertEquals(rs.getString("Name"), "customerCreditLevel");
        System.out.println("stored Function_Found or not");
    }

    @Test
    public void storedFunctionSelectCommandsValidation() throws SQLException {
        rs1 = con.createStatement().executeQuery("select customerName, customerCreditLevel(creditLimit) from customers");
        rs2 = con.createStatement().executeQuery("select customerName, case\n" +
                "when creditLimit>50000 then 'platinum'\n" +
                "when creditLimit>=10000 and creditlimit<50000 then 'gold'\n" +
                "when creditLimit<10000 then 'silver'\n" +
                "end as customerLevel from customers");

        Assert.assertEquals(compareResultSets(rs1, rs2), true);
    }

    @Test
    public void storedFunctionRunningTgrhStProcedure() throws SQLException {
      css = con.prepareCall("{call getCustomerLevel(?,?)}");
        css.setInt(1,131);
        css.registerOutParameter(2,Types.VARCHAR);
        css.executeQuery();
        String cusLevel = css.getString(2);
        System.out.println("anInt:"+cusLevel);

        rs2= con.createStatement().executeQuery("select\n" +
                "case\n" +
                "when creditLimit>50000 then 'platinum'\n" +
                "when creditLimit<50000 and creditLimit<10000 then 'gold'\n" +
                "when creditLimit <10000 then 'silver'\n" +
                "end as customerLevel from customers where customerNumber=131;");
        rs2.next();
        String expected = rs2.getString("customerLevel");
        Assert.assertEquals(cusLevel,expected);
    }

}
