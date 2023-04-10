import java.io.IOException;

public class Questions {

    String question;
    String delimiter = ",";
    int delimiterSum = 0;
    int lastIndex=0;
    int input;




    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                '}';
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Questions() throws IOException {
        this.question = question;
    }

    boolean isUsable(int input) throws IOException {

        if (delimiterSum >= input) {


        return true;}
        else {
          return false;
        }
    }

    public int countOfAnswers(String data){

      while (lastIndex != -1)

    {

        lastIndex = data.indexOf(delimiter, lastIndex);

        if (lastIndex != -1) {
            delimiterSum++;
            lastIndex += delimiter.length();
        }
       //delimiterSum++;
    }
        return delimiterSum;
    }
}
