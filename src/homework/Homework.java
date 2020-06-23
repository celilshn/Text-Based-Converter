package homework;

import homework.Model.NumberHelper;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Abdulcelil Şahin
 */
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> mWordsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter a calculation:"); 
        StringBuilder builder = new StringBuilder();
        String input = scanner.nextLine(); //Kullanıcıdan girdi değeri alındı 
        
        String[] splitArray = input.split(" "); //Girdi kelimelere ayrıldı
        NumberHelper helper = new NumberHelper(); 
        
        for(String word : splitArray) //Kelimeler sayılara ve operatörlere dönüşecek.
        {
            if(helper.getWords().contains(word.toLowerCase())){
            builder.append(helper.getNumbers().get(helper.getWords().indexOf(word.toLowerCase()))+" ");
            }
            else{
            builder.append(helper.operatorToSymbol(word)+" ");
            //Yeni bir string içinde saklanacak.
            }
        }
        String[] builderSplitArray = builder.toString().split(" "); //Oluşturulan string yeniden kelimelerine ayrılacak.
        for(String a :builderSplitArray) // Kelimeler arrayliste aktarılacak.
            mWordsList.add(a);
        helper.rebuildRecrusive(mWordsList); // Kurallarına göre hesaplama işlemi tamamlanacak.agaaga
        main(args);

    }
    
}
