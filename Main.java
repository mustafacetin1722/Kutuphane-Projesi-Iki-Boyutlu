import java.time.LocalDate;
import java.util.*;


public class Main {

    static int INDEX = 20;
    static String[][] books = new String[INDEX][4];
    static String[][] patrons = new String[INDEX][4];
    static String[][] transactions = new String[INDEX][3];
    static int bookQuantity = 0;
    static int patronQuantity = 0;
    static int transactionsQuantity = 0;


    public static void addBook(String title, String author, String bookPage, String ISBN) {
        if (bookQuantity < INDEX) {
            books[bookQuantity][0] = title;
            books[bookQuantity][1] = author;
            books[bookQuantity][2] = bookPage;
            books[bookQuantity][3] = ISBN;

            bookQuantity++;
        } else {
            String[][] newBooks = new String[books.length + 1][4];
            for (int i = 0; i < books.length; i++) {
                for (int j = 0; j < books[i].length; j++) {
                    newBooks[i][j] = books[i][j];
                }
            }
            newBooks[bookQuantity][0] = title;
            newBooks[bookQuantity][1] = author;
            newBooks[bookQuantity][2] = bookPage;
            newBooks[bookQuantity][3] = ISBN;

            bookQuantity++;
            books = newBooks;

        }
    }

