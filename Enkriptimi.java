public class Enkriptimi {
  private char[] matrica = new char[5][5];
  
  public Enkriptimi(String key){
    key = key.replaceAll("[^a-zA-Z]",""]).toUpperCase();
  }
  int row = 0, col = 0;
  for(int i =0; i<key.length();i++){
    char c = key.charAt(i);
    if(c == 'J'){
      c = 'I';
  }
  if(!contains(c)){
    matrica[row][col] = c;
    col++;
    if(col == 5){
    row++;
    col=0;
    }
  }
}
