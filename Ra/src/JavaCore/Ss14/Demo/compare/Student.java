package JavaCore.Ss14.Demo.compare;

public class Student implements Comparable<Student>{
    @Override
    public int compareTo(Student o) {
        /*
            Trả về 1 đtg this lớn hơn đtg o
            Trả về 0 đtg this giống đtg o
            Trả về -1 đtg this nhỏ hơn đtg o

        */

        if(this.name.compareTo(o.name)> 0){
            // cú pháp đầy đủ
        }

//        Tiêu chí so sánh: Theo tên
        //Cú pháp trực tiêps
//        return o.score....
//        return Double.compare(this.score, o.score);
        //Ép kieeur lm mất dữ liệu -> sai
//        return (int)(this.score-o.score);

        //Sắp xếp theo đa tiêu chí: Sắp xếp điểm tăng dần nếu điểm giống nhau thì sắp xếp theo id giảm dần
        if(this.score==o.score){
            return o.id-this.id;
        }
        return Double.compare(this.score,o.score);

    }

    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
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
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
