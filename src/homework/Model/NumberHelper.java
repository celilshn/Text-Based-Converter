package homework.Model;

import java.util.ArrayList;
/**
 *
 * @author Abdulcelil Şahin
 */
public class NumberHelper {
    private ArrayList<String> words;
    private ArrayList<Integer> numbers;

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
    public NumberHelper() {
        setWords();
        setNumbers();
    }
   /*
    Kelimeler ve sayılar tanımlanıyor.
    */
    private void setWords(){
    words = new ArrayList<>();
    words.add("one");
    words.add("two");
    words.add("three");
    words.add("four");
    words.add("five");
    words.add("six");
    words.add("seven");
    words.add("eight");
    words.add("nine");        
    }
    private void setNumbers(){
    numbers = new ArrayList<>();
    numbers.add(1);   
    numbers.add(2);   
    numbers.add(3);   
    numbers.add(4);   
    numbers.add(5);   
    numbers.add(6);   
    numbers.add(7);   
    numbers.add(8);
    numbers.add(9);   
    }
       /*
    Kelimeler ve sayılar tanımlanıyor.
    */
    /*
    Semboller string operatörlere gönüştürülüyor.
    */
    public String operatorToSymbol(String oWord){
        String word = oWord.toLowerCase();
        switch (word){
            case "add":
                return "+";
            case "plus":
                return "+";
           
            case "subtract":
                return "-";                
            case "minus":
                return "-";
            case "less":
                return "-";
                
            case "multiplied-by":
                return "*";
            case "times":
                return "*";
                
            case "divided-by":
                return "/";              
            case "over":
                return "/";
            default:return null;
        }
    }
        /*
    Semboller string operatörlere gönüştürülüyor.
    */
    public void rebuildRecrusive(ArrayList<String> mWordsList) //Operatörler işlem önceliğine göre kontrol ediliyor. 
    {
        if(mWordsList.contains("*")) //Birinci Öncelikli işlem
        {
           int index = mWordsList.indexOf("*");
            double f = Double.valueOf(mWordsList.get(index-1));              
            double l = Double.valueOf(mWordsList.get(index+1));
            mWordsList.remove(index-1);  
            mWordsList.remove(index);
            mWordsList.set(index-1, String.valueOf(l*f));
  //          System.out.println(mWordsList.toString());
            rebuildRecrusive(mWordsList);
        }
        else if(mWordsList.contains("/"))//İkinci  Öncelikli işlem
        {
           int index = mWordsList.indexOf("/");
            double f = Double.valueOf(mWordsList.get(index-1));              
            double l = Double.valueOf(mWordsList.get(index+1));
            mWordsList.remove(index-1);  
            mWordsList.remove(index);
            mWordsList.set(index-1, String.valueOf(f/l));
 //           System.out.println(mWordsList.toString());
            rebuildRecrusive(mWordsList);
        }
        else if(mWordsList.contains("-"))//Üçüncü Öncelikli işlem
        {
           int index = mWordsList.indexOf("-");
            double f = Double.valueOf(mWordsList.get(index-1));              
            double l = Double.valueOf(mWordsList.get(index+1));
            mWordsList.remove(index-1);  
            mWordsList.remove(index);
            mWordsList.set(index-1, String.valueOf(f-l));
//            System.out.println(mWordsList.toString());
            rebuildRecrusive(mWordsList);
        }
        else if(mWordsList.contains("+"))//Dördüncü Öncelikli işlem
        {
           int index = mWordsList.indexOf("+");
            double f = Double.valueOf(mWordsList.get(index-1));              
            double l = Double.valueOf(mWordsList.get(index+1));
            mWordsList.remove(index-1);  
            mWordsList.remove(index);
            mWordsList.set(index-1, String.valueOf(f+l));
     //       System.out.println(mWordsList.toString());
            rebuildRecrusive(mWordsList);
        }
        else//işlemlerin sonu. Sonuç gösterilecek
        {

            double result = Double.valueOf(mWordsList.get(0));
            if((int)result != result)
                System.out.println("Result: "+String.format("%.2f", result));
            else
                System.out.println("Result: " + (int)result);

        }
    }
}
