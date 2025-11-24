import java.util.Scanner;

public class BaiTH1 {
    public static void main(String[] args) {
        // Khai báo biến
        String customerName;
        String productName;
        float productPrice;
        int quantity;
        boolean hasMemberShip;
        final float VAT = 0.08f;
        final float discountRate = 0.1f;
        // Yêu cầu nhập
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng: ");
        customerName = input.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        productName = input.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        productPrice = input.nextFloat();
        System.out.println("Nhập số lượng sản phẩm: ");
        quantity = input.nextInt();
        System.out.println("Khách hàng có Membership hay không? Nhập true/false: ");
        hasMemberShip = input.nextBoolean();
        float totalPrice = productPrice*quantity;
        if(hasMemberShip){
            float priceAfterDiscount = (float) totalPrice - (totalPrice*discountRate);
            System.out.printf("Tổng số tiền phải trả là: %f\n",priceAfterDiscount);
        }
        System.out.println(totalPrice);
    }
}
