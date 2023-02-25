// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера  2) Вывод всего 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class task1 {

    public static void main(String[] args) {
        Map<String,ArrayList<String>>db=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        list.add("234145345");
        list.add("764857658");
        db.put("Завражный Иван",(ArrayList<String>)list.clone());
        
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag==true){
            
            System.out.println("Выберете действие:1-добавить номер; 2 -вывести все данные; 3- выход");
            String choice=sc.nextLine();
            
            if (choice.equals("1")){
                System.out.println("Введите имя человека: ");
                String name=sc.nextLine();
                System.out.println("Введите номер или номера телефонов через пробел: ");
                String[] numbers= sc.nextLine().split(" ");
                
                ArrayList<String> list1=new ArrayList<>();
                for (int i=0;i<numbers.length;i++){
                    list1.add(numbers[i]);
                }
                
                if(db.containsKey(name)){
                    for (int i=0;i<list1.size();i++){
                        db.get(name).add(list1.get(i));                        
                    }                    
                }else{
                    db.put(name,list1);
                }           
            }
            else if (choice.equals("2")){
                for (var item : db.entrySet()) {
                    System.out.printf(item.getKey()+":"+item.getValue()+"\n");
                }
            }
            else if (choice.equals("3")){
                flag=false;
            }
            else{System.out.println("Неправильно сделан выбор.Попробуйте еще раз");
            }   
        }
        sc.close();
    }    
}