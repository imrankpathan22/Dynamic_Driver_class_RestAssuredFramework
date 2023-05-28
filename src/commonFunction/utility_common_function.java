package commonFunction;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility_common_function {
public static void EvidenceCreator(String Filename, String responsebody,String requestBody) throws IOException {
	File newfile = new File("C:\\Imran123\\" +Filename +".txt");
		System.out.println("a new file is created to save request and response :"+newfile.getName());	
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("requestbody"+requestBody+"\n\n"); 
		datawrite.write("responsebody"+responsebody);
		datawrite.close();
		System.out.println("request and response body saved in a file" + newfile.getName());}
		public static ArrayList<String> readdataexcel(String sheetname,String testcasename) throws IOException 
{
ArrayList<String> arraydata=new ArrayList<String>();
//step1 create object of file inputstream
FileInputStream fis=new FileInputStream("C:\\Imran123\\Imran02.xlsx");
//step2 access the excel file
XSSFWorkbook workbook=new XSSFWorkbook(fis);
// step3 access sheetname
int countofsheet=workbook.getNumberOfSheets();
//System.out.println(countofsheet);
for (int i=0;i<countofsheet;i++)
{
String filesheetname=workbook.getSheetName(i);
if (filesheetname.equalsIgnoreCase(sheetname))
{
//step4 access the row from where data supposed to fetch
XSSFSheet sheet=workbook.getSheetAt(i);
Iterator<Row> rows=sheet.iterator();
//Row r=rows.next();
while(rows.hasNext())
{
Row r2=rows.next();
if (r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
{
Iterator<Cell> cellvalues=r2.cellIterator();
while(cellvalues.hasNext())
{
String testdata=cellvalues.next().getStringCellValue();
arraydata.add(testdata);
}}}}}
workbook.close();
return arraydata; }}
