package type;

public class Board01 {

    private int id;

    private String name;

    private int kor;

    private int eng;

    private int math;

    private int sum;

    private double avr;

    public Board01() {}
    public Board01(int id, String name, int kor, int eng, int math) {
        super();
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calculateSum();
        calculateAvr();
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {

        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAvr() {
        return avr;
    }

    public void setAvr(double avr) {
        this.avr = avr;
    }

    public int calculateSum() {
        return sum = kor + eng + math;
    }
    
    public double calculateAvr() {
        return avr = sum * 100 / 3 / 100.0;
    }
    
    public void printInfo() {
        System.out.println("========================");
        System.out.println("      << 학생 성적 >>");
        System.out.println("========================");
        System.out.printf("학번 : [%d] 이름 : [%s]\n", id, name);
        System.out.printf("국어점수 : [%03d] 영어점수 : [%03d] 수학점수 : [%03d]\n", kor, eng, math);
        System.out.printf("총합 : [%03d] 평균 : [%.2f]\n", calculateSum(), calculateAvr());
        
    }

    public boolean equals(Object o) {
        if (o instanceof Object) {
            Board01 b = (Board01) o;
            if(b.id == id) {
                return true;
            }
        }
        return false;

    }
    @Override
    public String toString() {
        return "Board01 [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
                + sum + ", avr=" + avr + "]";
    }

}
