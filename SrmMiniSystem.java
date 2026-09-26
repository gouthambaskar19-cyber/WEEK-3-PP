public class SrmMiniSystem {
    private String name;
    private String regNo;
    private HostelFeeAccount feeAccount;
    private HostelRoom room;

    public static int totalStudents = 0;

    public SrmMiniSystem(String name, String regNo, HostelFeeAccount feeAccount) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = null;
        totalStudents++;
    }

    public void assignRoom(HostelRoom room) {
        this.room = room;
    }

    public String fullStatus() {
        String roomStr = (room != null) ? room.getRoomNo() : "unallotted";
        double due = (feeAccount != null) ? feeAccount.getDue() : 0.0;
        return name + " | Due: Rs " + due + " | Room: " + roomStr;
    }

    public static void main(String[] args) {
        HostelFeeAccount acc1 = new HostelFeeAccount("RA01", 200000, 60000);
        HostelFeeAccount acc2 = new HostelFeeAccount("RA02", 200000, 20000);
        HostelFeeAccount acc3 = new HostelFeeAccount("RA03", 200000, 0);

        // Attempt a negative payment rejection
        acc3.pay(-5000);

        SrmMiniSystem student1 = new SrmMiniSystem("Ravi", "RA01", acc1);
        SrmMiniSystem student2 = new SrmMiniSystem("Anitha", "RA02", acc2);
        SrmMiniSystem student3 = new SrmMiniSystem("Karthik", "RA03", acc3);

        HostelRoom room1 = new HostelRoom("C-214", 2, 0);
        HostelRoom room2 = new HostelRoom("C-507", 2, 0);

        room1.allot(student1.name);
        student1.assignRoom(room1);

        room2.allot(student2.name);
        student2.assignRoom(room2);

        System.out.println(student1.fullStatus());
        System.out.println(student2.fullStatus());
        System.out.println(student3.fullStatus());

        System.out.println("Total students: " + SrmMiniSystem.totalStudents);
    }
}