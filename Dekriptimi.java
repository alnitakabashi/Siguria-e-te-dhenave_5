public class Dekriptimi {
    private char[][] matrica = new char[5][5];

    public Dekriptimi(String key) {
        // Hiqni çdo karakter jo shkronjë nga çelësi
        key = key.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // inicializimi i matrices katrore fillim
        int row = 0, col = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'J') {
                c = 'I';  // Zevendeso J me I
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
         private boolean contains(char c) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrica[row][col] == c) {
                    return true;
                }
            }
        }
        return false;
    }
        
        public String decrypt(String ciphertext) {
        //Hiqni çdo karakter jo shkronje nga çelësi
        ciphertext = ciphertext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);
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

