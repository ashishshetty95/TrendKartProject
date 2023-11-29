package Assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.GenericUtils.ExcelUtils;

public class test {
	
	public Object[][] demo()throws EncryptedDocumentException, IOException {
		ExcelUtils eutil=new ExcelUtils();
		Object[][] obj = eutil.readDataUsingDataProviderFromExcel("MultipleData");
		return obj;
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		test t=new test();
		Object[][] obj = t.demo();
		for(int i=0;i<obj.length;i++) {
				System.out.println(obj[i][0]+" "+obj[i][1]);
		}
	}
	
}	
