


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        //write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();     //input http://codegym.cc/alpha/index.html?lvl=15&view&name=Amigo

            /* example 2 input: http://codegym.cc/alpha/index.html?obj=3.14&name=Amigo
             Output:
             obj name
             double: 3.14 */

            String [] params = line.split("\\?");   // first major diviision
            List<String> parameters = new ArrayList<>();
            List<String> values = new ArrayList<>();
            if(params.length == 2){          // if we have 2 halfs
                String []  useparams = params[1].split("&");   // take the 2nd part  lvl=15&view&name=Amigo
                for(int i = 0; i < useparams.length; i++){    // loop though lvl=15&view&name=Amigo
                    if(useparams[i].contains("=")){     // if any part contains "="
                        String [] parsed = useparams[i].split("=");    // then split the part and put it inside and array
                        parameters.add(parsed[0]);               // add the first part [0] into the parameters list
                        if(parsed[0].contains("obj")){           // if the first part [0] contains "obj" the collect the values and add to values arraylist
                            values.add(parsed[1]);
                        }
                    }else{
                        parameters.add(useparams[i]);            // if is has no = , then just add the it as  a parameter .
                    }
                }
            }else{
                System.out.println("Malfunctioned Url");
            }


            for(String p : parameters){
                System.out.print(p + " ");
            }
            System.out.println();

            for(String v : values){
                try {
                    double d = Double.parseDouble(v);
                    alert(d);
                }catch (NumberFormatException e){
                    alert(v);
                }
            }


//            for (Map.Entry<String, String> entry : map.entrySet()){
//                System.out.print(entry.getKey() + " " );
//
//            }
//              System.out.println();
//             for( Map.Entry<String, String> entry : map.entrySet()){
//                 System.out.print(entry.getValue() + " ");
//             }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An exception was thrown" + e);

        }

    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