    public static String[] extendBooksArrayOnAddition() {
        String[][] newBooks = new String[books.length + 1][4];
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < 4; j++) {
            }
        }
        return extendBooksArrayOnAddition();
    }


    public static boolean bookAvaible(String ISBN) {
        for (int i = 0; i < bookQuantity; i++) {
            if (books[i][3].equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    public static void generateBookRecommendations(String tc) {
        String bookISBN = null;

        for (int i = 0; i < transactionsQuantity; i++) {
            if (transactions[i][0].equals(tc) && transactions[i][1] != null) {
                bookISBN = transactions[i][1];
                break;
            }
        }
        if (bookISBN == null) {
            Random random = new Random();
            int randomIndex = random.nextInt(bookQuantity);
            String recomTitle = books[randomIndex][0];
            String recomAuthor = books[randomIndex][1];
            String recomPageCount = books[randomIndex][2];
            String recomISBN = books[randomIndex][3];
            System.out.printf("Size önerilen kitap: \nBaşlık: %s, Yazar: %s, Sayfa Sayısı: %s, ISBN: %s",
                    recomTitle, recomAuthor, recomPageCount, recomISBN);
        } else {
            String bookAuthor = null;
            for (int i = 0; i < bookQuantity; i++) {
                if (books[i][3].equals(bookISBN)) {
                    bookAuthor = books[i][1];
                    break;
                }
            }
            System.out.println("Daha önce aldığınız kitaplara göre önerilen kitaplar : ");
            for (int j = 0; j < bookQuantity; j++) {
                if (books[j][1].equals(bookAuthor)) {
                    System.out.println("Başlık: " + books[j][0] +
                            ", Yazar: " + books[j][1] +
                            ", Sayfa Sayısı: " + books[j][2] +
                            ", ISBN: " + books[j][3]);
                }
            }
        }
    }

    
    public static void checkOutBook(String fullName, String tc, String eMail, String password, String bookISBN) {
        if (patronQuantity > INDEX) {
            String[][] newPatrons = new String[patrons.length + 1][4];
            for (int i = 0; i < patrons.length; i++) {
                for (int j = 0; j < patrons[i].length; j++) {
                    patrons[i][j] = newPatrons[i][j];
                }
            }
            newPatrons[patronQuantity][0] = fullName;
            newPatrons[patronQuantity][1] = tc;
            newPatrons[patronQuantity][2] = eMail;
            newPatrons[patronQuantity][3] = password;
            patronQuantity++;
            patrons = newPatrons;

            boolean book = false;
            for (int i = 0; i < books.length; i++) {
                if (books[i][3].equals(bookISBN)) {
                    System.out.println(books[i][0] + "  adında bir kitap var. Yazar :" + books[i][1]);
                    book = true;
                    break;
                }
            }
            if (book) {
                if (INDEX > transactionsQuantity) {
                    transactions[transactionsQuantity][0] = tc;
                    transactions[transactionsQuantity][1] = bookISBN;
                    transactions[transactionsQuantity][2] = LocalDate.now().toString();
                    transactionsQuantity++;
                    System.out.println("Kitap alımı başarılı oldu.");
                } else {
                    String[][] newTransactions = new String[transactions.length + 1][3];
                    for (int i = 0; i < transactions.length; i++) {
                        for (int j = 0; j < transactions[i].length; j++) {
                            transactions[i][j] = newTransactions[i][j];
                        }
                    }
                    newTransactions[transactionsQuantity][0] = tc;
                    newTransactions[transactionsQuantity][1] = bookISBN;
                    newTransactions[transactionsQuantity][2] = LocalDate.now().toString();
                    transactionsQuantity++;
                    transactions = newTransactions;
                }

            } else {
                System.out.println("Kitap bulunmamaktadır.");
            }




        } else {
            patrons[patronQuantity][0] = fullName;
            patrons[patronQuantity][1] = tc;
            patrons[patronQuantity][2] = eMail;
            patrons[patronQuantity][3] = password;
            patronQuantity++;

            boolean book = false;
            for (int i = 0; i < books.length; i++) {
                if (books[i][3].equals(bookISBN)) {
                    System.out.println(books[i][0] + "  adında bir kitap var. Yazar :" + books[i][1]);
                    book = true;
                    break;
                }
            }
            if (book) {
                if (INDEX > transactionsQuantity) {
                    transactions[transactionsQuantity][0] = tc;
                    transactions[transactionsQuantity][1] = bookISBN;
                    transactions[transactionsQuantity][2] = LocalDate.now().toString();
                    transactionsQuantity++;
                    System.out.println("Kitap alımı başarılı oldu.");
                } else {
                    String[][] newTransactions = new String[transactions.length + 1][3];
                    for (int i = 0; i < transactions.length; i++) {
                        for (int j = 0; j < transactions[i].length; j++) {
                            transactions[i][j] = newTransactions[i][j];
                        }
                    }
                    newTransactions[transactionsQuantity][0] = tc;
                    newTransactions[transactionsQuantity][1] = bookISBN;
                    newTransactions[transactionsQuantity][2] = LocalDate.now().toString();
                    transactionsQuantity++;
                    transactions = newTransactions;
                }

            } else {
                System.out.println("Kitap bulunmamaktadır.");
            }
        }
    }





    public static void returnBook(String isbn){

    }

   public static void deleteBook(String ISBN){
       int findIndex=-1;

       if (bookQuantity==0){
           System.out.println("Kütühanede kitap sayısı 0'dır.");
       }
       for (int i=0; i<bookQuantity; i++) {
           if (books[i][3].equals(ISBN)) {
               findIndex = i;
               break;
           }
       }
       if (findIndex!=-1){
           for (int i=findIndex; i<bookQuantity-1; i++){
               books[i]=books[i+1];
           }
           bookQuantity--;
           truncateBooksArrayOnDeletion();
           System.out.println("Kitap Silinmiştir.");
       }
       else {
           System.out.println("Silmek isteğiniz kitap bulunmamaktadır.");

       }
   }
   public static void truncateBooksArrayOnDeletion(){
       String[][] newBooks=new String[books.length][4];
       for (int i=0; i<books.length; i++){
           for (int j=0; j<books[i].length; j++){
               newBooks[i][j]=books[i][j];
           }
       }
       books=newBooks;
   }

    public static void updateBook(String ISBN) {
       Scanner scanner=new Scanner(System.in);

       for (int i=0; i<bookQuantity; i++) {
           if (books[i][3].equals(ISBN)) {
               System.out.println("Kitap başlığını giriniz: ");
               String newTitle = scanner.nextLine();
               System.out.println("Kitap yazarını giriniz: ");
               String newAuthor = scanner.nextLine();
               System.out.println("Kitap sayfasını giriniz :");
               String newPageCount = scanner.nextLine();
               books[i][0] = newTitle;
               books[i][1] = newAuthor;
               books[i][2] = newPageCount;
               System.out.println("Kitap güncellenmiştir.");
               return;
           }
       }
        System.out.println("Kitap bulunmamaktadır.");
    }




    public static void generateReports() {
        int totalBooks = 0;
        if (bookQuantity==0){
            System.out.println("Kütühanede kitap sayısı 0'dır.");
        }
        else {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");
        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
            totalBooks++;
        }
        System.out.println();
        System.out.println("Toplam kitap sayısı : " + totalBooks);
    }
    }




    public static void viewAvailableBooks() {
        if (bookQuantity==0){
            System.out.println("Kitap bulunmamaktadır.");

        }
        else {
            System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");

            for (int i = 0; i < bookQuantity; i++) {
                System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
            }
        }
        System.out.println(transactionsQuantity);


        }
    public static void viewAvailablePatrons() {
        if (patronQuantity==0){
            System.out.println("Kullanıcı bulunmamaktadır.");
        }
        else {
            System.out.printf("%-20s %-20s %-20s %-20s%n", "Kullanıcı İsmi", "Kullanıcı TC","Password", "Email");
            for (int i = 0; i < patronQuantity; i++) {
                System.out.printf("%-20s %-20s %-20s %-20s%n",patrons[i][0],patrons[i][1],patrons[i][3],patrons[i][2]);
            }
        }
    }
    public static void patronsBookView(String tc){
        int index=-1;
        for (int i=0; i<patrons.length; i++){
            if (patrons[i][1].equals(tc)){
                index=i;
                break;
            }
        }
        int patronsIndex=-1;
        for (int i=0; i<transactions.length; i++){
            if (transactions[i][0].equals(tc)){
                patronsIndex=i;
                break;
            }
        }
        if (index!=-1){
            System.out.printf("%-20s %-20s %-20s %-20s%n", "Kullanıcı İsmi", "Kullanıcı TC","Password", "Email");
            System.out.printf("%-20s %-20s %-20s %-20s%n",patrons[index][0],patrons[index][1],patrons[index][3],patrons[index][2]);
            if (patronsIndex!=-1){
                System.out.printf("%-20s %-20s %-20s%n", "Kullanıcı TC", "Kitap ISBN","Tarih");
                System.out.printf("%-20s %-20s %-20s%n",transactions[patronsIndex][0],transactions[patronsIndex][1],transactions[patronsIndex][2]);
            }
            else {
                System.out.println("Kullanıcının kitabı bulunmamaktadır.");
            }
        }else {
            System.out.println("Kullanıcı bulunmamaktadır.");
        }

    }

    public static void searchBooks(String keyWord){
        boolean bookFind=false;
        if (bookQuantity==0){
            System.out.println("Kütühanede kitap sayısı 0'dır.");
        }
        else {
        for (int i=0; i<bookQuantity; i++){
            if (books[i][0].equals(keyWord) || books[i][1].equals(keyWord) ||books[i][3].equals(keyWord)){
                System.out.println("Başlık: " + books[i][0] +
                        ", Yazar: " + books[i][1] +
                        ", Sayfa Sayısı: " + books[i][2] +
                        ", ISBN: " + books[i][3]);
                        bookFind=true;
            }
            if (!bookFind){
                System.out.println("Kitap bulunmamaktadır.");
            }
        }
        }
    }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String islemler="1.  Kitap Ekle\n"+
                "2.  Kitap Alma\n"+
                "3.  Kitap İade Et\n"+
                "4.  Mevcut Kitapları Görüntüle\n"+
                "5.  Kitap Ara\n"+
                "6.  Kitap Sil\n"+
                "7.  Rapor Oluştur\n"+
                "8.  Kullanıcı Bilgilri\n"+
                "9.  Kitap Öner\n"+
                "10. Kitap Güncelle\n"+
                "11. TC ile kullanıcı görüntüle\n"+
                "0.  Çıkış\n";

        while (true) {
            System.out.println();
            System.out.println(islemler);
            System.out.print("Lütfen bir seçenek girin: ");
            try {
                int secim = scanner.nextInt();
                scanner.nextLine();
                switch (secim) {
                    case 1:
                        System.out.println();
                        System.out.println("Kitap başlığını giriniz.");
                        String baslik = scanner.nextLine();
                        System.out.println("Yazar ismini giriniz.");
                        String yazar = scanner.nextLine();
                        System.out.println("Kitap sayfa sayısını giriniz.");
                        String sayfaSayisi = scanner.nextLine();
                        System.out.println("ISBN kodunu giriniz.");
                        String isbn = scanner.nextLine();
                        addBook(baslik, yazar, sayfaSayisi, isbn);
                        System.out.println();
                        break;
                    case 2:
                       /* System.out.println("Almak istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn1 = scanner.nextLine();
                        System.out.println("Kullanıcı Ad Soyad giriniz(orn:Mustafa Çetin)");
                        String names = scanner.nextLine();
                        System.out.println("Kullanıcı ID giriniz.");
                        String patronId = scanner.nextLine();
                        checkOutBook(isbn1, names, patronId);*/



                        System.out.println("Kullanıcı Ad Soyad giriniz(orn:Mustafa Çetin)");
                        String fullName = scanner.nextLine();
                        System.out.println("Kullanıcı TC giriniz(orn:12345678910)");
                        String TC = scanner.nextLine();
                        System.out.println("Kullanıcı EMAİL giriniz.");
                        String email = scanner.nextLine();
                        System.out.println("Kullanıcı password giriniz.");
                        String password=scanner.nextLine();
                        System.out.println("Almak istediğiniz kitabın ISBN kodunu giriniz.");
                        String bookISBN=scanner.nextLine();
                        checkOutBook(fullName,TC,email,password,bookISBN);
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("İade istedipiniz kitabın ISBN kodunu giriniz.");
                        String isbn3 = scanner.nextLine();
                        System.out.println("Kullanıcı ismini giriniz.");
                        String patron1 = scanner.nextLine();
                        System.out.println("İade kitap sayısı.");
                        int iadeKitap = scanner.nextInt();
                        //returnBook();
                        System.out.println();
                        break;
                    case 4:
                        viewAvailableBooks();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Aramak istediğiniz kitabın ISBN,Yazar veya Başlığını yazaınız.");
                        String key = scanner.nextLine();
                        searchBooks(key);
                        System.out.println();
                        break;

                    case 6:
                        System.out.println("Lütfen silmek istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn4 = scanner.nextLine();
                        deleteBook(isbn4);
                        break;
                    case 7:
                        System.out.println();
                        generateReports();
                        System.out.println();
                        break;
                    case 8:
                        viewAvailablePatrons();
                        break;
                    case 9:
                        System.out.println("Lütfen Kullanıcı TC giriniz.");
                        String tc=scanner.nextLine();
                        generateBookRecommendations(tc);
                        break;
                    case 10:
                        System.out.println("Güncellemek istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn5=scanner.nextLine();
                        updateBook(isbn5);
                        break;
                    case 11:
                        System.out.println("Kullanıcı TC giriniz.");
                        String tc2=scanner.nextLine();
                        patronsBookView(tc2);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Geçersiz işlem...");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Lütfen rakam ile cevap giriniz.");
                scanner.nextLine();
            }
        }
    }
}

