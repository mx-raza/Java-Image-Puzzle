import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class FileChooser{
	private String path;
	
	FileChooser(){
		JFileChooser file = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		file.addChoosableFileFilter(filter);
		int result = file.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION){
			File selectedFile = file.getSelectedFile();
			path = selectedFile.getAbsolutePath();
		}  
		else if(result == JFileChooser.CANCEL_OPTION){
			System.out.println("No File Select");
		}
	}
		
	public String getPath() {
			 return path;
	}
	 

  }