public class PhoneNumber {

    public static void main(String[] args){
        //Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder phoneNumber = new StringBuilder();
        StringBuilder stringNumbers = new StringBuilder();
        if(numbers.length != 10) throw new IllegalArgumentException("Length must be 10");
        for (int i : numbers) {
            stringNumbers.append(String.valueOf(i));
        }
        phoneNumber.append("(");
        phoneNumber.append(stringNumbers.substring(0, 3));
        phoneNumber.append(") ");
        phoneNumber.append(stringNumbers.substring(3, 6));
        phoneNumber.append("-");
        phoneNumber.append(stringNumbers.substring(6, 10));
        return phoneNumber.toString();
      }
}
