package client;

import java.util.ArrayList;
import java.util.List;

public class Client
{

    public static void main(String[] args)
    {
        int[] banana = {0, 10};
        int[] banana2 = {50, 50};
        int[] banana3 = {2, 8};
        int[] banana4 = {32, 83};
        int[] banana5 = {1, 3, 10};
        int[] banana6 = {33, 43, 70};
        int[] banana7 = {1, 6, 8, 9};
        int[] banana8 = {32, 61, 91, 88};

        InsulinDoseCalculatorService service = new InsulinDoseCalculatorService();
        InsulinDoseCalculator proxy = service.getInsulinDoseCalculatorPort();

        System.out.println(proxy.backgroundInsulinDose(79) + " == 22");//22

        System.out.println(proxy.mealtimeInsulinDose(60, 12, 200, 100, 25) + " == 14");//14
        System.out.println(proxy.mealtimeInsulinDose(95, 10, 100, 120, 50) + " == 0");//0
        System.out.println(proxy.mealtimeInsulinDose(120, 14, 170, 100, 60) + " == 8");//8

        System.out.println(proxy.personalSensitivityToInsulin(5, arrayToList(banana), arrayToList(banana2)) + " == 50");//50
        System.out.println(proxy.personalSensitivityToInsulin(6, arrayToList(banana3), arrayToList(banana4)) + " == 66");//66
        System.out.println(proxy.personalSensitivityToInsulin(0, arrayToList(banana5), arrayToList(banana6)) + " == 30");//30
        System.out.println(proxy.personalSensitivityToInsulin(4, arrayToList(banana7), arrayToList(banana8)) + " == 53");//53
    }

    /**
     * Instead of passing an int[] to a web service, pass a List<Integer>.
     * <p>
     * This method converts an array of int to a List of Integer. When a web
     * service publishes a method that receives an int[] as parameter, the type
     * gets converted to a "sequence" in XML, and the client should therefore
     * submit, as parameter, a List<Integer> instead of an int[]. The web
     * service will still receive an int[] on the server side.
     *
     * @param array the array of int, to be converted to List<Integer>
     * @return a list containing the same numbers as the array
     */
    static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : array)
            list.add(i);
        return list;
    }
}
