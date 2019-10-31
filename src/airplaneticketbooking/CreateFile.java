package airplaneticketbooking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CreateFile {

      private File file;
      private String something;
      private PrintStream writeFile;
      private FileReader readSomething;
      private BufferedReader somethingReader;
      
      public CreateFile(){
            
      }

      public void openFile(String name) {
            try {
                  file = new File(name+".txt");
                  file.createNewFile();
                  System.out.println(name+" file created "+file.getAbsolutePath());
                  System.out.println(file.exists());
            } catch (FileNotFoundException ex) {
                  System.out.println("An error occured "+ex);
            } catch(IOException ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      public void addText(String text){
            try{
                  writeFile = new PrintStream(file);
                  writeFile.println(text);
                  writeFile.close();
            }catch(FileNotFoundException ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      public String readFile(String path){
            try{
                  readSomething = new FileReader(path);
                  somethingReader = new BufferedReader(readSomething);
                  something = somethingReader.readLine();
                  somethingReader.close();
                  System.out.println(path+" has been read");
            } catch(FileNotFoundException ex){
                  System.out.println("An error occured "+ex);
            }catch(IOException ex){
                  System.out.println("An error occured "+ex);
            }
            return something;
      }
      
      public File getFile(){
            return file;
      }
      
      public void moveFiles(String fromPath,String toPath){
            try{
                  Path from = Paths.get(fromPath);
                  Path to = Paths.get(toPath);
                  Files.move(from,to.resolve(from.getFileName()),StandardCopyOption.REPLACE_EXISTING);
                  System.out.println(from.getFileName()+" Move success");
            }catch(IOException ex){
                  System.out.println("An error occured "+ex);
            }
      }
      
      public void deleteWhenExit(){
            file.deleteOnExit();
      }
}
