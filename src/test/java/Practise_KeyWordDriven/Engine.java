package Practise_KeyWordDriven;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine {
  public  Actions_keyword action;
    Method[] methods;
   static String keys;

   public  void getmethodsFormClass() throws InvocationTargetException, IllegalAccessException {
       action =new Actions_keyword();
       methods = action.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {

            if (methods[i].getName().equalsIgnoreCase(keys)){
                methods[i].invoke(action);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        ExcelFiles excel = new ExcelFiles();
        //Engine engine = new Engine();
        int locator=3;
        int actionKeyword=4;
        int testData=5;
        for (int row = 1; row <=8 ; row++) {
            excel.read_Excel_locator_actions_testData("C:\\A_files\\AscendTekTestData.xlsx",row,locator,actionKeyword,testData);
          //  engine.getmethodsFormClass();
        }
    }
}
