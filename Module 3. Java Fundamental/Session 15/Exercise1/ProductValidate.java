public class ProductValidate {

    public static boolean checkName(String name) {
        return name != null && name.length() > 0 && name.length() <= 100;
    }

    public static boolean checkPrice(float price) {
        return price > 0;
    }

    public static boolean checkTitle(String title) {
        return title != null && title.length() <= 200;
    }

    public static boolean checkCatalog(String catalog) {
        return catalog != null && !catalog.trim().isEmpty();
    }
}
