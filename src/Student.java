public class Student {
    private String numărMatricol;
    private String prenume;
    private String nume;
    private String formațieDeStudiu;

    public Student(String numărMatricol, String prenume, String nume, String formațieDeStudiu) {
        this.numărMatricol = numărMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formațieDeStudiu = formațieDeStudiu;
    }

    @Override
    public String toString() {
        return "Student {" +
                "\n  numărMatricol    = " + numărMatricol +
                "\n  prenume          = " + prenume +
                "\n  nume             = " + nume +
                "\n  formațieDeStudiu = " + formațieDeStudiu +
                "\n}";
    }
}