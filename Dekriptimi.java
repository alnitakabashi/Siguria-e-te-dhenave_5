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

