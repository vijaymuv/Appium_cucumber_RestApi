package DatabaseTesting_StoredProcedure;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;
/*
syntax
{call procedure_name()}         accepts no parameters and return no values
{call procedure_name("","")}     accepts two parameters and return no values
{?= call procedure_name()}       accepts no parameters and return values
{?= call procedure_name(?)}      accepts one parameters and return values */
public class StoredProcedure {
    Connection c = null;
    Statement s = null;
    ResultSet rs, rs1, rs2;
    CallableStatement cstate;

    @BeforeClass
    void setUp() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Vijay@2608");
    }

    @AfterClass
    public void tearDown() throws SQLException {
        c.close();
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

    @Test(priority = 1)
    public void check_storedProcedure_Exists() throws SQLException {
        s = c.createStatement();
        rs = s.executeQuery("show procedure status where db='classicmodels'");
        rs.next();
        Assert.assertEquals(rs.getString("Db"), "classicmodels");
        rs = s.executeQuery("show procedure status where name='selectAllCustomers'");
        rs.next();
        Assert.assertEquals(rs.getString("Name"), "selectAllCustomers");
    }

    @Test(priority = 2)
    void selectAllCustomers() throws SQLException {
        cstate = c.prepareCall("{call selectAllCustomers()}");
        rs1 = cstate.executeQuery();
        Statement statement = c.createStatement();
        rs2 = statement.executeQuery("select * from customers");
        Assert.assertEquals(compareResultSets(rs1, rs2), true);
    }


    @Test(priority = 3)
    void selectAllCustomersByCity() throws SQLException {
        cstate = c.prepareCall("{call selectAllCustomersByCity(?)}");
        cstate.setString(1, "singapore");
        rs1 = cstate.executeQuery();
        Statement statement = c.createStatement();
        rs2 = statement.executeQuery("select * from customers where city ='singapore'");
        Assert.assertEquals(compareResultSets(rs1, rs2), true);
    }

    @Test(priority = 4)
    void selectCityAndPin() throws SQLException {
        cstate = c.prepareCall("{call selectCityAndPin(?,?)}");
        cstate.setString(1, "singapore");
        cstate.setString(2, "079903");
        rs1 = cstate.executeQuery();
        Statement statement = c.createStatement();
        rs2 = statement.executeQuery("select * from customers where city ='singapore' and postalcode='079903'");
        Assert.assertEquals(compareResultSets(rs1, rs2), true);
    }

}
