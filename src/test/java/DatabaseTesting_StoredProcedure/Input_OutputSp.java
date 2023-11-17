package DatabaseTesting_StoredProcedure;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class Input_OutputSp {

    Connection c = null;
    Statement s = null;
    ResultSet rs, rs1, rs2;
    CallableStatement cs;

    @BeforeClass
    void setUp() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Vijay@2608");
    }

    @AfterClass
    public void tearDown() throws SQLException {
        c.close();
    }

    @Test
    public void getOrderByCustomerNo() throws SQLException {
         cs = c.prepareCall("{call getOrderByCustomerNumber(?,?,?,?,?)}");
         cs.setInt(1,141);
        cs.registerOutParameter(2, Types.INTEGER);
        cs.registerOutParameter(3, Types.INTEGER);
        cs.registerOutParameter(4, Types.INTEGER);
        cs.registerOutParameter(5, Types.INTEGER);
        cs.executeQuery();

        int shipped= cs.getInt(2);
        int canceled= cs.getInt(3);
        int resolved= cs.getInt(4);
        int disputed= cs.getInt(5);
        System.out.println(shipped+" "+canceled+" "+resolved+" "+disputed);

        s = c.createStatement();
        rs = s.executeQuery("select\n" +
                "(select count(*) as 'shipped' from orders where customerNumber=141 and status='shipped') as shipped,\n" +
                "(select count(*) as 'canceled' from orders where customerNumber=141 and status='canceled') as canceled,\n" +
                "(select count(*) as 'resolved' from orders where customerNumber=141 and status='resolved') as resolved,\n" +
                "(select count(*) as 'disputed' from orders where customerNumber=141 and status='disputed') as disputed;");
        rs.next();
        int shipped1 = rs.getInt("shipped");
        int canceled1 = rs.getInt("canceled");
        int resolved1 = rs.getInt("resolved");
        int disputed1 = rs.getInt("disputed");

        if (shipped==shipped1 && canceled==canceled1 && resolved==resolved1 && disputed==disputed1 )
            {
                Assert.assertTrue(true);

            }else {

            Assert.assertTrue(false);
        }
            }
@Test
          void  getCustomerDelivertDate() throws SQLException {
              cs = c.prepareCall("{call getCustomerDeliveryDate(?,?)}");
              cs.setInt(1,112);
              cs.registerOutParameter(2, Types.VARCHAR);

              cs.executeQuery();

              String dlvtime = cs.getString(2);
              System.out.println(dlvtime);

              s = c.createStatement();
              rs = s.executeQuery("\n" +
                      "select country,\n" +
                      "case when country='usa' then '3-days shipping'\n" +
                      "when country='canada' then '5-days shipping'\n" +
                      "else'10-days shipping'\n" +
                      "end as shippingTime\n" +
                      "from customers where customerNumber=112");
              rs.next();
    String dlvtime1 = rs.getString("shippingTime");

    Assert.assertEquals(dlvtime,dlvtime1);
            }


        }

