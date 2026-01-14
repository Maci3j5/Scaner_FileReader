void main() throws IOException {
    Scanner scanner = new Scanner(System.in);
    //System.in = klawiatura
//    System.out.println("Podaj imie: ");
//    String name = scanner.nextLine();
//    System.out.println("Podaj wiek: ");
//
//    int age = scanner.nextInt();
//    System.out.println("Witaj " + name + " w naszym programie!");
//    System.out.println("Masz " + age + " lat");
//    System.out.println("Podaj liczbe a: ");
//    int a  = scanner.nextInt();
//    System.out.println("Podaj liczbe b: ");
//    int b = scanner.nextInt();
//    addNumbers(a, b);
//    public  void addNumbers (int a, int b){
//    System.out.println("Wynik: " + (a + b));

    //FileWriter - prymitywna klasa do zapisu danych do pliku

    FileWriter fileWriter = new FileWriter("test.txt");
    fileWriter.write("Dupa\n");
    fileWriter.write("cycyki123\n");
    fileWriter.close();
    //jezeli plik nie istnieje to go stworzy a jak istnieje to go nadpisze
    FileWriter fileWriterToAppend = new FileWriter("test.txt", true); //to pozwala na dopisanie do istniejacego pliku
    fileWriterToAppend.write("asdasd");
    fileWriterToAppend.close();

    FileWriter fileWriterAdix = new FileWriter("adix", true);
    fileWriterAdix.write("\ndupa");
    fileWriterAdix.close();

    //File reader - do odczytu
//   FileReader fileReader = new FileReader("test.txt");
//   System.out.println((char)fileReader.read());
//   int code;
//   while ((code = fileReader.read())!= -1){
//      char c =  (char)code;
//      System.out.println(c);
//   }
//   fileReader.close();

    //Buffered czyli lepsze wersje ktore czytaja/zapisuja hurtowo
    //FileReader czyta znak po znaku
    //BufferedReader bierze wiekszy kawalek danych do bufora i go czyta z pamieci
    //jest to szybciej, jest mniej operacji

    //READER
    BufferedReader bufferedReader = new BufferedReader(new FileReader("adix"));
    System.out.println(bufferedReader.readLine());
    List<String> wszystkieStringi = bufferedReader.readAllLines();
    System.out.println(wszystkieStringi);
    //zapis do listy wszystkich lini z pliku pozwala nam cos na tych elementach robic np wypisac dupy!

    for (String string : wszystkieStringi) {
        System.out.println("poj znak " + string);
        if (string.equals("dupa")) {
            System.out.println("Jest dupa!");
        } else {
            System.out.println("Nie ma dupy :(");
        }
    }

    bufferedReader.close();// ZAWSZE!


    //WRITER
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("maciek.txt"));
    bufferedWriter.write("maciek");
    bufferedWriter.newLine(); // to samo co \n
    bufferedWriter.write("maciek");
    bufferedWriter.close();


    System.out.println("\nZadanie 1 - Praca z plikami – pełny zestaw:\n");

    BufferedWriter newNamesFile = new BufferedWriter(new FileWriter("students.txt"));
    newNamesFile.write("Ewelina\n");
    newNamesFile.write("Monika\n");
    newNamesFile.write("Adrian\n");
    newNamesFile.write("Maciek\n");
    newNamesFile.write("Łukasz\n");
    newNamesFile.close();

    BufferedReader readNamesFile = new BufferedReader(new FileReader("students.txt"));
    List<String> allNames = readNamesFile.readAllLines();

    List<String> nameOnA = new ArrayList<>();
    for (String name : allNames) {
        if (name.startsWith("A"))
            nameOnA.add(name);
        System.out.println(name);
    }

    readNamesFile.close();

    BufferedReader readNamesLoop = new BufferedReader(new FileReader("students.txt"));

    int lineCounter = 0;
    String lineReading = null;
    while ((lineReading = readNamesLoop.readLine()) != null) {
        lineCounter++;
    }
    readNamesLoop.close();

    System.out.println("\nIn this file we have " + lineCounter + " lines.\n");

    System.out.println("Here's all name which starts with 'A': " + nameOnA +"\n");

    BufferedWriter newNumbersFile = new BufferedWriter(new FileWriter("numbers.txt"));
    newNumbersFile.write("1\n");
    newNumbersFile.write("2\n");
    newNumbersFile.write("3\n");
    newNumbersFile.write("4\n");
    newNumbersFile.write("5\n");
    newNumbersFile.write("6\n");
    newNumbersFile.write("7\n");
    newNumbersFile.write("8\n");
    newNumbersFile.write("9\n");
    newNumbersFile.write("10\n");
    newNumbersFile.close();

    BufferedReader readNumbersFile = new BufferedReader(new FileReader("numbers.txt"));
    List<String> allNumbers = readNumbersFile.readAllLines();

    for (String number : allNumbers) {
        System.out.println(number);
    }
    readNumbersFile.close();

    BufferedReader readNumbersLoop = new BufferedReader(new FileReader("numbers.txt"));

    int total = 0;
    String number = null;
    while ((number = readNumbersLoop.readLine()) != null) {
        total = total + Integer.parseInt(number);
    }
    readNumbersLoop.close();

    System.out.println("\nOur total is: " + total + "\n");

    BufferedWriter newNamesFileToAppend = new BufferedWriter(new FileWriter("students.txt", true));
    newNamesFileToAppend.write("Adam\n");
    newNamesFileToAppend.write("Damian\n");
    newNamesFileToAppend.write("Anna\n");
    newNamesFileToAppend.close();

    BufferedReader readNewNamesFile = new BufferedReader(new FileReader("students.txt"));
    List<String> newNameList = readNewNamesFile.readAllLines();

    for (int i = 1; i <= newNameList.size(); i++) {
        System.out.println(i + ": " + newNameList.get(i - 1) + i);
    }

    String longestName = newNameList.get(0);
    for (String name : newNameList) {
        if (name.length() > longestName.length()) {
            longestName = name;
        }
    }

    readNewNamesFile.close();

    BufferedReader readToCopy = new BufferedReader(new FileReader("students.txt"));
    List<String> listForCopy = readToCopy.readAllLines();
    readToCopy.close();

    BufferedWriter writeNewCopy = new BufferedWriter(new FileWriter("copy.txt"));
    writeNewCopy.write(String.valueOf(listForCopy));
    writeNewCopy.close();

    System.out.println("\nOur longest name is: " + longestName + ".\n");

    BufferedReader smallAfinder = new BufferedReader(new FileReader("students.txt"));
    smallAfinder.readAllLines();

    int aCounter = 0;
    for (String name : newNameList) {
        if (name.contains("a")) {
            aCounter++;
        }
    }

    smallAfinder.close();

    System.out.println("We have " + aCounter + " small 'a' letters.");

    BufferedReader nameAsList = new BufferedReader(new FileReader("students.txt"));
    List<String> namesList = nameAsList.readAllLines();
    nameAsList.close();

    for (int i = 0; i < namesList.size(); i++) {
        String name = namesList.get(i);
        String nameWithNumber = name + (i + 1);
        namesList.set(i, nameWithNumber);
    }

    System.out.println(namesList);





















}





