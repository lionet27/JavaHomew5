// Пусть дан список сотрудников: см. файл spisok.txt
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности Имени.
import java.util.TreeMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class task2 {
    public static TreeMap<String,Double> CountName(ArrayList<String> list){
        TreeMap<String,Double>db=new TreeMap<>(); 
        for (int i=0;i<list.size();i++){
            String [] words=(list.get(i)).split(" ");
            if(db.containsKey(words[0])){ 
                db.put(words[0],(db.get(words[0])+1));
            }else{
                db.put(words[0],1.0);
            }      
        }
        return db; 
    }    

    public static void main(String[] args) {
        String file_name = "spisok.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(file_name));
            String [] stroki=new String[lines.size()];
            lines.toArray(stroki);
            System.out.println(stroki);
            ArrayList<String> list=new ArrayList<>();
            for (String string : stroki) {
                list.add(string);
            }
            System.out.println(list);
            System.out.println();

            TreeMap<String,Double>db=CountName(list);    
            System.out.println("Имена с количеством повторений:"); 
            System.out.println(db); 
            System.out.println(); 
            
            TreeMap<Double,String>newdb=new TreeMap<>(Comparator.reverseOrder());
            double x=0.01;
            for (int i=0;i<list.size();i++){
                String [] words=(list.get(i)).split(" ");
                newdb.put((db.get(words[0])+x),list.get(i));
                x+=0.01;
            }                        
            System.out.println("Список имен, отсортированный по убыванию популярности Имени:");
            for (var item : newdb.entrySet()) {
                System.out.println(item.getValue());
            }    
        } 
        catch (IOException e) {
            e.printStackTrace();
        }     
        
    }
}           
    

