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
        // Hiqni çdo karakter pa shkronjë nga teksti i thjeshtë dhe kthejeni në shkronja të mëdha
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Shto një X midis shkronjave të njëpasnjëshme identike nëse është e nevojshme
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
     Enkriptoni çiftet e shkronjave duke përdorur matricen
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);


