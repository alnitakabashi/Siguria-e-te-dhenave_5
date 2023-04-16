import java.util.Scanner;

public class Enkriptimi {
    private char[][] matrica = new char[5][5];

    public Enkriptimi(String key) {
        // Hiqni çdo karakter pa shkronjë nga çelësi
        key = key.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Inicializon matricen
        int row = 0, col = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'J') {
                c = 'I';  // Zëvendësoni J me I
            }
            if (!contains(c)) {
                matrica[row][col] = c;
                col++;
                if (col == 5) {
                    row++;
                    col = 0;
                }
            }
        }

        // Ploteson pjesen tjeter te matrices me shkronjat e mbetura te alfabetit
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') {
                continue;  // Skip J
            }
            if (!contains(c)) {
                matrica[row][col] = c;
                col++;
                if (col == 5) {
                    row++;
                    col = 0;
                }
            }
        }
    }
private boolean contains(char c){
  for(int row = 0; row < 5; row++){
  for (int col = 0; col < 5; col++){
  if(matrica[row][col]==c){
    return true;
        }
      }
    }
  return false;
}
   public String encrypt(String plaintext) {
        // Hiqni çdo karakter pa shkronjë nga teksti i thjeshtë dhe kthejeni në shkronja të mëdha
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Shto një X midis shkronjave të njëpasnjëshme identike  nëse është e nevojshme
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
      // Enkriptoni çiftet e shkronjave duke përdorur matricen
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (matrica[row][col] == a) {
                        row1 = row;
                        col1 = col;
                    } else if (matrica[row][col] == b) {
                        row2 = row;
                        col2 = col;
                    }
                }
            }
            if (row1 == row2) {
                // I njejti rresht
                ciphertext.append(matrica[row1][(col1 + 1) % 5]);
                ciphertext.append(matrica[row2][(col2 + 1) % 5]);
            } else if (col1 == col2) {
                // I njejti kolon
                ciphertext.append(matrica[(row1 + 1) % 5][col1]);
                ciphertext.append(matrica[(row2 + 1) % 5][col2]);
            } else {
                ciphertext.append(matrica[row1][col2]);
                ciphertext.append(matrica[row2][col1]);
            }
        }

        return ciphertext.toString();
    }
public static void main(String[]args){
  Scanner scanner = new Scanner(System.in);
  
  System.out.print("Enter the key: ");
  String key = scanner.nextLine();
  
  System.out.print("Enter the plaintext: ");
  String plaintext = scanner.nextLine();
  
  Enkriptimi cipher = new Enkriptimi (key);
  String ciphertext = cipher.encrypt(plaintext);
  
  System.out.println("Ciphertext: " + ciphertext);
}
public void displaymatrica() {
		//Gjeneron metoden automatikisht
		for (int row = 0; row < 5; row++) {
            for (int col = 0; col<5;col++) {
                    System.out.print(matrica[row][col] + " ");
                    }
                    System.out.println();
                }
	}
}

