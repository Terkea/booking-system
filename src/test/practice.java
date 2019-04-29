package test;

public class practice {

    public static String removePerformers(String string){
        return string.substring(0, string.indexOf("[")) + string.substring(string.indexOf("]")+1);
    }

    public static String addPerformers(String string, String[] performers){
        String draft = string.replaceFirst("Performers:", "Performers: \n" +
                "[");
        for(int i = 0; i<performers.length;i++){
            draft +=performers[i];
        }
        return draft + "]";
    }

    public static void main(String args[]){
        String practice1 = "Full Address: \n" +
                "1\n" +
                "Performance Time: \n" +
                "00:32\n" +
                "Performers: \n" +
                "[11.Indie Max, 12.Max Pop, 3.Sword, 5.Silver Blast Wire, 10.Elex]\n" +
                "Other Details: \n";

        String practice2 = "Full Address: \n" +
                "1\n" +
                "Performance Time: \n" +
                "00:43\n" +
                "Performers: \n" +
                "[11.Indie Max]\n" +
                "Other Details: \n" +
                "1";

        String trim = "TRIM: " + removePerformers(practice2);
        String[] test = {"1.test", "2.test", "3.test"};
        String concat = "CONCAT: " + addPerformers(removePerformers(practice2),test);

        System.err.println(concat);

    }

}
