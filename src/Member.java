public class Member {
    String name;
    boolean isPremium;
    String payMethod;
    double totalSpent;
    boolean monthlyPaid;

    public Member(String name, boolean isPremium, String payMethod, 
                    double totalSpent, boolean monthlyPaid) {
        this.name = name;
        this.isPremium = isPremium;
        this.payMethod = payMethod;
        this.totalSpent = totalSpent;
        this.monthlyPaid = monthlyPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

// Make sure to add each purchase to the total with this method
    public void calculateTotalSpent(double totalSpent, double purchase) {
        this.totalSpent = totalSpent + purchase;
    }

    public boolean isMonthlyPaid() {
        return monthlyPaid;
    }

    public void setMonthlyPaid(boolean monthlyPaid) {
        this.monthlyPaid = monthlyPaid;
    }
        
}
