package controllerButton;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import view.MainFrame;



import view.StockListFrame;

public class StockListMenuExcelCommand implements ICommand{
	
	private StockListFrame stocklistframe;
	public StockListMenuExcelCommand(StockListFrame stocklistframe) {
		// TODO Auto-generated constructor stub
		this.stocklistframe = stocklistframe;
	}
	private void openFile(String file) {
		// TODO Auto-generated method stub
		try{
            File path = new File(file);
            Desktop.getDesktop().open(path);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				JFileChooser jFileChooser = new JFileChooser();
				MainFrame mainframe = new MainFrame();
				StockListFrame stocklistframe = new StockListFrame();
				
				jFileChooser.showSaveDialog(mainframe);
				File saveFile = jFileChooser.getSelectedFile();
				if(saveFile != null) {
					saveFile = new File(saveFile.toString()+".xlsx");
					Workbook wb = new XSSFWorkbook();
					Sheet sheet = wb.createSheet("StockList");
					Row rowCol = sheet.createRow(0);
					
					for(int i=0;i<stocklistframe.table.getColumnCount(); i++) {
						Cell cell = rowCol.createCell(i);
						cell.setCellValue(stocklistframe.table.getColumnName(i));
					}
					
					for (int j=0;j<stocklistframe.table.getRowCount(); j++) {
						Row row = sheet.createRow(j+1);
						for(int k=0;k<stocklistframe.table.getColumnCount();k++) {
							Cell cell = row.createCell(k);
							if(stocklistframe.table.getValueAt(j, k) != null) {
								cell.setCellValue(stocklistframe.table.getValueAt(j, k).toString());
							}
						}
					}
					FileOutputStream out = null;
					try {
						out = new FileOutputStream(new File(saveFile.toString()));
					} catch (FileNotFoundException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					try {
						wb.write(out);
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						wb.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					openFile(saveFile.toString());
				}
	}
	
}
