package h08.roommanagement;

public class Student {

    public final String name;
    public final boolean hasCertificate;

    /**
     * This is the constructor of Student. It sets this.name and this.hasCertificate.
     * @param name value of this.name
     * @param hasCertificate value of this.hasCertificate
     */
    public Student(String name, boolean hasCertificate) {
        this.name = name;
        this.hasCertificate = hasCertificate;
    }

    /**
     * This method returns a String containing this.name and this.hasCertificate
     * @return returns String with attributes
     */
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", hasCertificate=" + hasCertificate + '}';
    }
}
