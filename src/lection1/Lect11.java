package lection1;

public class Lect11 {

    public static void main(String[] args) throws CloneNotSupportedException { //Tocka vchoda v prilozenije, "throws" probrasyvajet iskljucenije na uroven' vyshe
        // (v dannom slucaje JVM (Java virtual machine) v slucaje iskljucenija prosto zavershit rabotu prilozenija)

        //Dlja udobstva vsjo vynes v otdel'nyje metody
        createP1();
        System.out.println("=============================================");
        createP2();
    }

    public static void createP1() { //nacalo lekcii
        Person person = new Person(); //Vyzyvajem konstruktor bez parametrov
        String name = "Matthew Giovannini";
        person.setName(name); //Zadajom imja (lucshe bylo person.setName("Matthew Giovannini");, tut sdelano cerez peremennuju prosto tak)
        System.out.println(name); //Vyvodim lokal'nuju peremennuju (NE peremennuju ob"jekta person, a peremennuju metoda createP1)
        person.setYear(2003); //Zadajom god
        System.out.println(String.format("Name: %s\nYear: %d", person.getName(), person.getYear())); //Vyvodim nuznyje dannyje (v dannom slucaje
        //mozno bylo napisat' System.out.println(person.toString());, poskol'ku metod "toString" peregruzen, zdes' prosto kak primer vyvoda)
    }

    public static void createP2() throws CloneNotSupportedException { //Probrasyvajem dannoje iskljucenije (jesli ono voznikajet) na uroven' vyshe
        Person p1 = new Person("Matthew Giovannini", 2003); //Vyzyvajem konstruktor s dvumja parametrmi
        Person p2 = p1.clone(); //Klonirujem ob"jekt (v dannom slucaje mozno bylo new Person(p1), t.k. my sozdali konstruktor dlja klonirovanija)
        p2.setName("NoName");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}

class Person implements Cloneable { //Podkljucajem k klassu interfejs "Cloneable", ctoby mozno bylo peregruzit' standartnyj metod "clone"
    // (primerno kak peregruzka metodov "__add__" i t.p, v Python)
    private String name = "No Name"; //Peremennyje so znacenijami po umolcaniju
    private int year = 2003;

    public Person() { } //Kuca peregruzennych konstruktorov
    public Person (String name) { this.name = name; }
    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }
    public Person(Person other) { //Konstruktor dlja "klonirovanija"
        this.name = other.name;
        this.year = other.year;
    }

    //================SETTERS==============
    public void setName(String name) { this.name = name; name = "hello"; /*test*/ } //Settery
    public void setYear(int year) { this.year = year; }
    //===============GETTERS======
    public String getName() { return this.name; } //Gettery
    public int getYear() { return this.year; }

    //=================OVERRIDES===========

    @Override
    public String toString() { //Peregruzajem standartnyj metod "toString" (kak "__str__" v Python)
        return String.format("Person(%s, %d)", this.name, this.year);
    }

    @Override
    protected Person clone() throws CloneNotSupportedException { //Peregruzajem standartnyj metod "clone" dlja klonirovanija (ne znaju jest' li cto-to podobnoje v Python)
        return (Person)super.clone();
    }
}