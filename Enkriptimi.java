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
  public String encrypt(String plaintext) {
        // Remove any non-letter characters from the plaintext and convert to uppercase
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Add an X between consecutive identical letters and pad with X if necessary
        StringBuilder sb = new StringBuilder();
        sb.append(plaintext.charAt(0));
        for (int i = 1; i < plaintext.length(); i++) {
            char prev = sb.charAt(sb.length() - 1);
            char curr = plaintext.charAt(i);
            if (prev == curr) {
                sb.append('X');
            }
            sb.append(curr);
        }
        if (sb.length() % 2 != 0) {
            sb.append('X');
        }

