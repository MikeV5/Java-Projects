public class DRoot {
    
    public static void main(String[] args){
        System.out.println(digital_root(165));
    }


    public static int digital_root(int n) {
        if(n<10) return n;
        return digital_root(digital_root(n%10)+digital_root(n/10)); //digital_root(n%10) or n%10
    }

}
