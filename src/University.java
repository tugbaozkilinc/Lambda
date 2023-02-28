public class University {

    private String university;
    private String department;
    private int numOfStd;
    private int averageOfGrade;

    public University(String university, String department, int numOfStd, int averageOfGrade) {
        this.university = university;
        this.department = department;
        this.numOfStd = numOfStd;
        this.averageOfGrade = averageOfGrade;
    }

    public University() {

    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumOfStd() {
        return numOfStd;
    }

    public void setNumOfStd(int numOfStd) {
        this.numOfStd = numOfStd;
    }

    public int getAverageOfGrade() {
        return averageOfGrade;
    }

    public void setAverageOfGrade(int averageOfGrade) {
        this.averageOfGrade = averageOfGrade;
    }

    @Override
    public String toString() {
        return "University{" +
                "university='" + university + '\'' +
                ", department='" + department + '\'' +
                ", numOfStd=" + numOfStd +
                ", averageOfGrade=" + averageOfGrade +
                '}';
    }

}
