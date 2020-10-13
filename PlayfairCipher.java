public class PlayfairCipher{
    private String Word = new String();
    private String Key = new String();
    private char grid[][] = new char[5][5];
    public void change(String k){
        String move = new String();
        move = move + k.charAt(0);
        for (int i = 1; i < k.length(); i++){
            for (int j = 0; j < move.length(); j++){
                if (k.charAt(i) == move.charAt(j)){
                }
            }
                move = move + k.charAt(i);
        }
        Word = move;
    }
    public void make(){
        char current;
        Key = Word;
        for (int i = 0; i < 26; i++){
            current = (char) (i + 97);
            if (current == 'j')
                continue;
            for (int j = 0; j < Word.length(); j++){
                if (current == Word.charAt(j)){
                    break;
                }
            }
        }
        System.out.println(Key);
        matrix();
    }
    private void matrix(){
        int counter = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                grid[i][j] = Key.charAt(counter);
                System.out.print(grid[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
    }
    private String fix(String old_text){
        int i = 0;
        int len = 0;
        String text = new String();
        len = old_text.length();
        for (int tmp = 0; tmp < len; tmp++){
            if (!Character.isLetter(old_text.charAt(tmp)))
            tmp ++;
            if (old_text.charAt(tmp) == 'j'){
                text = text + 'i';
            }
            if (Character.isLowerCase(old_text.charAt(tmp)))
                text += Character.toUpperCase(old_text.charAt(tmp));
            else
                text = text + old_text.charAt(tmp);
                
        }
        len = text.length();
        for (i = 0; i < len; i = i + 2){
            if (text.charAt(i + 1) == text.charAt(i)){
                text = text.substring(0, i + 1) + 'X' + text.substring(i + 1);
            }
        }
        System.out.println(text);
        return text;
    }
    private String[] Pair(String new_string){
        String old = fix(new_string);
        int size = old.length();
        if (size % 2 != 0){
            size++;
            old = old + 'X';
        }
        String x[] = new String[size / 2];
        int counter = 0;
        for (int i = 0; i < size / 2; i++){
            x[i] = old.substring(counter, counter + 2);
            counter = counter + 2;
        }
        return x;
    }
    public int[] Size(char letter){
        int[] key = new int[2];
        if (letter == 'j')
            letter = 'i';
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (grid[i][j] == letter){
                    key[0] = i;
                    key[1] = j;
                    break;
                }
            }
        }
        return key;
    }
    public String encrypt(String Source){
        String arr[] = Pair(Source);
        String a = new String();
        char b;
        char c;
        int d[] = new int[2];
        int e[] = new int[2];
        for (int i = 0; i < arr.length; i++){
            b = arr[i].charAt(0);
            c = arr[i].charAt(1);
            d = Size(b);
            e = Size(c);
            if (d[0] == e[0]){
                if (d[1] < 4)
                    d[1]++;
                else
                    d[1] = 0;
                if (e[1] < 4)
                    e[1]++;
                else
                    e[1] = 0;
            }
            else if (d[1] == e[1]){
                if (d[0] < 4)
                    d[0]++;
                else
                    d[0] = 0;
                if (e[0] < 4)
                    e[0]++;
                else
                    e[0] = 0;
            }
            else{
                int temp = d[1];
                d[1] = e[1];
                e[1] = temp;
            }
            a = a + grid[d[0]][d[1]]
                    + grid[e[0]][e[1]];
        }
        return a;
    }
    public String decrypt(String Code){
        String a = new String();
        String arr[] = Pair(Code);
        char b;
        char c;
        int d[] = new int[2];
        int e[] = new int[2];
        for (int i = 0; i < arr.length; i++){
            b = arr[i].charAt(0);
            c = arr[i].charAt(1);
            d = Size(b);
            e = Size(c);
            if (d[0] == e[0]){
                if (d[1] > 0)
                    d[1]--;
                else
                    d[1] = 4;
                if (e[1] > 0)
                    e[1]--;
                else
                    e[1] = 4;
            }
            else if (d[1] == e[1]){
                if (d[0] > 0)
                    d[0]--;
                else
                    d[0] = 4;
                if (e[0] > 0)
                    e[0]--;
                else
                    e[0] = 4;
            }
            else{
                int temp = d[1];
                d[1] = e[1];
                e[1] = temp;
            }
            a = a + grid[d[0]][d[1]]
                    + grid[e[0]][e[1]];
        }
        return a;
    }
        
    public static void main(String[] args){
        PlayfairCipher x = new PlayfairCipher();
        String a = (args[0]);
        String b = (args[1]);
        x.change(b);
        x.make();
        System.out.println("Encryption: " + x.encrypt(a));
        System.out.println("Decryption: " + x.decrypt(a));
    }
}
