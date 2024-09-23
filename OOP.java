public class OOP {
    public static void main(String[] args) {
        Student student1 = new Student("Иван Иванов Иванович", 18, "МГУ", "Информационные технологии", 2);
        Student student2 = new Student("Мария Владимировна Сергеевна", 19, "МГИМО", "Экономика", 3);
        Teacher teacher1 = new Teacher("Алексей Кузнецов Петрович", 35, "МГИМО", "Математика", 60000, 3);
        Teacher teacher2 = new Teacher("Антон Иванов Иванович", 35, "МГИМО", "Физика", 70000, 3);
        TeachingAssistant ta1 = new TeachingAssistant("Дмитрий Иванов Иванович", 23, "МГИМО", "Физика", 40000, 5, 5);
        TeachingAssistant ta2 = new TeachingAssistant("Олег Иванов Иванович", 26, "МГИМО", "Английский язык", 40000, 5, 5);


        student1.info();
        student2.info();
        teacher1.info();
        teacher2.info();
        ta1.info();
        ta2.info();

        System.out.println("Количество студентов: " + Student.getStudentCount());
        System.out.println("Средняя зарплата преподавателей: " + Teacher.getAverageSalary());
        System.out.println("Среднее количество часов: " + TeachingAssistant.getAverageHour());
    }
}


abstract class Person {
    private String name;
    private int age;
    private String institute;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.institute = "Unknown";
    }

    public Person(String name, int age, String institute) {
        this.name = name;
        this.age = age;
        this.institute = institute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public abstract void info();

}

class Student extends Person {
    private String speciality;
    private int year;
    private static int studentCount = 0;

    public Student(String name, int age, String institute, String speciality, int year) {
        super(name, age, institute);
        this.speciality = speciality;
        this.year = year;
        studentCount++;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String major) {
        this.speciality = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void info() {
        System.out.println("Имя: " + getName() + ", Возраст: " + getAge() +
                ", Институт: " + getInstitute() + ", Специальность: " + speciality + ", Курс: " + year);
    }

    public static int getStudentCount() {
        return studentCount;
    }
}

class Teacher extends Person {
    private String subject;
    private double salary;
    private int experience;
    private static int teacherCount = 0;
    private static double allsalary = 0;
    
    public Teacher(String name, int age, String institute, String subject, double salary, int experience) {
        super(name, age, institute);
        this.subject = subject;
        this.salary = salary;
        this.experience = experience;
        teacherCount++;
        allsalary+= salary;
   
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void info() {
        System.out.println("Имя: " + getName() + ", Возраст: " + getAge() +
                ", Институт: " + getInstitute() + ", Предмет: " + subject + ", Зарплата: " + salary + ", Опыт: " + experience );
    }
    public static int getTeacherCount() {
        return teacherCount;
    }
    public static double getAverageSalary() {
        return allsalary/teacherCount;
    }
}

class TeachingAssistant extends Person {
    private String subject;
    private double salary;
    private int experience;
    private int hour;
    private static int assistCount = 0;
    private static double allhour = 0;


    public TeachingAssistant(String name, int age, String institute, String subject, double salary, int experience, int hour) {
        super(name, age, institute);
        this.subject = subject;
        this.salary = salary;
        this.experience = experience;
        this.hour = hour;
        assistCount++;
        allhour+=hour;

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public static int getAssistCount() {
        return assistCount;
    }
    public static double getAverageHour() {
        return allhour/assistCount;
    }


    @Override
    public void info() {
        System.out.println("Имя: " + getName() + ", Возраст: " + getAge() +
                ", Институт: " + getInstitute() + ", Предмет: " + getSubject() +
                ", Зарплата: " + getSalary() + ", Опыт: " + experience + ", Часы работы в неделю: " + hour);
    }
}
